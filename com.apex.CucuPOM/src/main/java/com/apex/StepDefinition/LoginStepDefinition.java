package com.apex.StepDefinition;

import org.junit.Assert;


import com.apex.Constants.SignOnConstant;
import com.apex.Core.ApexBaseTest;
import com.apex.pages.SignOnPage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefinition extends ApexBaseTest implements SignOnConstant{
	SignOnPage signOn;
		
	@Given("^customer opens browser$")
	public void customer_opens_browser() throws Throwable {
		ApexBaseTest.setup(); 
	}

	@Then("^customer is on login Page$")
	public void customer_is_on_login_Page() throws Throwable {
		   String title = signOn.validateLoginPageTitle();
		  Assert.assertEquals("Welcome to Ez Shop Online" , title);
	}

	@Then("^customer gives his \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_gives_his_and(String Username, String Password) throws Throwable {
		signOn.EnterDetails(Username, Password);
	}

	@Then("^customer clicks on signon button$")
	public void customer_clicks_on_signon_button() throws Throwable {
		signOn.loginButton();
	}

	@Then("^validate logged in successfully$")
	public void validate_logged_in_successfully() throws Throwable {
		String title = signOn.verifyCorrectUserName();
	    Assert.assertEquals("You have Logged In successfully.",title);
	}

}
//	
//@Given("^customer opens browser$")
//public void customer_opens_browser() throws Throwable {
//		   ApexBaseTest.setup(); 
//}
//
//@Then("^customer is on login Page$")
//public void customer_is_on_login_Page() throws Throwable {
//	signOn = new SignOnPage();
//	   String title = signOn.validateLoginPageTitle();
//	  Assert.assertEquals("Welcome to Ez Shop Online" , title);
//}
//
//@Then("^customer gives his \"([^\"]*)\" and \"([^\"]*)\"$")
//public void customer_logs_into_app(String Username, String Password) throws Throwable {
//	signOn = new SignOnPage();
//	signOn.EnterDetails(Username, Password);
//
//}
//
//@Then("^customer clicks on signon button$")
//public void customer_clicks_on_signon_button() throws Throwable {
//	signOn = new SignOnPage();
//	signOn.loginButton();
//}
//
//@Then("^validate logged in successfully$")
//public void validate_logged_in_successfully() throws Throwable {
//	String title = signOn.verifyCorrectUserName();
//    Assert.assertEquals("You have Logged In successfully.",title);
//}
//
//}

