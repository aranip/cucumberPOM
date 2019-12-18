package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;
import com.apex.api.core.ApexBaseServiceTest;
import com.apex.api.core.ApexHttpUtil;
import com.apex.api.core.ApexHttpValidator;
import com.apex.customerServiceTest.Constants.CustomerServiceConstant;

public class PutTest extends ApexBaseServiceTest implements CustomerServiceConstant{
	public static final String BASE_URL = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";

  @Test
  public void updatePositiveNumberWithPut() throws ClientProtocolException, IOException {
	  String url = BASE_URL+"/4";
	  String requestMsgData = "<CUSTOMER xmlns:xlink='http://www.w3.org/1999/xlink'>"
	  		+ "<ID>4</ID>"
	  		+ "<FIRSTNAME>sandy</FIRSTNAME>"
	  		+ "<LASTNAME>siller</LASTNAME>"
	  		+ "<STREET>294 Seventh Av.</STREET>"
	  		+ "<CITY>Paris</CITY>"
	  		+ "</CUSTOMER>";
	 
        HttpResponse response = ApexHttpUtil.sendAndReceivePUTMessage(url,requestMsgData);
        ApexHttpValidator.performCommonResponseValidations(response, 500, "Internal Server Error");
		
    }
}



