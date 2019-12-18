package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;

import org.testng.annotations.Test;


public class GetTest {
	public static final String BASE_URL = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";

  @Test
  public void testwithPositiveNumber() throws ClientProtocolException, IOException {
	  String url = BASE_URL+"/1";
		 HttpClient client = HttpClientBuilder.create().build();
		HttpGet requestMsg = new HttpGet(url);
		HttpResponse response = client.execute(requestMsg);
		Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),"OK");
		  
  }
  @Test
  public void testwithNegativeNumber() throws ClientProtocolException, IOException {
	  String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/-500";
		 HttpClient client = HttpClientBuilder.create().build();
		HttpGet requestMsg = new HttpGet(url);
		HttpResponse response = client.execute(requestMsg);
		Assert.assertEquals(response.getStatusLine().getStatusCode(),404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),"Not Found");
	  
  }
  @Test
  public void testwithSpecialCharacters() throws ClientProtocolException, IOException {
	  String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/!@#";
		 HttpClient client = HttpClientBuilder.create().build();
		HttpGet requestMsg = new HttpGet(url);
		HttpResponse response = client.execute(requestMsg);
		Assert.assertEquals(response.getStatusLine().getStatusCode(),404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),"Not Found");
	    
	  
  }
  @Test
  public void testwithInvalidData() throws ClientProtocolException, IOException {
	  String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/ASADF";
		 HttpClient client = HttpClientBuilder.create().build();
		HttpGet requestMsg = new HttpGet(url);
		HttpResponse response = client.execute(requestMsg);
		Assert.assertEquals(response.getStatusLine().getStatusCode(),404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),"Not Found");
	    
	  
  }
}
