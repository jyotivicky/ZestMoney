package ZestMoney.testBase;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import ZestMoney.Utility.ReadConfig;
import ZestMoney.Utility.ScreenShot;
import ZestMoney.Utility.globalVar;
import io.github.bonigarcia.wdm.WebDriverManager;

    public class ZestMoneyTestBases {
	public static ReadConfig read = new ReadConfig();
	public static WebDriver driver;
	static File downloadfiles = new File("FileDownload");
	static String downloadFilepath = downloadfiles.getAbsolutePath();

	@BeforeSuite
	public static void SetUp() {
		File file = new File(globalVar.SystemExtentReportPath);
		String path = file.getAbsolutePath();
		globalVar.htmlreporter = new ExtentHtmlReporter(path);
		globalVar.extent = new ExtentReports();
		globalVar.extent.attachReporter(globalVar.htmlreporter);
		globalVar.extent.setSystemInfo("Project", "Zest Money Automation");
		globalVar.extent.setSystemInfo("Environment", "LIve");
		globalVar.extent.setSystemInfo("Test Engineer", "Jyotiprakash");
		globalVar.htmlreporter.config().setTheme(Theme.DARK);
		globalVar.log = Logger.getLogger("Zest Money");
	}

	@BeforeClass
	public static void Initialization() throws InterruptedException, IOException {

		if (ReadConfig.getPropertyValue("browserName").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
			ChromeOptions Chro = new ChromeOptions();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			chromeCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			chromeCapabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
			chromePrefs.put("profile.default_content_settings.cookies", 2);
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("download.prompt_for_download", false);
			Chro.setExperimentalOption("prefs", chromePrefs);
			Chro.addArguments("--test-type");
			Chro.addArguments("chrome.switches", "--disable-extensions");
			Chro.addArguments("disable-popup-blocking");
			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromePrefs);
			chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			chromeCapabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, Chro);
			driver = new ChromeDriver(Chro);

		} else if (ReadConfig.getPropertyValue("browserName").equals("firefox")) {
			WebDriverManager.firefoxdriver().version("latest").setup();
			FirefoxOptions fox = new FirefoxOptions();
			DesiredCapabilities foxCapabilities = DesiredCapabilities.firefox();
			fox.addPreference("browser.download.folderList", 2);
			fox.addPreference("browser.helperApps.alwaysAsk.force", false);
			fox.addPreference("browser.download.dir", downloadFilepath);
			fox.addPreference("browser.download.defaultFolder", downloadFilepath);
			fox.addPreference("browser.download.manager.showWhenStarting", false);
			fox.addPreference("browser.download.panel.shown", false);
			fox.addPreference("browser.download.useDownloadDir", true);
			fox.addPreference("pdfjs.disabled", true);
			fox.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/anytext ," + "text/plain,text/html,application/plain,text/csv");
			foxCapabilities.setCapability(CapabilityType.VERSION, "60");
			foxCapabilities.setCapability(FirefoxDriver.PROFILE, fox);
			foxCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
			driver = new FirefoxDriver(fox);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ReadConfig.getPropertyValue("URL"));
	}

	@AfterMethod
	public void GetResult(ITestResult result) throws Exception {
		if (result.getStatus() == result.SUCCESS) {
			globalVar.test.pass(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case Got Passed",
					ExtentColor.GREEN));
		} else if (result.getStatus() == result.SKIP) {
			globalVar.test.skip(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case Got Skipped",
					ExtentColor.ORANGE));
		} else if (result.getStatus() == result.FAILURE) {
			globalVar.test.fail(MarkupHelper.createLabel(
					result.getMethod().getMethodName() + " Test Case Got Failed Due To Below Issue :",
					ExtentColor.RED));
			globalVar.test.fail(result.getThrowable());
			String Path = ScreenShot.CaptureScreen(driver, "ZestMoney");
			globalVar.test.fail("Test Case Got Failed", MediaEntityBuilder.createScreenCaptureFromPath(Path).build());
		}
	}

	@AfterSuite
	public void TearDown() throws IOException {
		globalVar.extent.flush();
//		driver.close();
//		// Email.SendTestReport();
	}
}

    