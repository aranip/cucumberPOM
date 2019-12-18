package com.apex.api.core;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;



public class ApexHttpUtil {
	public static String getStringResponseMessage(HttpResponse response) throws IOException {
		String result = null;
		HttpEntity entity = response.getEntity();
		if(entity != null) {
			result = EntityUtils.toString(entity);
			System.out.println(result);
		}
		return result;
	}
	
	public static HttpResponse sendAndReceiveGETMessage(String url) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet requestMsg = new HttpGet(url);
		HttpResponse responseMsg = client.execute(requestMsg);
		return responseMsg;
	}
	public static HttpResponse sendAndReceivePOSTMessage(String url, String requestMsgData) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost requestMsg = new HttpPost(url);
		
		StringEntity entity = new StringEntity(requestMsgData);
		requestMsg.setEntity(entity);
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
	public static HttpResponse sendAndReceivePUTMessage(String url, String requestMsgData) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut requestMsg = new HttpPut(url);
		StringEntity entity = new StringEntity(requestMsgData);
		requestMsg.setEntity(entity);
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
	public static HttpResponse sendAndReceiveDELETEMessage(String url) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete requestMsg = new HttpDelete(url);
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
}
