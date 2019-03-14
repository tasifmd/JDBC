package com.tasif.batchprocessing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tasif.utility.JDBCUtility;

public class BatchProcessingPrepairedStatement {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null ;
		connection = JDBCUtility.getMySQLConnection();
		String query  = "insert into employee values (?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1,107);
		preparedStatement.setString(2, "Amit");
		preparedStatement.setString(3, "Kumar");
		preparedStatement.setString(4, "amit@gmail.com");
		preparedStatement.addBatch();
		preparedStatement.setInt(1,108);
		preparedStatement.setString(2, "Alok");
		preparedStatement.setString(3, "Pandey");
		preparedStatement.setString(4, "alok@gmail.com");
		preparedStatement.addBatch();
		int[] row = preparedStatement.executeBatch();
		System.out.println(row.length + " Rows Affected");
		JDBCUtility.cleanup(preparedStatement, connection);
	}

}
