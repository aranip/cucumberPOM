package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import core.ApexBaseTest;
import core.EcommerceConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefinition extends ApexBaseTest implements EcommerceConstants{
		
@Given("^The person enters chrome browser$")
public void The_person_enters_chrome_browser() throws Throwable {
	ApexBaseTest.setup(); 
}

@Then("^person will be in login Page$")
public void person_will_be_in_login_Page() throws Throwable {
	  Assert.assertEquals("Welcome to Ez Shop Online" , TITLE);
    
}
@Then("^person gives his \"(.*)\" and \"(.*)\"$")
public void person_gives_his(String Username, String Password ) throws Throwable {
	driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys(Username);
 	driver.findElement(By.name(PWD_NAME_LOCATOR)).sendKeys(Password);  
    
}


@Then("^person clicks on signon button$")
public void person_clicks_on_signon_button() throws Throwable {
	driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
    
}

@Then("^validating logged in successfully or not$")
public void validating_logged_in_successfully_or_not() throws Throwable {
	Assert.assertEquals("You have Logged In successfully.",TITLE2);
    
}
}