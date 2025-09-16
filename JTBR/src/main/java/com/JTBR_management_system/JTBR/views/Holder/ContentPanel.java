package com.JTBR_management_system.JTBR.views.Holder;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.JTBR_management_system.JTBR.utils.navigation.Navigate;
import com.JTBR_management_system.JTBR.views.DashboardPanel;
import com.JTBR_management_system.JTBR.views.Views;

public class ContentPanel extends Views{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	public ContentPanel() {
		initComponents();
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		cardLayout = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		
		new Navigate().init(cardPanel, cardLayout);
		cardPanel.add(new DashboardPanel(), "Dashboard");
		cardLayout.show(cardPanel, "Dashboard");
	}
}
