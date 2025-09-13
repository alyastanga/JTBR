package com.JTBR_management_system.JTBR.utils.components;

import java.awt.Color;

import javax.swing.JTextField;

import com.JTBR_management_system.JTBR.utils.Colors;
import com.JTBR_management_system.JTBR.utils.load.Fonts;


public class TextField extends JTextField {
	
	public TextField(String text, int size){
		setText(text);
		setForeground(Color.white);
		setBackground(Colors.White);
		setFont(new Fonts("Montserrat").Font("plain", size));
		}
}
