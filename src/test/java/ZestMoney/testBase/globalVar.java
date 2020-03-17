package testBase;
//To Store Variable Which Are Constant

import java.io.File;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import request_Utils.ReadConfig;

    public class globalVar {	
    public static WebDriver driver;    
    /*
     * wait variables
     */
	public static final int Wait_1000                                         = 1000;
	public static final int Wait_2000                                         = 2000;
	public static final int Wait_3000                                         = 3000;
	public static final int Implictly_Wait                                    = 120;
	public static final int Explicitly_Wait120                                = 120;
	public static final int Explicitly_Wait240                                = 240;
    	
	/*
	 * these variables are extent report file location
	 */
	public static final String SystemExtentReportPath                         = "testCaseResult\\testReport.html";	
	
	/*
	 * variables for properties file path
	 */
	public final static String SystemConfigPath                               = "Configuration_File\\Config.properties";
		
	/*
	 * these variables to generate report
	 */
	public static Logger log;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	/*
	 * these variables to create a file download folder
	 */
	public static File downloadfiles                                          = new File("FileDownload");
	public static String downloadFilepath                                     = downloadfiles.getAbsolutePath();
	
    /*
    * these variables are for the data read from the properties file
    * to read data like username, password,url
    */	
	public static ReadConfig config                                           = new ReadConfig();	

     private globalVar() {
     }
    }

    
    
    
    
    
    
    
    
    
    
    
    