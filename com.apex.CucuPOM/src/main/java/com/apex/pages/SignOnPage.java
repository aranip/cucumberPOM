package com.apex.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apex.Constants.SignOnConstant;
import com.apex.Core.ApexBaseTest;


public class SignOnPage extends ApexBaseTest implements SignOnConstant{
	public SignOnPage(){
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = ACCOUNT_CLICK)
	WebElement accountElm;
	@FindBy(name = EMAIL_NAME_LOCATOR)
	WebElement emailIdElm;
	@FindBy(name = PWD_NAME_LOCATOR)
	WebElement passwordElm;
	@FindBy(linkText = LOGIN_BTN_LINK_TEXT_LOCATOR)
	WebElement loginBtnElm;
	@FindBy(xpath = TITLE)
	WebElement title;
	@FindBy(xpath =TITLE1)
	WebElement title1;
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public void EnterDetails(String email, String pwd){
		accountElm.click();
		//enter email
		emailIdElm.sendKeys(email);
		//enter the password
		passwordElm.sendKeys(pwd);
	}
	public void loginButton	(){
		//click on the btn
		loginBtnElm.click();
		
	}
	public String verifyCorrectUserName() {
		return driver.getTitle();
	}
}
