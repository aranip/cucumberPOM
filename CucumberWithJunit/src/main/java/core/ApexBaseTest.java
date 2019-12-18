package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ApexBaseTest {
	
protected static  WebDriver driver;
	
	public static void setup(){
		System.setProperty("webdriver.chrome.driver", "/Users/amruthapenigalapati/Desktop/chromedriver");
         driver = new ChromeDriver();

        driver.manage().window().maximize();  //maximize window
        driver.manage().deleteAllCookies();  //delete all cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
      //1.launch the url
     	driver.get("http://ecommerce.saipratap.net/");
	}
	
	  public static  void teardown() {
	 
	      driver.quit();
	 
	  }
}
