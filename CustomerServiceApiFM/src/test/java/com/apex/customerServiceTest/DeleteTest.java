package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apex.api.core.ApexBaseServiceTest;
import com.apex.api.core.ApexHttpUtil;
import com.apex.api.core.ApexHttpValidator;
import com.apex.customerServiceTest.Constants.CustomerServiceConstant;

public class DeleteTest extends ApexBaseServiceTest implements CustomerServiceConstant{
	
	public static final String BASE_URL = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";
	 @Test
	  public void deleteRecord() throws ClientProtocolException, IOException {
	String url = BASE_URL+"/236";
	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
		ApexHttpValidator.performCommonResponseValidations(response, 200, "OK");
}
}