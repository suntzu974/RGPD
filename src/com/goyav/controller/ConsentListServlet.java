package com.goyav.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.goyav.model.CustomerConsent;
import com.goyav.operation.DbConsent;
import com.goyav.utils.Tools;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.apache.commons.codec.binary.Base64;

@WebServlet(urlPatterns = { "/rgpdlist"})
public class ConsentListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
	String UsingGeneralConditions = "Conditions g&eacuten&eacuterales d'utilsations";
	String Newsletters = "Newsletters";
	String CommercialOffersByMail 	= "Offres commerciales par E-mail";
	String CommercialOffersBySms 	= "Offres commerciales par SMS";
	String CommercialOffersByPost 	= "Offres commerciales par Courrier postal";
	String CustomerNotExist = "Cr�ation en cours";
	
 
   public ConsentListServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   
	   Connection conn =  Tools.getStoredConnectionSQLServer(request);
       String errorString = null;
       List<CustomerConsent> list = null;
        String output = null;
		output = (String) request.getParameter("output");
		try {
				if (output != null) {
					list = DbConsent.queryConsents(conn);
					switch(output) {
					case "pdf" :
						printPDF(list,request,response);
						break;
					case "json" :
						printJSON(list,request,response);
						break;
					default:
						printHTML(list,request,response);
						break;
					}
					if (output.contains("pdf")) {
						printPDF(list,request,response);
					}
					else {
					}
				}
	   		} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
		}

   }
 
   private void printJSON(List<CustomerConsent> list, HttpServletRequest request, HttpServletResponse response) throws IOException {
	// TODO Auto-generated method stub
       Gson gson = new Gson();
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
       response.getOutputStream().print(gson.toJson(list));
       response.getOutputStream().flush();
}

private void printHTML(List<CustomerConsent> list,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		// Store info in request attribute, before forward to views
		request.setAttribute("consentList", list);
      
		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/consentListView.jsp");
		dispatcher.forward(request, response);         
	
}

@Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
	public void printPDF(List<CustomerConsent> list, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	    try {
		      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		      Document document = new Document(pdf, PageSize.A4.rotate());
		      document.setMargins(20, 20, 20, 20); 
		      PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
		      PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		      Table table = new Table(new float[]{4, 6, 3, 4, 4});
	    	  processHeader(table, font); 
		      for(CustomerConsent customer: list) {
		    	  processBody(table, customer, font); 
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
	public void processHeader(Table table, PdfFont font) throws IllegalArgumentException, IllegalAccessException, MalformedURLException, FileNotFoundException, IOException { 
		table.addHeaderCell( new Cell().add(new Paragraph("societe")).setFont(font));
		table.addHeaderCell( new Cell().add(new Paragraph("Siret")).setFont(font));
		table.addHeaderCell( new Cell().add(new Paragraph("Adresse")).setFont(font));
		table.addHeaderCell( new Cell().add(new Paragraph("Acceptation")).setFont(font));
		table.addHeaderCell( new Cell().add(new Paragraph("Signature")).setFont(font));
	}

	public void processBody(Table table, CustomerConsent customer, PdfFont font) throws IllegalArgumentException, IllegalAccessException, MalformedURLException, FileNotFoundException, IOException { 
		if (customer.getCustomer()!= null) {
			table.addCell( new Cell().add( new Paragraph( (String)customer.getCustomer().getName()).setFont(font))); 
		} else {
			table.addCell( new Cell().add( new Paragraph( CustomerNotExist)).setFont(font)); 
		}
		table.addCell( new Cell().add( new Paragraph( customer.getSiret())).setFont(font)); 
		if (customer.getCustomer()!= null) {
			Cell address = new Cell()
				.setTextAlignment(TextAlignment.LEFT)
				.add(new Paragraph(customer.getCustomer().getAddress())).setFont(font)
				.add(new Paragraph(customer.getCustomer().getStreet())).setFont(font)
				.add(new Paragraph(customer.getCustomer().getPostcod()+","+customer.getCustomer().getTown()).setFont(font)
            	.add(new Paragraph(customer.getCustomer().getCountry())).setFont(font));
			table.addCell(address);
		} else {
			table.addCell(new Paragraph("")).setFont(font);
		}
		Cell cell = new Cell()
            .setTextAlignment(TextAlignment.LEFT)
            .add(new Paragraph(UsingGeneralConditions + ":" + translate(customer.getUsingGeneralConditions())).setFont(font))
 			.add(new Paragraph(Newsletters + ":" + translate(customer.getNewsletters())).setFont(font))
 			.add(new Paragraph(CommercialOffersByMail + ":" + translate(customer.getCommercialOffersByMail())).setFont(font))
 			.add(new Paragraph(CommercialOffersBySms + ":" + translate(customer.getCommercialOffersBySms())).setFont(font))
 			.add(new Paragraph(CommercialOffersByPost + ":" + translate(customer.getCommercialOffersByPost())).setFont(font));
		table.addCell(cell);
		table.addCell(createImageCell(decodeBase64ToFile(customer.getSiret(),customer.getSignature())));
	}
	public String translate(boolean valeur)
    {
        if (valeur = true) {
            return new String("Oui");
          }
        else {
            return new String("Non");
        }
    }
	public Cell createImageCell(String path) throws MalformedURLException {

        Image img = new Image(ImageDataFactory.create(path));
        Cell cell = new Cell().add(img.scaleToFit(75, 75));
        return cell;

    }
	public String decodeBase64ToFile(String path,String base64) throws FileNotFoundException, IOException {
		String contextPath = getServletContext().getRealPath("/");
		String xmlFilePath=contextPath+File.separator+path+".png";

		byte[] data = Base64.decodeBase64(base64);
		try (OutputStream stream = new FileOutputStream(xmlFilePath)) {
		    stream.write(data);
		}
		return xmlFilePath;
	}

}