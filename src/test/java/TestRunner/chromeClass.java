package TestRunner;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

    public class chromeClass {

    @Test
	public static void openChrome() throws MalformedURLException {
    	
		DesiredCapabilities capp = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver  = new RemoteWebDriver(url,capp);
		driver.get("https://freecrm.com");
		System.out.println("The Title Of The Page : " + driver.getTitle());	
   }
  }
