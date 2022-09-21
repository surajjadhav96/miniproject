package com.velocity.project;

import java.util.Scanner;

public class StudentGrade {
	int choice;
	public void getRegistration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Enter your name to start the quiz");
		//System.out.println("2.Start quiz");
		System.out.println("2. Result");
		System.out.println("3. Find your result");
		System.out.println("Enter your choice: ");
		choice = scanner.nextInt();
		
		getStudentGrade();
	}
	
	public void getStudentGrade(){
	
		RetrieveStudentData data1=new RetrieveStudentData();
		
		SelectAnswer answer=new SelectAnswer();
	InsertInfo insertInfo = new InsertInfo(); 

	RetrieveStudentData data = new RetrieveStudentData();

	DataById byId = new DataById();
	 boolean str=true;
	
	while(str) {
		
		switch (choice) {
		case 1:
			answer.getUserDetails();
			
			getRegistration();
			break;
//		case 2:
//			
//			answer.getUserDetails();
//			
//			answer.checkAns();
//			getRegistration();
//			break;
		case 2 :
			answer.checkAns();
//			data.printStudentData();
			getRegistration();
			
			break;

		case 3:	
			byId.getDataById();
			getRegistration();
		
			break;
			
		case 0:
		System.exit(0);
			break;
		}
		
	}
	}
}
