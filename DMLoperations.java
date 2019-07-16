package com.capgemini.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DMLoperations {
Connection connection=null;
PreparedStatement statement= null;
ResultSet resultset=null;
boolean status=false;
int row=-1;
Scanner scanner=new Scanner(System.in);
public void create() {
	try {
		connection=DBconnection.getConnection();
		String query=" create table trainee(tid number(5) primary key,"+"name varchar2(25),marks number(7,2)) ";
		statement=connection.prepareStatement(query);
		status=statement.execute();
		System.out.println(" table created:"+status);
	} catch (SQLException e)
	{
		e.printStackTrace();
	}	
}
	
	
	public void insert() {
		try {
			System.out.println("enter tid,name,marks");
			int tid=scanner.nextInt();
			String name = scanner.nextLine();
			double marks=scanner.nextDouble();
			connection=DBconnection.getConnection();
			statement=connection.prepareStatement("insert into trainee values(?,?,?");
			statement.setInt(1,tid);
			statement.setString(2,name);
			statement.setDouble(3,marks);
			row=statement.executeUpdate();
			System.out.println(row+" inserted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
		public void update() {
			try {
				System.out.println("enter tid to update");
				int tid=scanner.nextInt();
				System.out.println("enter the new marks");
				double marks=scanner.nextDouble();
				connection=DBconnection.getConnection();
				statement=connection.prepareStatement("update trainee set marks=? where tid=?");
				statement.setDouble(1,marks);
				statement.setInt(2,tid);
				row=statement.executeUpdate();
				System.out.println(row+" updated");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
		}	
			public void delete() {
				try {
					System.out.println("enter tid want to delete");
					int tid=scanner.nextInt();
					connection=DBconnection.getConnection();
					statement=connection.prepareStatement("delete from trainee where tid=?");
					statement.setInt(1,tid);
					row=statement.executeUpdate();
					System.out.println(row+"deleted");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
	} 

			public void viewById() {
				try {
					System.out.println("enter tid want to view");
					int tid=scanner.nextInt();
					connection=DBconnection.getConnection();
					statement=connection.prepareStatement("view trainee where tid=?");
					statement.setInt(1,tid);
					row=statement.executeUpdate();
					System.out.println(row+"viewed");
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
			}
				public void viewAll() {
					try {
						connection=DBconnection.getConnection();
						
						statement=connection.prepareStatement("select * from trainee");
						resultset=statement.executeQuery();
						while(resultset.next())
				        {
				            System.out.println(resultset.getInt("tid")+"\t"+resultset.getString("name")+"\t"+resultset.getInt("marks"));
				        }
				    } catch (SQLException e) {
				       
				        System.out.println(e.getMessage());
				    } 
	}
			
	public static void main(String[] args) {
		DMLoperations dml= new DMLoperations();
	//	dml.create();
		Scanner scanner= new Scanner(System.in);
		System.out.println(" enter 1.insert \n2.update \n3.delete \n4.viewAll \n5.viewById");
		int option=scanner.nextInt();
		switch(option) {
		case 1:
			dml.insert();
			break;
		case 2:
			dml.update();
			break;
		case 3:
			dml.delete();
			break;
		case 4:
			dml.viewAll();
			break;
		case 5:
			dml.viewById();
			break;
			default:
				System.out.println(" enter 1 to 5");
				break;	
		}
		
	}



}
