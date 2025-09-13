package com.JTBR_management_system.JTBR.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final String URL = "jdbc:sqlite:jtbr.db";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			 System.out.println("Connection failed: " + e.getMessage());
			return null;
		}
	}

}
