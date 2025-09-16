package com.JTBR_management_system.JTBR.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.JTBR_management_system.JTBR.views.Holder.LoginMainHolder;

public class App extends JFrame{
	public App() {
		SwingUtilities.invokeLater(() -> {
			setTitle("JTBR Management System");
			setSize(800, 600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			add(new LoginMainHolder());
			setVisible(true);
		});
		
	}
}
