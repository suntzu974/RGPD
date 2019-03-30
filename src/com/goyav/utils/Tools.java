package com.goyav.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Tools {
	

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static String OS = System.getProperty("os.name").toLowerCase();
	
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    public static final String ATT_SQLSERVER_CONNECTION = "ATTRIBUTE_FOR_SQLQERVER";
 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
    // Store Connection in request attribute.
    public static void storeConnectionSQLServer(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_SQLSERVER_CONNECTION, conn);
    }
    // (Information stored only exist during requests)
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    // Get the Connection object has been stored in attribute of the request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn =  (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
    public static Connection getStoredConnectionSQLServer(ServletRequest request) {
        Connection conn =  (Connection) request.getAttribute(ATT_SQLSERVER_CONNECTION);
        return conn;
    }
 
 
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 seconds (This cookie will expire immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
    /*
     InputStream inputStream= new ByteArrayInputStream(IOUtils.toByteArray(new FileInputStream(f)));
	Workbook wb = WorkbookFactory.create(inputStream);
	Sheet mySheet = wb.getSheetAt(0);
	Iterator<Row> rowIter = mySheet.rowIterator();
	rowIter.next(); 
     
     */
    

    
    public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	public static  Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1].replace(" ","%"));
                result.put(pair[0], pair[1].replace("+","%"));
            }else{
                result.put(pair[0], "");
            }
        }
        System.out.println("Result :" + result);
        return result;
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public static boolean isStringAlpha(String aString){
        int charCount=0;
        String alphabet = "%0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(aString.length() == 0) return false;//zero length string ain't alpha
        for(int i=0;i<aString.length();i++){
            for(int j=0;j<alphabet.length();j++){
                if(aString.substring(i,i+1).equals(alphabet.substring(j,j+1))
                        || aString.substring(i,i+1).equals(alphabet.substring(j,j+1).toLowerCase()))
                    charCount++;
            }
            if(charCount != (i+1)){
                System.out.println("\n**Invalid input! Enter alpha values**\n");
                return false;
            }
        }
        return true;
    }
}