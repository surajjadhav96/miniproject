package com.velocity.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InputSql {
	PreparedStatement prs=null;
	Connection con=null;
	
	public void getdata() {

	try {
		ConnectionTest connectionTest=new ConnectionTest();
	
	    con = connectionTest.getConnectionDetails();
		
	String sql=	" insert into question(Question,Option_a,Option_b,Option_c,Option_d,answer)"
	    		+"values('Who invented Java Programming?','Guido van Rossum','James Gosling','Dennis Ritchie','Bjarne Stroustrup','James Gosling'),"
	    		+ "('Which statement is true about Java?','Java is a sequence-dependent programming language','Java is a code dependent programming language','Java is a platform-dependent programming language','Java is a platform-independent programming lang','Java is a platform-independent programming language'),"
	    		+"('What is the extension of java code files?','.js','.txt','.class','.java','.java'),"
	    		+"('Which of the following is a superclass of every class in Java?','ArrayList','Abstract class','Object class','String','Object class'),"
	    		+"('Which one of the following is not an access modifier?','Protected','Void','Public','Private','Void'),"
	    		+"('Which of this keyword can be used in a subclass to call the constructor of superclass?','super','this','extent','extends','super'),"
	    		+"('What is true about constructor?','It can contain return type','It can take any number of parameters','It can have any non access modifiers','Constructor cannot throw an exception','It can take any number of parameters'),"
	    		+"('Which of these jump statements can skip processing the remainder of the code in its body for a particular iteration?','break','return','exit','continue','continue'),"
	    		+"('Which of the following is not OOPS concept in Java?','Inheritance','Encapsulation','Compilation','Polymorphism','Compilation'),"
	    		+"('Arrays in Java are implemented as?','class','object','none of the mentioned','variable','object')";
	
	
	          prs = con.prepareStatement("sql" );
	  
	         int rs = prs.executeUpdate(sql);
	  
		System.out.println("record inserted succesfully"+rs);
		
	} catch (Exception e) {
		
		e.printStackTrace();;
	}
	
	
	
}	
}


	