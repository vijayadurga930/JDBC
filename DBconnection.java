package com.capgemini.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static Connection connection=null;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//for loading//
			//**DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver() );//(for registering)
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url, "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
			
		}
	/*public static void main(String[] args) {
		System.out.println(DBconnection.getConnection());
		
	}*/
}
