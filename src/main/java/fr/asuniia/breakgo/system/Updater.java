package fr.asuniia.breakgo.system;

import java.net.URL;

import fr.asuniia.breakgo.Launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Updater extends Application {
	
	public static Stage primaryStage;
	public static Pane mainLayout;
	public static Stage frame;
	
	public static Launch m;

	public static void Center() {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		frame = primaryStage;
 		FXMLLoader loader = new FXMLLoader();
 		URL url = getClass().getResource("/UpdateUI.fxml");
 		loader.setLocation(url);
 		mainLayout = loader.load();
 		Scene sc = new Scene(mainLayout);
 		frame = new Stage();
 		frame.setResizable(false);
 		frame.setTitle("Mise à jour de " + m.config.getApp() + " en cours..");
 		frame.setScene(sc);
 		frame.show();
 		sc.setRoot(mainLayout);
	}

}
