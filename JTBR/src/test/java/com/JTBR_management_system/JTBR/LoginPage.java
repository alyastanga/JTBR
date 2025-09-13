package com.JTBR_management_system.JTBR;

import javax.swing.JFrame;

import com.JTBR_management_system.JTBR.views.LoginPanel;

public class LoginPage extends JFrame {
	private LoginPanel loginPanel;
	
	public static void main(String[] args) {
		new LoginPage();
	}
	
	public LoginPage() {
		setTitle("Login Page");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		loginPanel = new LoginPanel();
		add(loginPanel);
		
		setVisible(true);
	}
}
