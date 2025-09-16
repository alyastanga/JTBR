package com.JTBR_management_system.JTBR;

import java.awt.*;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class CardLay extends JFrame{
	private JPanel cardPanel;
	
	
	public CardLay() {
		initComponents();
	}
	
	private void initComponents() {
		setTitle("Card Layout Example");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		CardLayout cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		JPanel panel = new JPanel(new MigLayout("fill", "[grow]", "[grow]"));
		panel.add(cardPanel, "cell 0 0, grow");
		add(panel);
		
		JButton btn1 = new JButton("Show Panel 1");
		JButton btn2 = new JButton("Show Panel 2");
		JButton btn3 = new JButton("Show Panel 3");
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLUE);
		
		panel.add(btn1, "cell 0 1");
		panel.add(btn2, "cell 0 1");
		panel.add(btn3, "cell 0 1");
		
		cardPanel.add(panel1, "Panel 1");
		cardPanel.add(panel2, "Panel 2");
		cardPanel.add(panel3, "Panel 3");
		
		btn1.addActionListener(e -> cardLayout.show(cardPanel, "Panel 1"));
		btn2.addActionListener(e -> cardLayout.show(cardPanel, "Panel 2"));
		btn3.addActionListener(e -> cardLayout.show(cardPanel, "Panel 3"));
		
		cardLayout.show(cardPanel, "Panel 1");
		
	}

}
