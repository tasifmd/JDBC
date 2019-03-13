package com.tasif.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tasif.utility.JDBCUtility;
import com.tasif.utility.Utility;

public class LoginPrepareStatement {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null;
		connection = JDBCUtility.getMySQLConnection();
		System.out.println("Choose your option \n1.Register \t 2.Login");
		int choice = Utility.inputInteger();
		switch(choice) {
		case 1:
			String insert = "insert into login values(?,?)";
			preparedStatement = connection.prepareStatement(insert);
			System.out.println("Enter uid");
			int uid = Utility.inputInteger();
			System.out.println("Enter password");
			String password = Utility.inputSingleString();
			preparedStatement.setInt(1, uid);
			preparedStatement.setString(2, password);
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " Row affected");
			break;
		case 2:
			System.out.println("Enter the uid");
			int id = Utility.inputInteger();
			System.out.println("Enter the Password");
			String pass = Utility.inputSingleString();
			String validate = "select * from login where uid = ? and pass = ?";
			preparedStatement = connection.prepareStatement(validate);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, pass);
			resultSet = preparedStatement.executeQuery();
			boolean grant  = resultSet.next();
			if(grant) {
				System.out.println("Login Success");
			}
			else {
				System.out.println("Login Failed");
			}
		}
		
	}

}
