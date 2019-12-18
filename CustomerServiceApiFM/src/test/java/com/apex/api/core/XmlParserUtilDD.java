package com.apex.api.core;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import bean.Customer;

public class XmlParserUtilDD {
	public static void parserMethod(String id, String fName, String lName, String street, String city) {

		Customer customer = new Customer();
		
		customer.setId(id);
		customer.setFirstName(fName);
		customer.setLastName(lName);
		customer.setstreet(street);
		customer.setCity(city);
		try {

			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }


		}

	
}
