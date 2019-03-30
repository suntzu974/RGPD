package com.goyav.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MongoConnUtils {
	  
	 public static Connection getMongoConnection()
	         throws ClassNotFoundException, SQLException {
	     // Note: Change the connection parameters accordingly.
		 String JDBC_DRIVER = "mongodb.jdbc.MongoDriver";
		 String DB_URL = "jdbc:mongo://localhost:27017/store";
		 String USER = "";
		 String PASS = "";
	    
		return getMongoConnection(JDBC_DRIVER,DB_URL, USER, PASS);
	 }
	  
	 public static Connection getMongoConnection(String Driver, String hostName,  String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName(Driver);
	     String connectionURL = hostName;
	     Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
}