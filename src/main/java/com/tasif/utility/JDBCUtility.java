package com.tasif.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtility {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getMySQLConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tasifdb";
		Connection connection = DriverManager.getConnection(url, "root" , "MD@tasif96");
		return connection;
	}
	
	public static void cleanup(Statement statement,Connection connection) throws SQLException {
		if(statement != null) 
			statement.close();
		if(connection != null)
			connection.close();
		
	}
	
	public static  void cleanup(ResultSet resultset , Statement statement ,Connection connection) throws SQLException {
		if(resultset != null)
			resultset.close();
		if(statement != null) 
			statement.close();
		if(connection != null)
			connection.close();
	}
}
