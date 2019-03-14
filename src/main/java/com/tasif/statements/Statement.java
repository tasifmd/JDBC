package com.tasif.statements;

import java.sql.*;

import com.tasif.utility.JDBCUtility;
import com.tasif.utility.Utility;

public class Statement {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		java.sql.Statement statement = null ;
		ResultSet resultset = null;
		connection = JDBCUtility.getMySQLConnection();
		statement = connection.createStatement();
		System.out.println("Enter your choice \n1.Select \t2.Insert \t3.Update \t4.Delete \t5.Exit");
		int choice = Utility.inputInteger();
		switch(choice) {
		case 1:
			String sql = "select * from employee";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String fname = resultset.getString(2);
				String lname = resultset.getString(3);
				String email = resultset.getString(4);
				System.out.println("Employee id : " + id + " First name : " + fname + " Last name : " + lname + " Email :" + email);
			}
			break;
		case 2:
			
			String insert ="insert into employee values (102 , 'Anshul' , 'Kumar' , 'anshul@gmail.com')";
			int rowUpdated = statement.executeUpdate(insert);
			System.out.println( rowUpdated + " Rows affected");
			break;
		case 3:
			System.out.println("What you want to ubdate \n1.Mobile \t 2.Name");
			int temp = Utility.inputInteger();
			switch(temp) {
			case 1:
				
				String updateMobile = "update employee set email = 'anmol@abc.com' where  eid =101";
				int row = statement.executeUpdate(updateMobile);
				System.out.println( row + " Rows affected");
				break;
			case 2:
				
				String updateName = "update employee set fname = 'arman' , lname = 'khan' where eid = 102";
				int rowCount = statement.executeUpdate(updateName);
				System.out.println(rowCount + " Rows affected");
				break;
			}
			break;
		case 4:
			
			String delete = "delete from employee where eid = 102";
			int row = statement.executeUpdate(delete);
			System.out.println( row + " Rows affected");
			break;
		case 5 :
			System.exit(0);
		}
		JDBCUtility.cleanup(resultset, statement, connection);
	}

}
