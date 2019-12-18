package registrationStepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ApexBaseTest;
import core.RegistrationConstant;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepDefinition extends ApexBaseTest implements RegistrationConstant{
	
	@Given("^user opens the browser$")
	public void user_opens_browser()throws Throwable {
		ApexBaseTest.setup(); 
		throw new PendingException();
	}
	@When("^user is on login page$")
	public void user_is_on_login_page()throws Throwable {
	
		  Assert.assertEquals("Welcome to Ez Shop Online" , TITLE);
		  throw new PendingException();
	}
	
	@Then("^user clicks on signUp button$")
	public void user_clicks_on_signUp_button()throws Throwable {
		driver.findElement(By.linkText("SignUp")).click();
		throw new PendingException();
	}
	@Then("^user checks Gender button$")
	public void user_checks_Gender_button() throws Throwable {
		WebElement list =	driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[5]/td/table/tbody/tr[1]/td[4]/input[2]"));
		if(!list.isSelected())
		{
		    list.click();
		}
		throw new PendingException();
	}
	@Then ("^user enters Contact info \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"and\"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\"and\"([^\"]*)\"and \"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enters_Contact_info(String firstName, String lastName, String dateofBirth, String month1, String year1, String mail, String homeNumber, String add, String cityy, String stat, String postal, String phoneNo, String faxno, String PWD, String Cpwd
			) throws Throwable {
		driver.findElement(By.id("fname")).sendKeys("chitratttrrer");
		
		driver.findElement(By.id("lname")).sendKeys("raghaffds");
		driver.findElement(By.name("day")).sendKeys("9");
		
		driver.findElement(By.name("month")).sendKeys("10");
		
		driver.findElement(By.name("year")).sendKeys("1985");
		
		driver.findElement(By.name("email")).sendKeys("chitra24145@gmail.com");
	
		driver.findElement(By.name("houseno")).sendKeys("19-4-513");
		
		driver.findElement(By.name("add1")).sendKeys("capitol avenue");
		
		driver.findElement(By.name("city")).sendKeys("sanjose");
		
		driver.findElement(By.name("state")).sendKeys("CA");
		
		driver.findElement(By.id("postcode")).sendKeys("95113");
		
		driver.findElement(By.name("phone")).sendKeys("6547658765");
		
		driver.findElement(By.name("fax")).sendKeys("54326");
		
		driver.findElement(By.name("password")).sendKeys("chitra1217787");
		
		driver.findElement(By.name("cpassword")).sendKeys("chitra1217787");
		throw new PendingException();
	}
	@Then ("^user clicks on terms$")
	public void user_clicks_on_terms()  throws Throwable {
		boolean b1 = driver.findElement(By.id("terms")).isSelected();
		 System.out.println(b1);
		 driver.findElement(By.id("terms")).click();
		 System.out.println(b1);
		 throw new PendingException();
	}
	@Then ("^user clicks submit button$")
	public void user_clicks_submit_button()   throws Throwable {
		driver.findElement(By.name("Submit")).click();
		throw new PendingException();
	}
	@Then ("^validate if user signedUP successfully$")
	public void validate_if_user_signedUP_successfully() throws Throwable {
		String s ="Thank you for signing up. Your account is now created and you can log in by clicking the ACCOUNT button in the main menu above.";
		String s1 = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/span")).getText();
		if( s == s1){
		 Assert.assertEquals("Thank you for signing up. Your account is now created and you can log in by clicking the ACCOUNT button in the main menu above.",s1);
		}else{
		 String s2 = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/span")).getText();
		 System.out.println(s2);
		 Assert.assertEquals("This email address is already registered.", s2);
		 throw new PendingException();
	}
}
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		ApexBaseTest.teardown();
		throw new PendingException();
	}
}
