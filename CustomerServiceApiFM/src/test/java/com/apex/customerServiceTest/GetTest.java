package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.apex.api.core.ApexBaseServiceTest;
import com.apex.api.core.ApexHttpUtil;
import com.apex.api.core.ApexHttpValidator;
import com.apex.api.core.XLSUtil;
import com.apex.customerServiceTest.Constants.CustomerServiceConstant;

public class GetTest extends ApexBaseServiceTest implements CustomerServiceConstant{
	
	@DataProvider(name = "customeridfile")
	public Object[][] getSuccessData() throws Exception {
		String[][] data = XLSUtil.readfromSpreadSheet("CustomerAPI.xls", "Sheet1", "successcustomerids");
		return data;
	}
	
	@DataProvider(name = "wrongcustomeridfile")
	public Object[][] getWrongData() throws Exception {
		String[][] data = XLSUtil.readfromSpreadSheet("CustomerAPI.xls", "Sheet1", "wrongcustomerids");
		return data;
	}

	@Test(dataProvider = "customeridfile")
	public void testWithExistingCustomerIds(String id) throws ClientProtocolException, IOException {
		String url = BASE_URL + id;

		HttpResponse responseMsg = ApexHttpUtil.sendAndReceiveGETMessage(url);

		ApexHttpValidator.performCommonResponseValidations(responseMsg, 200, "OK");

		String result = ApexHttpUtil.getStringResponseMessage(responseMsg);

		ApexHttpValidator.dataValidation(result);

	}

	@Test(dataProvider = "wrongcustomeridfile")
	public void testWithWrongCustomerIds(String id) throws ClientProtocolException, IOException {
		String url = BASE_URL + id;

		HttpResponse responseMsg = ApexHttpUtil.sendAndReceiveGETMessage(url);
		ApexHttpValidator.performCommonResponseValidations(responseMsg, 404, "Not Found");
	}

  @Test
  public void testwithInvalidData() throws ClientProtocolException, IOException {
	  String url = BASE_URL+"/ASADF";
	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
		ApexHttpValidator.performCommonResponseValidations(response, 404, "Not Found");
	    
  }
//  @Test
//  public void testwithSpace() throws ClientProtocolException, IOException {
//	  String url = BASE_URL+"/  ";
//	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
//		ApexHttpValidator.performCommonResponseValidations(response, 404, "Not Found");
//	    
//  }
  @Test
  public void testwithZeroes() throws ClientProtocolException, IOException {
	  String url = BASE_URL+"/0000";
	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
		ApexHttpValidator.performCommonResponseValidations(response, 200, "OK");
		// String result = ApexHttpUtil.getStringResponseMessage(response) ;
//		 Assert.assertTrue(result.contains("FIRSTNAME"));
//		 Assert.assertTrue(result.contains("<FIRSTNAME>"));
//		 Assert.assertTrue(result.contains("<FIRSTNAME>Anne</FIRSTNAME>"));
//		 
  }
  @Test
  public void testwithAsterik() throws ClientProtocolException, IOException {
	  String url = BASE_URL+"/***";
	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
		ApexHttpValidator.performCommonResponseValidations(response,404, "Not Found");
	    
  }
//  @Test
//  public void testwithHashSymbol() throws ClientProtocolException, IOException {
//	  String url = BASE_URL+"/##";
//	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
//		ApexHttpValidator.performCommonResponseValidations(response, 200, "OK");
//	    
//  }
//  @Test
//  public void testwithPercent() throws ClientProtocolException, IOException {
//	  String url = BASE_URL+"/%%%";
//	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
//		ApexHttpValidator.performCommonResponseValidations(response,400, "Bad Request");
//	    
//  }
//  @Test
//  public void testwithTags() throws ClientProtocolException, IOException {
//	  String url = BASE_URL+"/<><>";
//	  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
//		ApexHttpValidator.performCommonResponseValidations(response,404, "Not Found");
//	    
//  }
}
