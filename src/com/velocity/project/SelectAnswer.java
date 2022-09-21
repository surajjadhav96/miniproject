package com.velocity.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SelectAnswer {

	 static String name = null;
	 int id = 0;
	String question = null;
	String option_a = null;
	String option_b = null;
	String option_c = null;
	String option_d = null;
	String answer = null;
	String userans;
	int num=1;
	int key = 0;
	int score_id=0;
   static int count = 0;
	String ch = null;
	Connection conn;
   PreparedStatement ps;
	Scanner sc = new Scanner(System.in);
	Map<Integer, String> hashMap = new HashMap<Integer, String>();
	
	public Connection connectionObject() {
		
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			conn = connectionTest.getConnectionDetails();

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

	public Connection setConnection(Connection conn) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Pratik@1999");
			
			 ps = conn.prepareStatement("SELECT * FROM question ORDER BY RAND ()  LIMIT 10 ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//id = rs.getInt("id");
				question = rs.getString("Question");
				System.out.println(question);

				option_a = rs.getString("Option_a");
				System.out.println("A " + option_a);

				option_b = rs.getString("Option_b");
				System.out.println("B " + option_b);

				option_c = rs.getString("Option_c");
				System.out.println("C " + option_c);

				option_d = rs.getString("Option_d");
				System.out.println("D " + option_d);

				answer = rs.getString("answer");
				System.out.println("_________________________________________________________________________________________________");

				System.out.println("Choose option ");
				userans = sc.next();
				System.out.println(
						"__________________________________________________________________________________________________________");

				hashMap.put(id, userans);
				if (answer.equals(option_a)) {
					ch = "a";
				} else if (answer.equals(option_b)) {
					ch = "b";
				} else if (answer.equals(option_c)) {
					ch = "c";
				} else if (answer.equals(option_d)) {
					ch = "d";
				}
				userans = userans.toLowerCase();
//				ch=ch.toLowerCase();
				if (userans.equals(ch)) {
					count++;
				}

				// checkAns();

			}

//			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public void getUserDetails() {
		
		connectionObject();

		System.out.println("What is your good name?");
		name = sc.next();

		System.out.println("Welcome to Quizz, " + name);
		System.out.println(
				"__________________________________________________________________________________________________________");

		Connection con = setConnection(conn);
		      
		try {
			PreparedStatement psid=conn.prepareStatement("select * from score order by score_id desc limit 1");
			ResultSet set = psid.executeQuery();
			
			while(set.next()) {
				int score_id=set.getInt(1);
				int c=score_id+num;
				System.err.println(name+" your id is : "+c);
				System.out.println("===================================================================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(name+", Your id is: "+id);
		insertResult(con);
	}

	public void checkAns() {
		System.out.println(
				"__________________________________________________________________________________________________________");
		
     System.out.println(name + ", Your score is: " + count+"/"+10);
		
     System.out.println(
				"__________________________________________________________________________________________________________");

	}
	

	public void insertResult(Connection con) {
		try {
			PreparedStatement ps1 = con.prepareStatement("insert into score(student_name,student_score)values(?,?)");

			ps1.setString(1, name);
			ps1.setInt(2, count);
			int i = ps1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
	}

	}
	
}
