package com.tasif.statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.tasif.utility.JDBCUtility;
import com.tasif.utility.Utility;

public class CallableStatements {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		CallableStatement callableStatement = null;
		connection = JDBCUtility.getMySQLConnection();
		System.out.println("Enter the eid");
		int id = Utility.inputInteger();
		callableStatement = connection.prepareCall("call salary(?)");
		callableStatement.setInt(1, id);
		callableStatement.execute();
		System.out.println("Procedure executed successfully ");
		JDBCUtility.cleanup(callableStatement, connection);

	}

}
