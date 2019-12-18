package com.apex.api.core;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javax.xml.bind.Unmarshaller;

import bean.Customer;

public class XMLParserUtil {
	public static Customer getObjectFromXML(String xmlstring) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Customer customer = (Customer) unmarshaller.unmarshal(new StringReader(xmlstring));
		return customer;
	}
public static String getXMLFromObject(Customer customer) throws JAXBException{
	
			JAXBContext context = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = context.createMarshaller();
			
			StringWriter writer = new StringWriter();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(customer, writer);
			return writer.toString();
			
	}
public static void main(String[] args) throws JAXBException{
	Customer customer = new Customer();
	customer.setId("4");
	customer.setFirstName("Johnny");
	customer.setLastName("miller");
	customer.setstreet("Main st");
	customer.setCity("Fremont");
	
	String str = getXMLFromObject(customer);
	System.out.println(str);
}
	
}
