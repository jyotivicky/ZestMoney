package ZestMoney.TestCases;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ZestMoney.Utility.ReadConfig;
import ZestMoney.Utility.globalVar;
import ZestMoney.pageObject.browserBot;
import ZestMoney.testBase.ZestMoneyTestBases;

    public class Zest_MoneyAssignmentTest extends ZestMoneyTestBases {
	   
	   @Test(groups = { "regression" }, testName = "Zest Assignment Test")  
	   public static void ZestTest() throws InterruptedException, AWTException{
	   globalVar.test        = globalVar.extent.createTest("Price Compare in Flipkart and Amazon");	
	   
	   driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone XR (64GB) - Yellow");
	   driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
	   browserBot.wait_20();
 
	   List<WebElement>ele = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']//span"));
	   for(int i=0;i<ele.size();i++) {
		   String str = ele.get(i).getText();
		   browserBot.wait_20();
		   if(str.contains("iPhone XR (64GB) - Yellow")) {
			   ele.get(i).click();
			   break;
		   }
		   else {
			   System.out.println("Product Not Found");
		   }
	   }
	   browserBot.wait_10();
	   browserBot.PassWindowControl(driver, 1);
	   browserBot.wait_10();
	   String price = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText();
	   
	   int amazonPrice = browserBot.priceAmazonConvert(price);

	   browserBot.openNewTab(driver);
	   browserBot.PassWindowControl(driver, 2);

	   driver.navigate().to(ReadConfig.getPropertyValue("URL_2"));
	   browserBot.wait_Implicitly(driver);
	   driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	   
	   driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("iPhone XR (64GB) - Yellow");
	   driver.findElement(By.xpath("//button[@type='submit']")).click();

	   String flipkartprice = driver.findElement(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")).getText();
	   
	   int FlipkartPrice =  browserBot.priceFlipkartConvert(flipkartprice);

	   if(amazonPrice>FlipkartPrice) {
		   globalVar.test.log(Status.PASS, "Amazon Price is Greater than Flipkart");
	   }
	   if(amazonPrice<FlipkartPrice) {
		   globalVar.test.log(Status.PASS, "Flipkart Price is Greater than Amazon");
	   }else
	   {
		   globalVar.test.log(Status.PASS, "Price Is Same in Both Flipkart and Amazon");
		   System.out.println("Price Is Same");
	   }
	   
	   }

   }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    