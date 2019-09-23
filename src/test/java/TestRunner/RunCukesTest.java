package TestRunner;

import java.io.File;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import Utility.EmailReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", // features file
		plugin = { "html:target/cucumber-html-report", // html report
				"json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", // text report
				"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml", // xml report
				"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json", // Report
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html"},// Extent
																													
		glue= {"step_definitions"},
		monochrome = true, // display the console output in a proper readable format
		strict = true, // it will check if any step is not defined in step definition file
		dryRun = true, // to check the mapping is proper between feature file and step def file
		tags = {"@createCase"} 

//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest		
)
public class RunCukesTest {
	
	}
	
	
	
	
	

			
	
