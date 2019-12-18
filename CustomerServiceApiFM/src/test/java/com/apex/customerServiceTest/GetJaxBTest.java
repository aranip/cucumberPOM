package com.apex.customerServiceTest;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.api.core.ApexBaseServiceTest;
import com.apex.api.core.ApexHttpUtil;
import com.apex.api.core.ApexHttpValidator;
import com.apex.api.core.XMLParserUtil;
import com.apex.customerServiceTest.Constants.CustomerServiceConstant;

import bean.Customer;

public class GetJaxBTest extends ApexBaseServiceTest implements CustomerServiceConstant{
	@Test
	public void testwithSuccessData() throws ClientProtocolException, IOException, JAXBException {
		  String url = BASE_URL+"/4";
		  HttpResponse response = ApexHttpUtil.sendAndReceiveGETMessage(url);
			ApexHttpValidator.performCommonResponseValidations(response, 200, "OK");
			String result = ApexHttpUtil.getStringResponseMessage(response);
			System.out.println(result);
			Customer customer = XMLParserUtil.getObjectFromXML(result);
			System.out.println(customer.getCity());
		    Assert.assertEquals(customer.getCity(),"Dallas");
	  }
}
