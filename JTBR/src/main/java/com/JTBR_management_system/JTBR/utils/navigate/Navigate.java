package com.JTBR_management_system.JTBR.utils.navigate;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;


public class Navigate {
	
	private static CardLayout cardLayout;
	private static JPanel panelHolder;
	private static Map<String, JPanel> panels = new HashMap<>();
	
	public void init(JPanel container, CardLayout layout) {
		panelHolder = container;
		cardLayout = layout;
	}
	
	private void showPanel(String name) {
		if(cardLayout != null && panelHolder != null) {
			cardLayout.show(panelHolder, name);
			System.out.println("Showing: " + name);
		}
	}
	
	public void showPanel(String name, JPanel panel) {
		if(cardLayout == null || panelHolder == null) return;
		
		if(!panels.containsKey(name)){
			panelHolder.revalidate();
			panelHolder.repaint();
			panelHolder.add(panel, name);
			panels.put(name, panel);
			System.out.println("Created: " + name);
		}else {
			System.out.println("Panel unsuccessfully created: " + name);

		}
		showPanel(name);
	}
	
	public void remove(String name, JPanel panel) {
		if(cardLayout != null && panelHolder != null) {
			if(panels.containsKey(name)) {
			   panels.remove(name);
			   panelHolder.remove(panel);
			   panelHolder.revalidate();
			   panelHolder.repaint();
			   System.out.println("Removed: " + name);
			}
		}
	}
	
}