package com.velocity.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	
	
    Connection connection=null;
	

	public Connection getConnectionDetails() {
		
		try {
			// load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// establish the connection 
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root", "suraj@1996");
		
	} catch (Exception e) {
		e.printStackTrace(); 
		
	}
	return connection;
	
}


}
