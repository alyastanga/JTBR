package com.JTBR_management_system.JTBR.views;
import javax.swing.JPanel;
import com.JTBR_management_system.JTBR.utils.Colors;

public  class Views extends JPanel{
	public  void initComponents() {
		this.setBackground(Colors.LightBlack);
	}
	public String getViewName() {
		System.out.println("On Show: " + this.getClass().getSimpleName());
		return "On Show: " + this.getClass().getSimpleName();
	}
	
	
}
