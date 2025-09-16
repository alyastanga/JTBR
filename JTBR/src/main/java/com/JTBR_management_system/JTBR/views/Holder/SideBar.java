package com.JTBR_management_system.JTBR.views.Holder;
import com.JTBR_management_system.JTBR.views.Views;

import net.miginfocom.swing.MigLayout;

public class SideBar extends Views{
	public SideBar() {
		initComponents();
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		setLayout(new MigLayout("fill", "[grow]", "[grow]"));
		
	}
}