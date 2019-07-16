package com.capgemini.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollableResultSet {

	public static void main(String[] args) {
		try(Connection connection=DBconnection.getConnection();
				PreparedStatement statement=connection.prepareStatement
						(" select * from emp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);)
		{
			ResultSet resultset=statement.executeQuery();
			System.out.println(resultset.getInt(1)+"  "+ resultset.getString(2)+ " "+resultset.getDouble("sal"));
			System.out.println("5th row ");
			resultset.absolute(5);
			System.out.println(resultset.getInt(1)+"  "+ resultset.getString(2)+ " "+resultset.getDouble("sal"));
			System.out.println(" 1st row");
			resultset.first();
			System.out.println(resultset.getInt(1)+"  "+ resultset.getString(2)+ " "+resultset.getDouble("sal"));
			System.out.println(" 2nd row");
			resultset.absolute(2);
			System.out.println(resultset.getInt(1)+"  "+ resultset.getString(2)+ " "+resultset.getDouble("sal"));
			/*resultset.updateDouble("sal", 8888);
			resultset.updateRow();
			System.out.println("After update of 2nd row");
			resultset.absolute(2);
			System.out.println(resultset.getInt(1)+"  "+ resultset.getString(2)+ " "+resultset.getDouble("sal"));*/
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
