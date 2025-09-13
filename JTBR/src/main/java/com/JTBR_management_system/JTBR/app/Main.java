package com.JTBR_management_system.JTBR.app;

import com.JTBR_management_system.JTBR.db.DbSetup;

public class Main {
	public static void main(String[] args) {
		new DbSetup();
		new App();
	}
}
