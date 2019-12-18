package com.apex.Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ApexBaseTest {
	
	public  static WebDriver driver;
	public static Properties prop;

	public void TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/amruthapenigalapati/eclipse-workspace/corejava/src/Basic_java/com.apex.CucuPOM/src/main/java/com/apex/features/ecommerce.feature");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void setup(){
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/amruthapenigalapati/Downloads/chromedriver 2");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all cookies
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	
	  public static void teardown() {
	 
	      driver.quit();
	 
	  }
}
