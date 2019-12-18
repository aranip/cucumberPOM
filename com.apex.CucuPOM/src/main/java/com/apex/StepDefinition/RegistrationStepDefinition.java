package com.apex.StepDefinition;

import org.junit.Assert;

import com.apex.Constants.RegistrationConstant;
import com.apex.Core.ApexBaseTest;
import com.apex.pages.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepDefinition extends ApexBaseTest implements RegistrationConstant{
	RegistrationPage resistration;
	
	@Given("^user opens the browser$")
	public void user_opens_browser()throws Throwable {
		ApexBaseTest.setup(); 
	}
	@When("^user is on login page$")
	public void user_is_on_login_page()throws Throwable {
		resistration = new RegistrationPage();
		   String title = resistration.validateLoginPageTitle();
		  Assert.assertEquals("Welcome to Ez Shop Online" , title);
	}
	
	@Then("^user clicks on signUp button$")
	public void user_clicks_on_signUp_button()throws Throwable {
		resistration = new RegistrationPage();
		resistration.clickOnSignUp();
	}
	@Then("^user checks Gender button$")
	public void user_checks_Gender_button() throws Throwable {
		resistration = new RegistrationPage();
		resistration.gender();
	}
	@Then ("^user enters Contact info \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"and\"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\"and\"([^\"]*)\"and \"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enters_Contact_info(String firstName, String lastName, String dateofBirth, String month1, String year1, String mail, String homeNumber, String add, String cityy, String stat, String postal, String phoneNo, String faxno, String PWD, String Cpwd
			) throws Throwable {
		resistration = new RegistrationPage();
		resistration.details( firstName,lastName,dateofBirth,month1,year1,mail,homeNumber,add,cityy,stat,postal,phoneNo,faxno,PWD,Cpwd);
	}
	@Then ("^user clicks on terms$")
	public void user_clicks_on_terms()  throws Throwable {
		resistration = new RegistrationPage();
		resistration.terms();
	}
	@Then ("^user clicks submit button$")
	public void user_clicks_submit_button()   throws Throwable {
		resistration = new RegistrationPage();
		resistration.submit();
	}
	@Then ("^validate if user signedUP successfully$")
	public void validate_if_user_signedUP_successfully() throws Throwable {
		resistration = new RegistrationPage();
		resistration.validation();
	}
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		ApexBaseTest.teardown();
	}
}
