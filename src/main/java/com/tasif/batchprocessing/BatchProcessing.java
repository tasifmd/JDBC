package com.tasif.batchprocessing;

import java.sql.Connection;
import java.sql.SQLException;

import com.tasif.utility.JDBCUtility;

public class BatchProcessing {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		java.sql.Statement statement = null ;
		connection = JDBCUtility.getMySQLConnection();
		statement = connection.createStatement();
		String query  = "insert into employee values (102,'Punit','Arrora','punit@xyz.com')";
		statement.addBatch(query);
		query  = "insert into employee values (104,'Bibhu','Dande','bibhu@xyz.com')";
		statement.addBatch(query);
		query  = "update employee set lname = 'Anand' where eid = 104";
		statement.addBatch(query);
		int [] row = statement.executeBatch();
		System.out.println(row.length + " Rows affected");
	}

}
