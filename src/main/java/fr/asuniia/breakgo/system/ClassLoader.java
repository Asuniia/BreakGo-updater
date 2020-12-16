package fr.asuniia.breakgo.system;

import java.io.IOException;

import fr.asuniia.breakgo.Launch;
import fr.asuniia.breakgo.network.Network;

public class ClassLoader {
	
	public static Launch m;
	
	public static void setup() throws IOException {
		Runtime.getRuntime().exec("java -jar " + m.config.getApp() + "/" + m.config.getApp() + "-" + Network.inputLine + ".jar");
	}

}
