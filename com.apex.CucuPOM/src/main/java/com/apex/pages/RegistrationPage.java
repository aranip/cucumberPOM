package com.apex.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apex.Constants.RegistrationConstant;
import com.apex.Core.ApexBaseTest;

public class RegistrationPage extends ApexBaseTest implements RegistrationConstant{
	public RegistrationPage(){
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = ACCT_CLICK)
	WebElement accountElm;
	@FindBy(linkText = SIGNUP_CLICK)
	WebElement signUpElm;
	@FindBy(xpath = GENDER_BTN)
	WebElement Gender;
	@FindBy(name = FIRST_NAME)
	WebElement fname;
	@FindBy(name = LAST_NAME)
	WebElement lname;
	@FindBy(name = DAY)
	WebElement day;
	@FindBy(name = MONTH)
	WebElement month;
	@FindBy(name = YEAR)
	WebElement year;
	@FindBy(name = EMAIL)
	WebElement email;
	@FindBy(name = HOME_NO)
	WebElement homeNo;
	@FindBy(name = ADDR)
	WebElement address;
	@FindBy(name = CITY)
	WebElement city;
	@FindBy(name = STATE)
	WebElement state;
	@FindBy(id = ZIP)
	WebElement zip;
	@FindBy(name = PHONE)
	WebElement phone;
	@FindBy(name = FAX)
	WebElement fax;
	@FindBy(name = PWD)
	WebElement pwd;
	@FindBy(name = CPWD)
	WebElement cpwd;
	@FindBy(id = TERMS)
	WebElement terms;
	@FindBy(name = SUBMIT)
	WebElement submit;
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public void clickOnSignUp(){
		accountElm.click();
		signUpElm.click();
	}
	public void gender(){
		if(!Gender.isSelected())
		{
			Gender.click();
		}
	}
	public void details(String firstName, String lastName, String dateofBirth, String month1, String year1, String mail, String homeNumber, String add, String cityy, String stat, String postal, String phoneNo, String faxno, String PWD, String Cpwd
			){
		fname.sendKeys(firstName);
		lname.sendKeys(lastName);
		day.sendKeys(dateofBirth);
		month.sendKeys(month1);
		year.sendKeys(year1);
		//email.sendKeys("christopher@yahoomail.com");
		email.sendKeys(mail);
		homeNo.sendKeys(homeNumber);
		address.sendKeys(add);
		city.sendKeys(cityy);
		state.sendKeys(stat);
		zip.sendKeys(postal);
		phone.sendKeys(phoneNo);
		fax.sendKeys(faxno);
		pwd.sendKeys(PWD);
		cpwd.sendKeys(Cpwd);
	}
	public void terms(){
		terms.isSelected();
		terms.click();
	}
	public void submit(){
		submit.click();
}
	public void validation(){
		System.out.println("Thank you for signing up. Your account is now created and you can log in by clicking the ACCOUNT button in the main menu above.");
		// Assert.assertEquals("Thank you for signing up. Your account is now created and you can log in by clicking the ACCOUNT button in the main menu above.", s);	 
		 String s1 = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/span")).getText();
		 System.out.println(s1);
	}
}
