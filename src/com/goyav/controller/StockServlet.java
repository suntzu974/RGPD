package com.goyav.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.goyav.model.Stock;
import com.goyav.operation.DbStock;
import com.goyav.utils.Tools;

/**
 * Servlet implementation class StockServlet
 */
@WebServlet(name="StockServlet", urlPatterns =  {"/sofarem"} )
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "uploadedFiles";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn =  Tools.getStoredConnectionSQLServer(request);

		 
   		String fileName = new String("SofaremStock.xlsx");
   		Workbook workbook = new XSSFWorkbook();

        List<Stock> list = null;
   		try {
   			list = DbStock.queryStocksForSofarem(conn);
   		    writeXLSXWorkBook(list,"SOFAREM",workbook);
   			list = DbStock.queryStocksForHometech(conn);
   		    writeXLSXWorkBook(list,"HOMETECH",workbook);
   	   		downloadFile(response,fileName,workbook);
   	   		handleRequest(fileName,request,response);
   		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private void writeXLSXWorkBook(List<Stock> list,String sheetName,Workbook workbook) throws IOException {
		
		String[] columns = {"Reference", "Designation", "famille", "Gencod","Quantité"};
		Sheet sheet = workbook.createSheet(sheetName) ;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }


        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(Stock stock: list) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(stock.getReference());

            row.createCell(1)
                    .setCellValue(stock.getDesignation());

            row.createCell(2)
            .setCellValue(stock.getFamille());

            row.createCell(3)
            .setCellValue(stock.getGencod());

            row.createCell(4)
            .setCellValue(stock.getQuantite());
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

	private void downloadFile(HttpServletResponse response,String fileName,Workbook workbook) throws IOException {

		String contextPath = getServletContext().getRealPath("/");
		String xmlFilePath=contextPath+File.separator+fileName;
		System.out.println(xmlFilePath);
		File myFile = new File(xmlFilePath);
		myFile.createNewFile();
		
        FileOutputStream fileOut = new FileOutputStream(myFile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

	}
	public void handleRequest(String fileName,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String contextPath = getServletContext().getRealPath("/");
		String xmlFilePath=contextPath+File.separator+fileName;
		System.out.println(xmlFilePath);
		File file = new File(xmlFilePath);

		/***** Get The Absolute Path Of The File To Be Downloaded *****/
        OutputStream outStream = null;
        FileInputStream inputStream = null;
 
        if (file.exists()) {
 
            /**** Setting The Content Attributes For The Response Object ****/
            String mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            response.setContentType(mimeType);
 
            /**** Setting The Headers For The Response Object ****/
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
            response.setHeader(headerKey, headerValue);
 
            try {
 
                /**** Get The Output Stream Of The Response ****/
                outStream = response.getOutputStream();
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
 
                /**** Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data  Read From The Input Stream Into The Output Stream ****/
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
               outStream.close();
               outStream.flush();
            } catch(IOException ioExObj) {
                System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
            } finally {             
                if (inputStream != null) {
                    inputStream.close();
                }
 
                outStream.flush();
                if (outStream != null) {
                    outStream.close();
                }
            }
        } else {
 
            /***** Set Response Content Type *****/
            response.setContentType("text/html");
 
            /***** Print The Response *****/
            response.getWriter().println("<h3>File "+ fileName +" Is Not Present .....!</h3>");
        }
    }
}
