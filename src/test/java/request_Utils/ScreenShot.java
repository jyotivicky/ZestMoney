package request_Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

   public class ScreenShot {
	static WebDriver driver;
	static int i                              = 1;
	public ScreenShot(WebDriver driver) {
		ScreenShot.driver                     = driver;
	}
	public static String CaptureScreen(WebDriver driver, String Cucumber) {
		File sourceFile                       = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64                  = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader             = new FileInputStream(sourceFile);
			String Rundate                    = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			byte[] bytes                      = new byte[(int) sourceFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64                     = new String(Base64.encodeBase64(bytes));
			File file                         = new File("ScreenShot\\");
			String path                       = file.getAbsolutePath();
			String DescFile                   = "ScreenShot\\" + Cucumber + "_" + Rundate + ".png";
			i++;
			System.out.println("Test Case Got Failed Screenshot Taken");
			File destination                  = new File(DescFile);
			FileUtils.copyFile(sourceFile, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}
  }
