package com.goyav.connection;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionUtils {
 
    public static Connection getConnection() 
              throws ClassNotFoundException, SQLException {
 
        return IngresConnUtils.getIngresConnection();
         
    }
     
    public static Connection getSQLServerConnection() 
            throws ClassNotFoundException, SQLException {

      return SQLServerConnUtils.getSQLServerConnection();
       
  }
    public static Connection getMongoConnection() 
            throws ClassNotFoundException, SQLException {

      return MongoConnUtils.getMongoConnection();
       
  }
   public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
}