package com.tasif.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.tasif.utility.JDBCUtility;

public class SavePoint {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null ;
		Savepoint savePoint  = null;
		connection = JDBCUtility.getMySQLConnection();
		statement = connection.createStatement();
		connection.setAutoCommit(false);
		savePoint  = connection.setSavepoint("Saved");
		String query1 = "insert into employee values (109,'Bhupi','Singh','bhupi@gmail.com')";
		int row = statement.executeUpdate(query1);
		String query2 = "insert into employee values (110,'Rohan','Sharma','rohan@gmail.com')";
		row = row + statement.executeUpdate(query2);
		System.out.println(row + " Number of rows affected");
		connection.rollback(savePoint);
		connection.commit();
		System.out.println("Rolled backed to last commit");

		JDBCUtility.cleanup(statement, connection);
	}

}

