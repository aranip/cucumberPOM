package com.qa.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_TC001 {

	
	@Test
	 void getweatherDetails()
	 {
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/Hyderabad");
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  Assert.assertEquals(responseBody.contains("Hyderabad"), true);
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  //status line verification
	  String statusLine=response.getStatusLine();
	  System.out.println("Status line is:"+statusLine);
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	  
	  //JSON ResponseBody(extracting each node)
	  JsonPath jsonpath = response.jsonPath();
	  System.out.println(jsonpath.get("City"));
	  System.out.println(jsonpath.get("Temperature"));
	  System.out.println(jsonpath.get("Humidity"));
	  System.out.println(jsonpath.get("WeatherDescription"));
	  System.out.println(jsonpath.get("WindSpeed"));
	  System.out.println(jsonpath.get("WindDirectionDegree"));
	
	Assert.assertEquals(jsonpath.get("Temperature"), "20.6 Degree celsius"); 
	 
	 
	 
	 }
	 @Test
	 void googleMapTest()
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="https://maps.googleapis.com";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //validating headers
	  String contentType=response.header("Content-Type");// capture details of Content-Type header
	  System.out.println("Content Type is:"+contentType);
	  Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
	  
	  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
	  System.out.println("Content Encoding is:"+contentEncoding);
	  Assert.assertEquals(contentEncoding, "gzip");
	  
	  //validating all headers
	  Headers allheaders = response.headers();
	  for(Header header:allheaders)
	  {
		  System.out.println(header.getName()+"  "+header.getValue());
	  }
	  
	 
	  
	 }
	}


