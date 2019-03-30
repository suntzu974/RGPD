package com.goyav.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goyav.model.Stock;

public class DbStock {
    public static List<Stock> queryStocksForSofarem(Connection conn ) throws SQLException {
    	
    	String request_sofarem = "SELECT ITP.ITMREFBPS_0,ITM.ITMDES1_0,YFA2.YFA_LIB_0, ITM.EANCOD_0, \n"
    			 + " SUM(STO.QTYSTU_0 - ITV.SALSTO_0) \n"
    			 + " FROM  [x3prod].[RAVPROD].[ITMFACILIT] AS ITF \n"
    			 + " LEFT JOIN [x3prod].[RAVPROD].[ITMMASTER] AS ITM ON ITM.ITMREF_0 = ITF.ITMREF_0 \n"
    			 + " LEFT JOIN [x3prod].[RAVPROD].[ITMBPS] AS ITP ON ITP.ITMREF_0 = ITF.ITMREF_0 AND ITP.PIO_0 = 0 \n"
    			 + " JOIN [x3prod].[RAVPROD].[STOCK] AS STO ON ITF.ITMREF_0 = STO.ITMREF_0 AND STO.STOFCY_0 = 076 \n"
    			 + " AND LOC_0 in ('A2A','B1A') AND STA_0 <> 'R' \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[ITMMVT] AS ITV ON ITV.ITMREF_0 = ITF.ITMREF_0 AND ITV.STOFCY_0 in (076) \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[BPSUPPLIER] AS BPS ON BPS.BPSNUM_0 = ITP.BPSNUM_0 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA0 ON ITM.YITM_FAM2_0 = YFA0.YFA_CODE_0 AND YFA0.YNF_NIV_0 = 1 AND YFA0.YNF_REG_0 = 2 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA1 ON ITM.YITM_FAM2_1 = YFA1.YFA_CODE_0 AND YFA1.YNF_NIV_0 = 2 AND YFA1.YNF_REG_0 = 2 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA2 ON ITM.YITM_FAM2_2 = YFA2.YFA_CODE_0 AND YFA2.YNF_NIV_0 = 3 AND YFA2.YNF_REG_0 = 2 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA3 ON ITM.YITM_FAM2_3 = YFA3.YFA_CODE_0 AND YFA3.YNF_NIV_0 = 4 AND YFA3.YNF_REG_0 = 2 \n"
    			 + " WHERE ITF.STOFCY_0 in (076) AND (STO.QTYSTU_0 - ITV.SALSTO_0) <> 0 \n"
    			 + " GROUP BY ITP.ITMREFBPS_0,ITM.YITM_ANRAV_0,ITM.ITMDES1_0,YFA2.YFA_LIB_0, ITM.EANCOD_0 ";
    	
        PreparedStatement pstm = conn.prepareStatement(request_sofarem);
        
        ResultSet rs = pstm.executeQuery();
        List<Stock> list = new ArrayList<Stock>();
        while (rs.next()) {
            Stock stock = new Stock(rs.getString(1),rs.getString(2),
            		rs.getString(3), rs.getString(4),rs.getFloat(5));
            list.add(stock);
        }
        return list;
    }
    public static List<Stock> queryStocksForHometech(Connection conn ) throws SQLException {
    	
    	String request_sofarem = "SELECT ITP.ITMREFBPS_0,ITM.ITMDES1_0,YFA2.YFA_LIB_0, ITM.EANCOD_0, \n"
    			 + " SUM(STO.QTYSTU_0 - ITV.SALSTO_0) \n"
    			 + " FROM  [x3prod].[RAVPROD].[ITMFACILIT] AS ITF \n"
    			 + " LEFT JOIN [x3prod].[RAVPROD].[ITMMASTER] AS ITM ON ITM.ITMREF_0 = ITF.ITMREF_0 \n"
    			 + " LEFT JOIN [x3prod].[RAVPROD].[ITMBPS] AS ITP ON ITP.ITMREF_0 = ITF.ITMREF_0 AND ITP.PIO_0 = 0 \n"
    			 + " JOIN [x3prod].[RAVPROD].[STOCK] AS STO ON ITF.ITMREF_0 = STO.ITMREF_0 AND STO.STOFCY_0 = 041 \n"
    			 + " AND LOC_0 in ('A2A','B1A') AND STA_0 <> 'R' \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[ITMMVT] AS ITV ON ITV.ITMREF_0 = ITF.ITMREF_0 AND ITV.STOFCY_0 in (041) \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[BPSUPPLIER] AS BPS ON BPS.BPSNUM_0 = ITP.BPSNUM_0 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA0 ON ITM.YITM_FAM2_0 = YFA0.YFA_CODE_0 AND YFA0.YNF_NIV_0 = 1 AND YFA0.YNF_REG_0 = 2 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA1 ON ITM.YITM_FAM2_1 = YFA1.YFA_CODE_0 AND YFA1.YNF_NIV_0 = 2 AND YFA1.YNF_REG_0 = 2 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA2 ON ITM.YITM_FAM2_2 = YFA2.YFA_CODE_0 AND YFA2.YNF_NIV_0 = 3 AND YFA2.YNF_REG_0 = 2 \n"
    			 + " LEFT JOIN   [x3prod].[RAVPROD].[YFAMART] AS YFA3 ON ITM.YITM_FAM2_3 = YFA3.YFA_CODE_0 AND YFA3.YNF_NIV_0 = 4 AND YFA3.YNF_REG_0 = 2 \n"
    			 + " WHERE ITF.STOFCY_0 in (041) AND (STO.QTYSTU_0 - ITV.SALSTO_0) <> 0 \n"
    			 + " GROUP BY ITP.ITMREFBPS_0,ITM.YITM_ANRAV_0,ITM.ITMDES1_0,YFA2.YFA_LIB_0, ITM.EANCOD_0 ";
    	
        PreparedStatement pstm = conn.prepareStatement(request_sofarem);
        
        ResultSet rs = pstm.executeQuery();
        List<Stock> list = new ArrayList<Stock>();
        while (rs.next()) {
            Stock stock = new Stock(rs.getString(1),rs.getString(2),
            		rs.getString(3), rs.getString(4),rs.getFloat(5));
            list.add(stock);
        }
        return list;
    }
    public static String replaceQuote(String st)
    {
    		/********************************************************         
    		 * * This method takes a String varable as a parameter and*
    		 * replaces the single quote (which causes aSQLException)*
    		 * with two single quotes(actually, it just adds a second*
    		 * single quote when it finds one)                       *
    		 *       *
    		 * example:   input-->  "O'Reilly"      output-->  "O''Reilly"*
    		 * input-->  "O'Conor's"              output-->  "O''Conor''s"*
    		 ****************************************************************/
    	StringBuffer sb = new StringBuffer();
    	char cArray[] = st.toCharArray();
    	for(int i = 0; i < st.length(); i++)
    	{
    		if(cArray[i] == '\'') // find single quote in String
    		{
    			sb.append('\''); //append the escape character
    		}
    		sb.append(cArray[i]); //append the regular character
    	}
    	return new String(sb);
    }
}
