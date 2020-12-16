package fr.asuniia.breakgo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtils {

    /**
     * Create file.
     *
     * @param file the file
     * @return
     * @throws IOException the io exception
     */
    public static File createFile(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * Save.
     *
     * @param file the file
     * @param txt  the txt
     */
    public static void save(File file, String txt) {
        final FileWriter fw;
        createFile(file);
        try {
            createFile(file);
            fw = new FileWriter(file);
            fw.write(txt);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets file content.
     *
     * @param file the file
     * @return the file content
     */
    public static String getFileContent(File file) {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            final StringBuilder text = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line);
            }

            reader.close();

            return text.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public static void unzip(Path source, Path target) throws IOException {

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source.toFile()))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                boolean isDirectory = false;
                if (zipEntry.getName().endsWith(File.separator)) {
                    isDirectory = true;
                }

                Path newPath = zipSlipProtect(zipEntry, target);

                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {
                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }
                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);

                }

                zipEntry = zis.getNextEntry();

            }
            zis.closeEntry();

        }

    }
    
    public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {
    	
            Path targetDirResolved = targetDir.resolve(zipEntry.getName());
            Path normalizePath = targetDirResolved.normalize();
            if (!normalizePath.startsWith(targetDir)) {
                throw new IOException("Bad zip entry: " + zipEntry.getName());
            }

            return normalizePath;
        }

    public static File[] getFiles(File folder) {
        return folder.listFiles();
    }

}
