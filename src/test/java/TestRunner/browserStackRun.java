package TestRunner;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


       public class browserStackRun {
	
	   public static final String USERNAME = "vickydas1";
	   public static final String AUTOMATE_KEY = "h5PRyirTSKdfmwPLYpQy";
	   public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	   @Test
	   public static void crossBrowserTest() throws Exception {

		   DesiredCapabilities caps = new DesiredCapabilities();
		   caps.setCapability("os", "Windows");
		   caps.setCapability("os_version", "10");
		   caps.setCapability("browser", "Chrome");
		   caps.setCapability("browser_version", "74.0");
		   caps.setCapability("resolution", "1366x768");
		   caps.setCapability("browserstack.local", "false");
		   caps.setCapability("browserstack.selenium_version", "3.141.59");

	     WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	     driver.get("https://freecrm.com");

	     Thread.sleep(3000);
	     
	     System.out.println("The Title Is : " + driver.getTitle());
	     //driver.quit();

	   }
	 }
  
