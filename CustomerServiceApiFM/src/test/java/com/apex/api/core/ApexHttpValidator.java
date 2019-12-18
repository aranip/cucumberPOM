package com.apex.api.core;

import org.apache.http.HttpResponse;
import org.testng.Assert;

public class ApexHttpValidator {
	public static void performCommonResponseValidations(HttpResponse response, int statusCode, String msg) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(),statusCode);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),msg);
		//Assert.assertEquals(response.getStatusLine().toString(),msg1);
		
		 
}
	public static void dataValidation(String result){
		Assert.assertTrue(result.contains("FIRSTNAME"));
		 Assert.assertTrue(result.contains("<FIRSTNAME>"));
		 Assert.assertTrue(result.contains("<FIRSTNAME>Anne</FIRSTNAME>"));
	}

}