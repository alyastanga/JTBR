package com.JTBR_management_system.JTBR;

import javax.swing.JFrame;

import com.JTBR_management_system.JTBR.views.Holder.HolderPanel;


public class HolderPage extends JFrame {
	public HolderPage() {
		setTitle("JTBR Management System");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new HolderPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		new HolderPage();
	
	}

}
