package com.JTBR_management_system.JTBR.app;

import javax.swing.JFrame;

import com.JTBR_management_system.JTBR.views.LoginPanel;

public class App extends JFrame{
	public App() {
		setTitle("JTBR Management System");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new LoginPanel());
		
		setVisible(true);
		
	}
}
