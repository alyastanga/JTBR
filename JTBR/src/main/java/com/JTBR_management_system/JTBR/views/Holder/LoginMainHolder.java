package com.JTBR_management_system.JTBR.views.Holder;

import java.awt.CardLayout;

import com.JTBR_management_system.JTBR.controllers.LoginController;
import com.JTBR_management_system.JTBR.dao.UsersDAO;
import com.JTBR_management_system.JTBR.views.LoginPanel;
import com.JTBR_management_system.JTBR.views.Views;

public class LoginMainHolder extends Views{
	private CardLayout cl;

	
	public LoginMainHolder() {
		initComponents();
		
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		cl = new CardLayout();
		setLayout(cl);
		LoginPanel loginPanel = new LoginPanel();
		UsersDAO usersDAO = new UsersDAO();
		HolderPanel holderPanel = new HolderPanel();
		new LoginController(loginPanel, usersDAO);
		add(loginPanel, "Login");
		add(holderPanel, "Holder");
		cl.show(this, "Login");
	}
	
}
