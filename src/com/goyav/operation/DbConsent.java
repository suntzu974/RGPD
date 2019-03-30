package com.goyav.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goyav.model.Consent;
import com.goyav.model.CustomerConsent;
import java.util.ArrayList;
import java.util.List;

public class DbConsent {

    public static List<CustomerConsent> queryConsents(Connection conn) throws SQLException {
    	String sql = "SELECT [CRN_0]  \n"
    			 + ",[CONSENT_0],[CONSENT_1], \n"
    			 + "[CONSENT_2],[CONSENT_3],[CONSENT_4] \n"
    				+ ",[SIGNCHAR_0] ,[DATE_0] \n"
    				+ "	FROM [x3prod].[RAVPROD].[ZET_CDVRGPD] \n"
    				+ "	ORDER BY [x3prod].[RAVPROD].[ZET_CDVRGPD].[CRN_0] ASC";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<CustomerConsent> list = new ArrayList<CustomerConsent>();
        CustomerConsent consent = new CustomerConsent();
        while (rs.next()) {
            consent = new CustomerConsent(rs.getString(1),rs.getBoolean(2),
            		rs.getBoolean(3), rs.getBoolean(4),rs.getBoolean(5),
            		rs.getBoolean(6),rs.getString(7),null);
            consent.setCustomer(DbCustomer.getCustomer(conn, rs.getString(1)));
            list.add(consent);
        }
        return list;

    }

    public static CustomerConsent getConsent(Connection conn, String siret) throws SQLException {
    	String sql = "SELECT [CRN_0]  \n"
   			 + ",[CONSENT_0],[CONSENT_1], \n"
   			 + "[CONSENT_2],[CONSENT_3],[CONSENT_4] \n"
   				+ ",[SIGNCHAR_0] ,[DATE_0] \n"
   				+ "	FROM [x3prod].[RAVPROD].[ZET_CDVRGPD] \n"
   				+ " WHERE [CRN_0] = ? \n"
   				+ "	ORDER BY [x3prod].[RAVPROD].[ZET_CDVRGPD].[CRN_0] ASC";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, siret);

       ResultSet rs = pstm.executeQuery();
       CustomerConsent consent = new CustomerConsent();
       while (rs.next()) {
           consent = new CustomerConsent(rs.getString(1),rs.getBoolean(2),
           		rs.getBoolean(3), rs.getBoolean(4),rs.getBoolean(5),
           		rs.getBoolean(6),rs.getString(7),null);
           consent.setCustomer(DbCustomer.getCustomer(conn, siret));
       }
       return consent;
    }
    
    public static void insertConsent(Connection conn, Consent consent) throws SQLException {
    	String sql =  "INSERT INTO [x3prod].[RAVPROD].[ZET_CDVRGPD] \n"
    	           	+ "([CRN_0],[CONSENT_0],[CONSENT_1],[CONSENT_2],[CONSENT_3],[CONSENT_4] \n"
    	            +  ",[SIGNCHAR_0],[DATE_0]) \n"
    	            + " VALUES (?,?,?,?,?,?,?,GETDATE())";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
		pstm.setString(1, consent.getSiret());
		pstm.setBoolean(2, consent.getUsingGeneralConditions());
		pstm.setBoolean(3, consent.getNewsletters());
		pstm.setBoolean(4, consent.getCommercialOffersByMail());
		pstm.setBoolean(5, consent.getCommercialOffersBySms());
		pstm.setBoolean(6, consent.getCommercialOffersByPost());
		pstm.setDate(8, consent.getCreatedAt());
 
        pstm.executeUpdate();

    }
    public static Consent updateConsent(Connection conn, Consent consent) throws SQLException {
    	
    	String sql = " UPDATE [x3prod].[RAVPROD].[ZET_CDVRGPD] \n"
    		   	 + "SET [CONSENT_0] = ? \n"
    		     + ",[CONSENT_1] = ?  \n"
    		     + " ,[CONSENT_2] = ?  \n"
    		     + ",[CONSENT_3] = ?  \n"
    		     + " ,[CONSENT_4] = ?  \n"
    		     + ",[SIGNCHAR_0] = ?  \n"
    		     + " ,[DATE_0] = GETDATE() \n"
    		 	 + " WHERE [CRN_0] = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setBoolean(1, consent.getUsingGeneralConditions());
        pstm.setBoolean(2, consent.getNewsletters());
        pstm.setBoolean(3, consent.getCommercialOffersByMail());
        pstm.setBoolean(4,consent.getCommercialOffersBySms());
        pstm.setBoolean(5, consent.getCommercialOffersByPost());
        pstm.setString(6,  consent.getSignature());
        pstm.executeUpdate();
        
        return consent;
    }
 }
