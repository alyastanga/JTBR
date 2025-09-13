package com.JTBR_management_system.JTBR.utils.load;

import java.awt.Font;
import java.io.InputStream;


public class Fonts extends Load{

	public Fonts(String path) {
		if(path.equalsIgnoreCase("Montserrat")) {
			path = "Montserrat/Montserrat-Regular.ttf";
		}
		load("assets/fonts/" + path);
	}

	public Font Font(String style1, float size){
		try {
			InputStream inputStream = getInputStream();
			if(inputStream != null) {
				Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
				if(style1.equalsIgnoreCase("bold")) {
					return font.deriveFont(Font.BOLD, (int) size);
				}else if(style1.equalsIgnoreCase("italic")) {
					return font.deriveFont(Font.ITALIC, (int) size);
				}else if(style1.equalsIgnoreCase("bold italic")) {
					return font.deriveFont(Font.BOLD + Font.ITALIC , (int) size);
				}
				else {
					return font.deriveFont(Font.PLAIN, (int) size);
				}
				
			}else {
				System.err.println("Font resource not found" );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new Font("Montserrat", Font.PLAIN, (int) size);
	}
	

	
}