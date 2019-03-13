package com.tasif.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tasif.utility.JDBCUtility;
import com.tasif.utility.Utility;

public class PrepereStatementsCURD {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null;
		connection = JDBCUtility.getMySQLConnection();
		boolean flag = false;
		do {
			System.out.println("Enter your choice \n1.Select \t2.Insert \t3.Update \t4.Delete \t5.Exit");
			int choice = Utility.inputInteger();
			switch(choice) {
			case 1 :
				System.out.println("Enter the eid");
				int id = Utility.inputInteger();
				String validate = "select * from employee where eid = ?";
				preparedStatement = connection.prepareStatement(validate);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				boolean value = resultSet.next();
				if(value) {
					System.out.println("Employe id : " + resultSet.getInt(1) + "\tFirst name : " + resultSet.getString(2) + "\tLast name :" + resultSet.getString(3) + "\tEmail : " + resultSet.getString(4));
				}
				else {
					System.out.println("No such data exist ");
				}
				break;
			case 2 :
				System.out.println("Enter the employee id ");
				int eid = Utility.inputInteger();
				System.out.println("Enter the first name ");
				String firstName = Utility.inputSingleString() ;
				System.out.println("Enter the last name ");
				String lastName = Utility.inputSingleString();
				System.out.println("Enter the email");
				String email = Utility.inputSingleString();
				String insert = "insert into employee values(?,?,?,?)";
				preparedStatement = connection.prepareStatement(insert);
				preparedStatement.setInt(1, eid);
				preparedStatement.setString(2, firstName);
				preparedStatement.setString(3, lastName);
				preparedStatement.setString(4, email);
				int row = preparedStatement.executeUpdate();
				System.out.println(row + " Rows affected");
				break;
			case 3:
				System.out.println("What you want to update \n1.First name \t2.Last Name \t3.Email");
				int temp = Utility.inputInteger();
				switch(temp) {
				case 1:
					System.out.println("Enter the employee id ");
					int emid = Utility.inputInteger();
					System.out.println("Enter the new name ");
					String newFirstName = Utility.inputSingleString();
					String fnameUpdate = "update  employee set fname = ? where eid = ?";
					preparedStatement = connection.prepareStatement(fnameUpdate);
					preparedStatement.setString(1, newFirstName);
					preparedStatement.setInt(2, emid);
					int f = preparedStatement.executeUpdate();
					System.out.println(f + " Rows affected");
					break;
				case 2:
					System.out.println("Enter the employee id ");
					int empid = Utility.inputInteger();
					System.out.println("Enter the new name ");
					String newLastName = Utility.inputSingleString();
					String lnameUpdate = "update  employee set lname = ? where eid = ?";
					preparedStatement = connection.prepareStatement(lnameUpdate);
					preparedStatement.setString(1, newLastName);
					preparedStatement.setInt(2, empid);
					int l = preparedStatement.executeUpdate();
					System.out.println(l + " Rows affected");
					break;
				case 3:
					System.out.println("Enter the employee id ");
					int emplid = Utility.inputInteger();
					System.out.println("Enter the new email ");
					String newemail = Utility.inputSingleString();
					String emailUpdate = "update  employee set email = ? where eid = ?";
					preparedStatement = connection.prepareStatement(emailUpdate);
					preparedStatement.setString(1, newemail);
					preparedStatement.setInt(2, emplid);
					int emal = preparedStatement.executeUpdate();
					System.out.println(emal + " Rows affected");
					break;
				default:
					System.out.println("Invalid Input ");
				}
				break;
			case 4:
				System.out.println("Enter the employee id ");
				int empid = Utility.inputInteger();
				String delete = "delete from employee where eid = ?";
				preparedStatement = connection.prepareStatement(delete);
				preparedStatement.setInt(1, empid);
				int emal = preparedStatement.executeUpdate();
				System.out.println(emal + " Rows affected");
				break;
			case 5:
				System.exit(0);
			}
		}while(flag == false);
	}
}

