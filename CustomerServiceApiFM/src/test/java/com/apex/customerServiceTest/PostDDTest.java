package com.apex.customerServiceTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.api.core.ApexBaseServiceTest;
import com.apex.api.core.XLSUtil;
import com.apex.api.core.XmlParserUtilDD;
import com.apex.customerServiceTest.Constants.CustomerServiceConstant;

public class PostDDTest extends ApexBaseServiceTest implements CustomerServiceConstant {

	@DataProvider(name = "data")
	public Object[][] getData() throws Exception  {
		String[][] data = XLSUtil.readfromSpreadSheet("data.xls", "Sheet1", "successids");
		return data;
	}

	@Test(dataProvider = "data")
	public void testWithPositiveNumber(String id, String fName, String lName, String street, String city)
			throws ClientProtocolException, IOException {
		// setData(id,fName,lName,add,city);
		System.out.println(id + fName + lName + street +city);

		XmlParserUtilDD.parserMethod(id, fName, lName, street, city);

	}
}
