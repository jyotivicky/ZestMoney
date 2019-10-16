package TestRunner;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

     public class firefoxClass {

	   @Test
		public static void openFirefox() throws MalformedURLException {
	    	
			DesiredCapabilities capp = DesiredCapabilities.firefox();
			URL url = new URL("http://localhost:4444/wd/hub");
			RemoteWebDriver driver  = new RemoteWebDriver(url,capp);
			driver.get("https://freecrm.com");
			System.out.println("The Title Of The Page : " + driver.getTitle());	
	   }
   }