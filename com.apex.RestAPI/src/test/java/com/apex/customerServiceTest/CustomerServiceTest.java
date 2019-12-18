package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class CustomerServiceTest {
 public static void main(String[] args) throws ClientProtocolException, IOException{
	 String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/1";
	 HttpClient client = HttpClientBuilder.create().build();
	HttpGet requestMsg = new HttpGet(url);
	HttpResponse response = client.execute(requestMsg);
	System.out.println(response.getStatusLine().getStatusCode());
	System.out.println(response.getStatusLine().getReasonPhrase());
	
 }
}
