package com.goyav.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goyav.model.Customer;
import com.goyav.model.Ytmpbpc;
import java.util.ArrayList;
import java.util.List;

public class DbCustomer {
	 

    public static List<Customer> queryCustomers(Connection conn, String query ) throws SQLException {
    	String sql = "SELECT [BPCNUM_0],[BPCNAM_0],[CRN_0] \n" 
    		       		 + "	,[BPAADDLIG_0],[BPAADDLIG_1],[POSCOD_0],[CTY_0],[BPARTNER].[CRY_0] \n"
    		       		 + ",[TEL_0],[WEB_0] \n"
    		    	  	 + "FROM [x3prod].[RAVPROD].[BPCUSTOMER],[x3prod].[RAVPROD].[BPADDRESS],[x3prod].[RAVPROD].[BPARTNER] \n"
    		    	  	 + "WHERE [x3prod].[RAVPROD].[BPADDRESS].[BPANUM_0] = [x3prod].[RAVPROD].[BPCUSTOMER].[BPCNUM_0] \n"
    		    	     + "AND [x3prod].[RAVPROD].[BPARTNER].[CRN_0]   =   ? \n"
    		    	     + "AND [x3prod].[RAVPROD].[BPCUSTOMER].[BPAINV_0] = [x3prod].[RAVPROD].[BPADDRESS].[BPAADD_0] \n"
    		    	     + "AND [x3prod].[RAVPROD].[BPADDRESS].[BPATYP_0] = 1 \n"
    		    		 + "AND [x3prod].[RAVPROD].[BPCUSTOMER].[BPCNUM_0] = [x3prod].[RAVPROD].[BPARTNER].[BPRNUM_0] \n"
    		    	     + "ORDER BY [x3prod].[RAVPROD].[BPCUSTOMER].[BPCNAM_0] ASC; \n " ;
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, query);
        
        ResultSet rs = pstm.executeQuery();
        List<Customer> list = new ArrayList<Customer>();
        while (rs.next()) {
            Customer customer = new Customer(rs.getString("reference"),rs.getString("name"),
            		rs.getString("raison"), rs.getString("sigle"),
            		rs.getString("identity"),rs.getString("street"),rs.getString("address"),
            		rs.getString("postcod"),rs.getString("town"),rs.getString("country"),
            		rs.getString("phone"),rs.getString("email"));
            list.add(customer);
        }
        return list;
    }
    public static Customer getCustomer(Connection conn, String siret) throws SQLException {
    	String sql = "SELECT [BPCNUM_0] as reference,[BPCNAM_0] as name,[CRN_0] as siret \n" 
	       		 + ",[BPAADDLIG_0] as street,[BPAADDLIG_1] as address,[POSCOD_0] as postcod ,\n"
	       		 + " [CTY_0] as town ,[BPARTNER].[CRY_0] as country \n"
	       		 + ",[TEL_0] as phone ,[WEB_0] as email \n"
	    	  	 + "FROM [x3prod].[RAVPROD].[BPCUSTOMER],[x3prod].[RAVPROD].[BPADDRESS],[x3prod].[RAVPROD].[BPARTNER] \n"
	    	  	 + "WHERE [x3prod].[RAVPROD].[BPADDRESS].[BPANUM_0] = [x3prod].[RAVPROD].[BPCUSTOMER].[BPCNUM_0] \n"
	    	     + "AND [x3prod].[RAVPROD].[BPARTNER].[CRN_0]   =   ? \n"
	    	     + "AND [x3prod].[RAVPROD].[BPCUSTOMER].[BPAINV_0] = [x3prod].[RAVPROD].[BPADDRESS].[BPAADD_0] \n"
	    	     + "AND [x3prod].[RAVPROD].[BPADDRESS].[BPATYP_0] = 1 \n"
	    		 + "AND [x3prod].[RAVPROD].[BPCUSTOMER].[BPCNUM_0] = [x3prod].[RAVPROD].[BPARTNER].[BPRNUM_0] \n"
	    	     + "ORDER BY [x3prod].[RAVPROD].[BPCUSTOMER].[BPCNAM_0] ASC; \n " ;
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, siret);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            Customer customer = new Customer(rs.getString("reference"),rs.getString("name"),
            		null, null,
            		rs.getString("siret"),rs.getString("street"),rs.getString("address"),
            		rs.getString("postcod"),rs.getString("town"),rs.getString("country"),
            		rs.getString("phone"),rs.getString("email"));
            return customer;
        }
        return null;
    }
 
    public static void updateCustomer(Connection conn, Customer product) throws SQLException {
    	//
    }
    
    public static void insertCustomer(Connection conn, Customer c) throws SQLException {
    	String sql =  "INSERT INTO [x3prod].[RAVPROD].[ZET_TMPBPC] \n"
    	            + "([YLIN_0] ,[BCGCOD_0] ,[BPCNUM_0] ,[BPCSTA_0] ,[BPRNAM_0]\n"
    	            + ",[BPRNAM_1] ,[BPRSHO_0] ,[BPRLOG_0] ,[CRN_0] ,[NAF_0]\n"
    	            + ",[CRY_0] ,[CUR_0] ,[VACBPR_0]\n"
    	            + ",[PTE_0] ,[ACCCOD_0],[TSCCOD_0],[TSCCOD_1]\n"
    	        	+ ",[OSTAUZ_0],[REP_0],[REP_1] \n"
    	            + ",[YBCG_COMPT_0] ,[YBPC_RECOUVR_0],[YCATCPT_0]\n"
    	            + ",[YSCATCPT_0] ,[BPAADD_0] ,[BPADES_0],[BPAADDLIG_0]\n"
    	            + ",[BPAADDLIG_1],[BPAADDLIG_2] ,[POSCOD_0],[CTY_0]\n"
    	            + ",[BCRY_0] ,[TEL_0] ,[TEL_1] , [WEB_0]) \n"
    	            + " VALUES (? ,? ,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,? ,? ,? ,? ,? \n"
    	            + ",?,?,?,?,? ,?,? )";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        Ytmpbpc bpc = new Ytmpbpc();
        bpc.setBPRNAM_0(c.getName());
        bpc.setBPRNAM_1(c.getRaison());
        bpc.setBPRLOG_0(c.getSigle());
        bpc.setCRN_0(c.getIdentity());
        bpc.setCRY_0(c.getCountry());
        bpc.setBPAADD_0(c.getStreet());
        bpc.setBPAADDLIG_1(c.getAddress());
        bpc.setPOSCOD_0(c.getPostcod());
        bpc.setCTY_0(c.getTown());
        bpc.setBCRY_0(c.getCountry());
        bpc.setTEL_0(c.getPhone());
        bpc.setWEB_0(c.getEmail());
 
		pstm.setString(1, bpc.getYLIN_0());
		pstm.setString(2, bpc.getBCGCOD_0());
		pstm.setString(3, bpc.getBPCNUM_0());
		pstm.setString(4, bpc.getBPCSTA_0());
		pstm.setString(5, bpc.getBPRNAM_0());
		pstm.setString(6, bpc.getBPRNAM_1());
		pstm.setString(7, bpc.getBPRSHO_0());
		pstm.setString(8, bpc.getBPRLOG_0());
		pstm.setString(9, bpc.getCRN_0());
		pstm.setString(10, bpc.getNAF_0());
		pstm.setString(11, bpc.getCRY_0());
		pstm.setString(12, bpc.getCUR_0());
		pstm.setString(13, bpc.getVACBPR_0());
		pstm.setString(14, bpc.getPTE_0());
		pstm.setString(15, bpc.getACCCOD_0());
		pstm.setString(16, bpc.getTSCCOD_0());
		pstm.setString(17, bpc.getTSCCOD_1());
		pstm.setString(18, bpc.getOSTAUZ_0());
		pstm.setString(19, bpc.getREP_0());
		pstm.setString(20, bpc.getREP_1());
		pstm.setString(21, bpc.getYBCG_COMPT_0());
		pstm.setString(22, bpc.getYBPC_RECOUVR_0());
		pstm.setString(23, bpc.getYCATCPT_0());
		pstm.setString(24, bpc.getYSCATCPT_0());
		pstm.setString(25, bpc.getBPAADD_0());
		pstm.setString(26, bpc.getBPADES_0());
		pstm.setString(27, bpc.getBPAADDLIG_0());
		pstm.setString(28, bpc.getBPAADDLIG_1());
		pstm.setString(29, bpc.getBPAADDLIG_2());
		pstm.setString(30, bpc.getPOSCOD_0());
		pstm.setString(31, bpc.getCTY_0());
		pstm.setString(32, bpc.getBCRY_0());
		pstm.setString(33, bpc.getTEL_0());
		pstm.setString(34, bpc.getTEL_1());
		pstm.setString(35, bpc.getWEB_0());

 
        pstm.executeUpdate();
    }
 
    public static void deleteCustomer(Connection conn, Customer customer) throws SQLException {
    	// TODO
    }
 }
