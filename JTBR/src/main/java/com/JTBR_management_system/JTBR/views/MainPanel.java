package com.JTBR_management_system.JTBR.views;

import java.awt.CardLayout;

import com.JTBR_management_system.JTBR.utils.navigate.Navigate;

public class MainPanel extends Views{
	private CardLayout cardLayout;
	
	public MainPanel() {
		initComponents();
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		new Navigate().init(new MainPanel(), cardLayout);
		add(new DashboardPanel(), "Dashboard");
		//cardLayout.show(new MainPanel(), "Dashboard");
	}
	
}
