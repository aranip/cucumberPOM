package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class PutTest {
	public static final String BASE_URL = "https://reqres.in/api/users";

  @Test
  public void testwithPositiveNumberPut() throws ClientProtocolException, IOException {
	  String url = BASE_URL+"/3";
	  	HttpPut httpPut = new HttpPut(url);
	  	httpPut.addHeader("content-type", "application/json");
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"ankitha\",");
        json.append("\"job\":\"QualityEngineer\"");
        json.append("}");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(httpPut)) {

       		HttpEntity entity = response.getEntity();
       		Header headers = entity.getContentType();
       		System.out.println(headers);
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // ok
    		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
    		System.out.println("The response from API is:"+ responseString);
       	
        }

    }
}



