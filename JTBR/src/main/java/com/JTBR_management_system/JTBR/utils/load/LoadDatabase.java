package com.JTBR_management_system.JTBR.utils.load;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoadDatabase extends Load{

	public LoadDatabase(String path) {
		load("database/" + path);
	}
	
	public String load() {
		byte[] encoded;
		String text = null;
		try {
			encoded = getInputStream().readAllBytes();
			text = new String(encoded, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	

}
