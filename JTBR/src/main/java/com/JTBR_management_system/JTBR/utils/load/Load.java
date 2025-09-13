package com.JTBR_management_system.JTBR.utils.load;

import java.io.*;

public class Load {
	
	private InputStream in; 
	
	public void load(String path) {
		try {
			in = Load.class.getClassLoader().getResourceAsStream(path);
			
			if (in == null) {
				throw new FileNotFoundException("File not found: " + path);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public InputStream getInputStream() {
		return in;
	}

}
