package com.goyav.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goyav.model.Stock;
import com.goyav.operation.DbStock;
import com.goyav.utils.Tools;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/**
 * Servlet implementation class CustomerToPDF
 */
@WebServlet("/CustomerToPDF")
public class CustomerToPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int BUFFER_SIZE = 1024 * 100;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerToPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn =  Tools.getStoredConnectionSQLServer(request);
		List<Stock> list = null;
		String output = null;
		output = (String) request.getParameter("output");
		try {
				if (output != null) {
					list = DbStock.queryStocksForSofarem(conn);
					if (output.contains("pdf")) {
						printPDF(list,request,response);
					}
				}
	   		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void printPDF(List<Stock> list, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	    try {
	    	
		      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		      Document document = new Document(pdf, PageSize.A4.rotate());
		      document.setMargins(20, 20, 20, 20); 
		      PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
		      PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		      Table table = new Table(new float[]{4, 6, 3, 4, 4});
		      table.setWidth(100); 
		      Stock header = new Stock();
	    	  processHeader(table, header, font); 
		      for(Stock stock: list) {
		    	  processBody(table, stock, font); 
		      }
		      document.add(table); 
		      document.close();

		      response.setHeader("Expires", "0");
		      response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
		      response.setHeader("Pragma", "public");
		      response.setContentType("application/pdf");
		      response.setContentLength(baos.size());

		      ServletOutputStream out = response.getOutputStream();
			  baos.writeTo(out);
			  out.flush();
		    } catch (Exception e2) {
		      System.out.println("Error in " + getClass().getName() + "\n" + e2);
		    }
	}
	public void processHeader(Table table, Stock stock, PdfFont font) throws IllegalArgumentException, IllegalAccessException { 
		Field[] fields = stock.getClass().getDeclaredFields();		
		for(Field f : fields ){
				table.addHeaderCell( new Cell().add( new Paragraph(f.getName()).setFont(font))); 
		} 
	}
	// Fill table
	public void processBody(Table table, Stock stock, PdfFont font) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException { 
   	  	table.addCell( new Cell().add( new Paragraph( (String) stock.getReference()).setFont(font))); 
   	  	table.addCell( new Cell().add( new Paragraph( (String) stock.getDesignation()).setFont(font))); 
   	  	table.addCell( new Cell().add( new Paragraph( (String) stock.getFamille()).setFont(font)));
   	  	table.addCell( new Cell().add( new Paragraph( (String) stock.getGencod()).setFont(font))); 
   	  	table.addCell( new Cell().add( new Paragraph( String.valueOf(stock.getQuantite())).setFont(font))); 
    }

}
