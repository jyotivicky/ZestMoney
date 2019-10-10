package TestRunner;

import java.io.File;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "D:\\Selenium_Project\\API_Automation\\feature\\docker.feature", // features file
    		plugin = {"pretty","html:testReport\\indexHtmlReport", // html report
  				  "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", // text report
  				  "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml", // xml report
  				  "html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json", // Report
  				  "com.cucumber.listener.ExtentCucumberFormatter:testReport\\extent.html"},// Extent
																													
		glue       = {"stepDefination"},
		monochrome = true, 
		strict     = true, 
		dryRun     = false,
        tags       = {"@smoke"} 
   )
   public class runner {
	
   }


    // features     = the path of the folder where all feature files are available
    // monocrome    = to display the console output in a proper readable format
    // Plugin       = to generate the test report
    // Glue         = the folder name or path where all the step defination files are available
    // dryRun       = to make sure that every steps defined in feature file has a method or not in step defination class
    // Strict       = to check any step are deifined as a method or not ,it will fail if any step is missing in method
    // tags = {"@SmokeTest"} to run only SmokeTest
    // OR : tags = {"@SmokeTest, @RegressionTest"} to run all test cases whose tags are @SmokeTest OR @RegressionTest 
    // AND : tags = {"@SmokeTest", "@RegressionTest"} to run all test cases whose tags are @SmokeTest AND @RegressionTest 
    // IGNORE : tags = {"~@SmokeTest", "@RegressionTest"} to IGNORE any specific test cases 
			
	
