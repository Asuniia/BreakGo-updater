package fr.asuniia.breakgo.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;

import fr.asuniia.breakgo.Launch;
import fr.asuniia.breakgo.logger.Logger;
import fr.asuniia.breakgo.system.ClassLoader;
import fr.asuniia.breakgo.system.Updater;


public class Network {
	
	public static Launch m;
    public static String inputLine;
    
    public static Logger log = new Logger("Updater");
    
	public static void downloadFile(String url, File file,String name_file) {
        try {
            FileOutputStream fos = new FileOutputStream(file + "/" + name_file + ".lak");
            fos.getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()), 0, Long.MAX_VALUE);
            fos.close();
          }
          catch(Exception e) {
            log.error("Une erreur est survenue pendant le téléchagement de : " + name_file + " URL : " + url);
          }
	}
	
	public static void makeRequest() {
	
		try {
			final String urll = new String(m.config.getURL() + m.config.getApp() + "/Versions.info");
	        final URL url = new URL(urll);
	        final URLConnection conn = url.openConnection();
	        final BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        boolean version;
	        while ((inputLine = br.readLine()) != null) {
	        	if(!inputLine.toLowerCase().contains(m.config.getVer())) {
	        		log.info("Mise à jour disponible : " + m.config.getVer() + " -> " + inputLine);
	        		Updater.Center();
	        	} else {
	        		log.info("Aucune mise à jour à été déployé.");
	        		ClassLoader.setup();
	        	}
	        }
		} catch (Exception e) {
		}
		
	}
	
}
