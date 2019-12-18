package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.testng.annotations.Test;

public class PostTest{
	public static final String BASE_URL = "https://reqres.in/api/users";
	@Test
	 public void sendPOST() throws ClientProtocolException, IOException {
		 String url = BASE_URL+"/536";
        
        HttpPost post = new HttpPost(url);
        post.addHeader("content-type", "application/json");
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"mkyong\",");
        json.append("\"job\":\"automation Engineer\"");
        json.append("}");

        // send a JSON data
        post.setEntity(new StringEntity(json.toString()));
        //String jsonString 
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {

       		HttpEntity entity = response.getEntity();
       		Header headers = entity.getContentType();
       		System.out.println(headers);
            System.out.println(response.getStatusLine().getStatusCode());   // 201
            System.out.println(response.getStatusLine().getReasonPhrase()); // created
    		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
    		System.out.println("The response from API is:"+ responseString);
       	
        }
        }
}