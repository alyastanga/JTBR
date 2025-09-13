package com.JTBR_management_system.JTBR.db;

import com.JTBR_management_system.JTBR.utils.load.LoadDatabase;

public class DbSetup {
	
	public DbSetup(){
		createDB();
		seedDB();
	}

	public void createDB() {
		try {
			var conn = DbConnection.getConnection();
			var stmt = conn.createStatement();
			
			String sql = new LoadDatabase("/schema/jtbrSchema.sql").load();
			for(String s : sql.split(";")) {
				if (!s.trim().isEmpty()) {
					stmt.execute(s);
				}
			}
			stmt.close();
			conn.close();
			System.out.println("Database created successfully");
			
			
		}catch (Exception e) {
			System.out.println("an error occurred: " + e.getMessage());
		}
	}
	
	public void seedDB() {
		try {
			var conn = DbConnection.getConnection();
			var stmt = conn.createStatement();
			
			String sql = new LoadDatabase("/seed/seed.sql").load();
			for(String s : sql.split(";")) {
				if (!s.trim().isEmpty()) {
					stmt.execute(s);
				}
			}
			stmt.close();
			conn.close();
			System.out.println("Database seeded successfully");
			
			
		}catch (Exception e) {
			System.out.println("an error occurred: " + e.getMessage());
		}
	}
}
