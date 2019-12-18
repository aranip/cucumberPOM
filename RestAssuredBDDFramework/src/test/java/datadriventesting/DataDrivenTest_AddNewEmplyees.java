package datadriventesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmplyees {

	
	
	@Test
	void postNewEmployees(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		
		//here we created data which we ca send along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "SMITHXYZ");
		requestParams.put("salary", "999999");
		requestParams.put("age", "35");
		
		//add a header stating the request body is a json
		httpRequest.header("content-type", "application/json");
		
		//add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST request
	 Response response = httpRequest.request(Method.POST,"/create");
		
		//capture response body to perform validations
		String responseBody = response.getBody().asString();
	
	Assert.assertEquals(responseBody.contains("SMITHXYZ"),true);
	Assert.assertEquals(responseBody.contains("999999"),true);
	Assert.assertEquals(responseBody.contains("35"),true);
	
	int statusCode= response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	}
}
