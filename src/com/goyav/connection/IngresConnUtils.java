package com.goyav.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class IngresConnUtils {
	  
	 public static Connection getIngresConnection()
	         throws ClassNotFoundException, SQLException {
	     // Note: Change the connection parameters accordingly.
		 String JDBC_DRIVER = "com.ingres.jdbc.IngresDriver";
		 String DB_URL = "jdbc:ingres://10.1.0.1:II7/dbgc0";
		 String USER = "ingres";
		 String PASS = "ingres";
	    
		return getIngresConnection(JDBC_DRIVER,DB_URL, USER, PASS);
	 }
	  
	 public static Connection getIngresConnection(String Driver, String hostName,  String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName(Driver);
	     String connectionURL = hostName;
	     Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
}