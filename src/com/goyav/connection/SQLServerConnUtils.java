package com.goyav.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils {
	// Connect to SQLServer
    // (Using JDBC Driver of JTDS library)
    public static Connection getSQLServerConnection() //
            throws SQLException, ClassNotFoundException {
 
        // Note: Change the connection parameters accordingly.
        String hostName = "10.1.10.10";
        String sqlInstanceName = "SAGEX3";
        String database = "x3prod";
        String userName = "sa";
        String password = "$tiger2013!";
 
        return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
    }
 
    // Connect to SQLServer, using JTDS library
    private static Connection getSQLServerConnection(String hostName, //
            String sqlInstanceName, String database, String userName, String password)
            throws ClassNotFoundException, SQLException {
 
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
 
        // Example:
        // jdbc:jtds:sqlserver://localhost:1433/simplehr;instance=SQLEXPRESS
        String connectionURL = "jdbc:jtds:sqlserver://" + hostName +"/" //
                + database + ";instance=" + sqlInstanceName;
 
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
