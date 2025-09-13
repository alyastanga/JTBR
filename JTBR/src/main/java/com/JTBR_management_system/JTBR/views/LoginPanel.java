package com.JTBR_management_system.JTBR.views;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.JTBR_management_system.JTBR.utils.Colors;
import com.JTBR_management_system.JTBR.utils.load.Fonts;

import net.miginfocom.swing.MigLayout;

public class LoginPanel extends Views{
	
	private JPanel credHolder;
	private JPanel buttonHolder;
	private JPanel titleHolder;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JButton loginBtn;
	private JLabel titleLabel;
	private JLabel titleLabel2;
	
	public LoginPanel() {
		initComponents();
		getViewName();
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		setLayout(new MigLayout("insets 10, debug", "[grow][grow][grow]", "[grow][][]50[]"));
		add(titlePanel(), "cell 1 0, align center");
		add(credPanel(), "cell 1 1, align center");
		add(buttonPanel(), "cell 1 2, align center");
		
	}
	
	private JPanel credPanel() {
		credHolder = new JPanel();
		credHolder.setBackground(Colors.Black);
		credHolder.setLayout(new MigLayout("wrap", "[grow]", "[][]"));
		
		usernameField = new JTextField("Username");
		passwordField = new JPasswordField("Password");
		
		credHolder.add(usernameField, "cell 0 0, growx, wrap");
		credHolder.add(passwordField, "cell 0 1, growx, wrap");
		
		return credHolder;
	}
	
	private JPanel buttonPanel() {
		buttonHolder = new JPanel();
		buttonHolder.setBackground(Colors.Black);
		buttonHolder.setLayout(new MigLayout("", "[grow]", "[]"));
		
		loginBtn = new JButton("Login");
		loginBtn.setBackground(Colors.Gray);
		buttonHolder.add(loginBtn, "growx");
		
		loginBtn.addActionListener(e -> {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			System.out.println("Username: " + username + ", Password: " + password);
			
		});
		return buttonHolder;
	}
	
	private JPanel titlePanel() {
		titleHolder = new JPanel();
		titleHolder.setBackground(Colors.LightBlack);
		titleHolder.setLayout(new MigLayout("", "[grow]", "[]"));
		
		titleLabel = new JLabel("JTBR");
		titleLabel.setForeground(Colors.White);
		titleLabel.setBackground(Colors.LightBlack);
		titleLabel.setFont(new Fonts("Montserrat").Font("bold", 128));
		
		titleLabel2 = new JLabel("Management System");
		titleLabel2.setForeground(Colors.White);
		titleLabel2.setBackground(Colors.LightBlack);
		titleLabel2.setFont(new Fonts("Montserrat").Font("plain", 16));
		
		titleHolder.add(titleLabel, "cell 0 0, alignx center, wrap");
		titleHolder.add(titleLabel2, "cell 0 1, alignx center");
		
		return titleHolder;
	}
	
	

}


