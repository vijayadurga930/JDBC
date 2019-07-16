package com.capgemini.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {
	
	static Connection connection= null;
	static Statement statement=null;
	static ResultSet resultSet=null;
	public static void main(String[] args) {
		 try {
			connection=DBconnection.getConnection();
			 statement=connection.createStatement();
			 resultSet=statement.executeQuery("select * from emp");
			 
			 while(resultSet.next()) {
				 System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString("ename")+
						 "\t"+resultSet.getString("job") + "\t"+resultSet.getDouble("sal"));
			 }
		} 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		 
		 
	}

}
