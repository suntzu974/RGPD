package com.goyav.utils;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.goyav.model.Customer;
import com.goyav.model.CustomerResponse;

public class XmlWriter {
	public void writeXML(List<Customer> listArticle, String selectedFile ) throws IOException , JAXBException {
		
		File file = new File(selectedFile);
		JAXBContext context;
		context = JAXBContext.newInstance(CustomerResponse.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(new CustomerResponse(listArticle),file);
	}
	public void encodeXML(List<Customer> listArticle, String selectedFile) throws IOException {
		XMLEncoder encoder=null;
		try{
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(selectedFile)));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File products.xml");
		}
		encoder.writeObject(listArticle);
		encoder.close();
	}
}
