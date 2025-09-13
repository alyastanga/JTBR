package com.JTBR_management_system.JTBR.utils.load;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LoadImage extends Load {
		
		public LoadImage(String path) {
			load("assets/images/" + path);
		}
		
		BufferedImage getImage() {
			try {
				return  ImageIO.read(getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
}
