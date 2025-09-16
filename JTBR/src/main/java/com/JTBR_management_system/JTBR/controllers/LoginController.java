package com.JTBR_management_system.JTBR.controllers;

import com.JTBR_management_system.JTBR.dao.UsersDAO;
import com.JTBR_management_system.JTBR.utils.navigation.Navigate;
import com.JTBR_management_system.JTBR.views.LoginPanel;

public class LoginController {
	private LoginPanel loginPanel;
	private UsersDAO usersDAO;
	
	public LoginController(LoginPanel loginPanel, UsersDAO usersDAO) {
		this.loginPanel = loginPanel;
		this.usersDAO = usersDAO;
		initController();
	}
	
	public void initController() {
		loginPanel.loginListener(e -> {
			String username = loginPanel.getUsername();
			String password = loginPanel.getPassword();
			System.out.println("Username: " + username + ", Password: " + password);	
		});
	}
	
	
	
}
