package fr.asuniia.breakgo.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;


import fr.asuniia.breakgo.Launch;
import fr.asuniia.breakgo.network.Network;
import fr.asuniia.breakgo.utils.FileUtils;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Updatecontrol implements Initializable {
	
	public Label majinfo;
	public ProgressBar progress;
	public static Launch m;
	
	public File repo = new File("BreakGo");
	
	Path in = Paths.get(m.config.getDirIn());
	Path out = Paths.get(m.config.getDirOut());

	public void initialize(URL location, ResourceBundle resources) {
		majinfo.setText(m.config.getVer() + " -> " + Network.inputLine);
		progress.setProgress(0.1);
		
		if(!repo.exists()) {
			repo.mkdir();
			progress.setProgress(0.25);
			Network.downloadFile(m.config.getURL() + m.config.getApp() + "_versions/" + Network.inputLine + "/file.lak", repo,m.config.getApp() +  "-" + Network.inputLine);
			progress.setProgress(0.35);
			progress.setProgress(1);
		} else {
			progress.setProgress(0.4);
			Network.downloadFile(m.config.getURL() + m.config.getApp() + "_versions/" + Network.inputLine + "/file.lak", repo, m.config.getApp() + "-" + Network.inputLine);
			progress.setProgress(0.6);
			//UNZIP HERE 
			//FileUtils.unzip("BreakGo/BreakGo" + Network.inputLine);
			try {
				FileUtils.unzip(in,out);
			} catch (IOException e) {
				e.printStackTrace();
			}
			progress.setProgress(1);
		}
		
	}

}
