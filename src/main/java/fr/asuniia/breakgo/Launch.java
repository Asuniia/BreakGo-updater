package fr.asuniia.breakgo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.naming.ldap.StartTlsRequest;

import com.google.gson.Gson;

import fr.asuniia.breakgo.configuration.Configuration;
import fr.asuniia.breakgo.logger.Logger;
import fr.asuniia.breakgo.network.Network;
import fr.asuniia.breakgo.system.Updater;
import fr.asuniia.breakgo.utils.FileUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launch {

    public static Logger log = new Logger("	Updater");
    public static Configuration config;
    
	public static Stage primaryStage;
	public static Pane mainLayout;
	
	static File folder = new File("BreakGo");

	public static void main(String[] args) throws IOException {
		
		config = loadConf();
			
		checkUpdate();
	}
	
	public static void load() {
		Application.launch();
	}
	
	
    public static Configuration loadConf() {
		folder.mkdir();
        log.info("Lecture du fichier de mise à jour..");
        File file = new File("config.json");
        String json = FileUtils.getFileContent(file);
        return new Gson().fromJson(json, Configuration.class);
    }

    
    public static void checkUpdate() {
    	log.info("Vérification des mise à jour..");
    	Network.makeRequest();
    }

    
    
}
