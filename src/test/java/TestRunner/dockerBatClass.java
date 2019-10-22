package TestRunner;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

   public class dockerBatClass {
	  
	  @BeforeTest
	  public static void start_Docker() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start docker_Up.bat");  
		Thread.sleep(15000);
	  }
	  
	  @AfterTest
	  public static void down_Docker() throws IOException, InterruptedException {
		  Runtime.getRuntime().exec("cmd /c start docker_Down.bat");  
		  Thread.sleep(15000);
		  Runtime.getRuntime().exec("taskkill /f /im cmd.exe");   //to close all the command prompt tabs
	  }

    }
