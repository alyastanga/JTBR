package com.JTBR_management_system.JTBR.views;

import javax.swing.JPanel;

import com.JTBR_management_system.JTBR.utils.Colors;
import com.JTBR_management_system.JTBR.utils.components.RoundedPanel;
import net.miginfocom.swing.MigLayout;

public class HolderPanel extends Views{
	private RoundedPanel sidebar;
	private RoundedPanel topbar;
	private MainPanel mainPanel;
	
	
	public HolderPanel() {
		initComponents();
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		setLayout(new MigLayout("fill, debug ", "[grow]50px[grow]", "[grow][grow]"));
		add(initSidebar(), "cell 0 0, span 0 2");
		add(initTopbar(), "cell 1 0, grow");
		add(initMainPanel(), "cell 1 1, grow");
		
			
	}
	private RoundedPanel initSidebar() {
		sidebar = new RoundedPanel(Colors.Black, 20);
		return sidebar;
	}
	
	private RoundedPanel initTopbar() {
		topbar = new RoundedPanel(Colors.LightBlack, 20);
		topbar.setLayout(new MigLayout("wrap", "[grow][grow]", "[grow][grow]"));
		topbar.add(new MainPanel(), "cell 0 0, grow");
		return topbar;
	}
	
	private MainPanel initMainPanel() {
		mainPanel = new MainPanel();
		return mainPanel;
	}

}
