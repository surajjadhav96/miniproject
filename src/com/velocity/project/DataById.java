package com.velocity.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public final class DataById {
	
	PreparedStatement pStatement = null;
	Connection con = null;
	
	public void getDataById() {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter your Id to check your score: ");
		int id1 = sc.nextInt();
	
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			con = connectionTest.getConnectionDetails();
			pStatement = con.prepareStatement("select * from score where score_id  =?");
			pStatement.setInt(1, id1);
			
		//	ResultSet resultSet = pStatement.getResultSet();
			ResultSet resultSet = pStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("Student id: " + resultSet.getInt(1));
				System.out.println("Student_Name: " + resultSet.getString(2));
				System.out.println("Score is: " + resultSet.getInt(3));
				System.out.println("==============================================");
			}
			else {
				System.out.println("No records found.....");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
