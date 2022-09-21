package com.velocity.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class RetrieveStudentData {

	PreparedStatement pStatement = null;
	Connection con = null;

	public void printStudentData() {
		try {
			// Create the prepared statement
			ConnectionTest connectionTest = new ConnectionTest();
			con = connectionTest.getConnectionDetails();

			// Prepare the sql
			pStatement = con.prepareStatement("select * from score order by student_name");
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Student Name: " + rs.getString(2));
				System.out.println("Score is: " + rs.getInt(3));
				

				if (rs.getInt("student_score") >= 8) {
					System.out.println("Your grade is Class-A");
				} else if (rs.getInt("student_score") >= 6 && rs.getInt("student_score") < 8) {
					System.out.println("Your grade is Class-B");
				} else if (rs.getInt("student_score") == 5) {
					System.out.println("Your grade is Class-C");
				} else {
					System.out.println("You are failed in quiz");
				}
				System.out.println("==============================================");
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
