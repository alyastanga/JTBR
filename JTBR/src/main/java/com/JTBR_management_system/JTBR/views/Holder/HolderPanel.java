package com.JTBR_management_system.JTBR.views.Holder;

import javax.swing.JPanel;

import com.JTBR_management_system.JTBR.utils.Colors;
import com.JTBR_management_system.JTBR.utils.components.RoundedPanel;
import com.JTBR_management_system.JTBR.views.Views;

import net.miginfocom.swing.MigLayout;

public class HolderPanel extends Views{
	private RoundedPanel sidebar;
	private RoundedPanel topbar;
	private ContentPanel contentPanel;
	
	
	public HolderPanel() {
		initComponents();
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		setLayout(new MigLayout("fill, debug ", "[200px]10px[grow]", "[300px][500px]"));
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
		topbar.add(new ContentPanel(), "cell 0 0, grow");
		return topbar;
	}
	
	private ContentPanel initMainPanel() {
		contentPanel = new ContentPanel();
		return contentPanel;
	}

}
