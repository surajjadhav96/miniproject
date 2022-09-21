package com.velocity.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class InsertInfo {
	PreparedStatement pStatement = null;
	Connection con = null;

	public void insertStudentData(String student_name) {
		try {
			// Create the prepared statement
			ConnectionTest connectionTest = new ConnectionTest();
			con = connectionTest.getConnectionDetails();
			
			// Prepare the sql
			pStatement = con.prepareStatement("insert into score (student_name) values (?)");
			
			pStatement.setString(1, student_name);
		
//			pStatement.setInt(2, student_score);

			int i = pStatement.executeUpdate();
			System.out.println("Record is inserted successfully: " + i);
			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userInput() {
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter Student Name: ");
			String student_Name = sc.next();
			
			
			//InsertInfo insertInfo = new InsertInfo();
			//insertStudentData(student_Name);
		
		
		sc.close();
	}
	
	
	
	
	
	

}
