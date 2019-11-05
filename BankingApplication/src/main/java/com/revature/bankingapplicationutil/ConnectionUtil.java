package com.revature.bankingapplicationutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
		public static Connection getConnection() throws SQLException {
			String url = System.getenv("BANKINGAPP_DB_URL");
			String username = System.getenv("BANKINGAPP_DB_USERNAME");
			String password = System.getenv("BANKINGAPP_DB_PASSWORD");
			return DriverManager.getConnection(url, username, password);
		}
}