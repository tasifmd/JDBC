package com.tasif.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tasif.utility.JDBCUtility;

public class Transaction {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null ;
		connection = JDBCUtility.getMySQLConnection();
		statement = connection.createStatement();
		connection.setAutoCommit(false);
		String query1 = "insert into employee values (105,'Bhupi','Singh','bhupi@gmail.com')";
		int row = statement.executeUpdate(query1);
		String query2 = "insert into employee values (106,'Rohan','Sharma','rohan@gmail.com')";
		row = row + statement.executeUpdate(query2);
		System.out.println(row + " Number of rows affected");
		connection.commit();
	}

}
