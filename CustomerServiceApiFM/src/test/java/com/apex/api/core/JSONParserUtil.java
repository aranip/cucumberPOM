package com.apex.api.core;

import javax.xml.bind.JAXBException;

import com.google.gson.Gson;

import bean.Customer;

public class JSONParserUtil {
public static Customer getObjectFromJSON(String jsonString){
	Gson gson = new Gson();
	Customer customer = gson.fromJson(jsonString, Customer.class);
	
return customer;
}
public static String getJsonFromObject(Customer customer){
	Gson gson = new Gson();
	String str = gson.toJson(customer);
	return str;
}
public static void main(String[] args) throws JAXBException{
	Customer customer = new Customer();
	customer.setId("4");
	customer.setFirstName("Johnny");
	customer.setLastName("miller");
	customer.setstreet("Main st");
	customer.setCity("Fremont");
	String str = getJsonFromObject(customer);
	System.out.println(str);
}
}