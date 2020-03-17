package ZestMoney.pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ZestMoney.Utility.globalVar;


    public class browserBot {
	public static WebElement SelectedVisibleValue;
	public static WebDriver driver = null;
	
	public browserBot(WebDriver driver) {
		this.driver= driver;
	}

	/*
	 * to validate with Assert Equals
	 */
	public static void validateWithAssertEquals(String Actual,String Expected) {
		Assert.assertEquals(Actual, Expected);
	}
	/*
	 * to wait till load the page using Implicitly wait
	 */
	public static void wait_Implicitly(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(globalVar.Implictly_Wait, TimeUnit.SECONDS);
	}
	/*
	 * to wait till 1 second forcefully
	 */
	public static void wait_10() throws InterruptedException {
		Thread.sleep(globalVar.Wait_1000);
	}
	/*
	 * to wait till 2 second forcefully
	 */
	public static void wait_20() throws InterruptedException {
		Thread.sleep(globalVar.Wait_2000);
	}
	/*
	 * to wait till 3 second forcefully
	 */
	public static void wait_30() throws InterruptedException {
		Thread.sleep(globalVar.Wait_3000);
	}
	/*
	 * to wait till web element is visible in the web page
	 */
	public static void WaitTillVisibility(WebElement element, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, globalVar.Explicitly_Wait240);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		element.sendKeys(Text);
	}
	/*
	 * to wait till web element is Clickable
	 */
	public static void clickTheElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, globalVar.Explicitly_Wait240);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	/*
	 * to wait till expcted title is present
	 */
	public static void WaitTillTitlePresent(WebDriver driver, String Title) {
		WebDriverWait wait = new WebDriverWait(driver, globalVar.Explicitly_Wait240);
		wait.until(ExpectedConditions.titleContains(Title));
	}

	/*
	 * to wait till web element is visible in the web page using java script
	 */
	public static void waitTillPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			wait_10();
			WebDriverWait wait = new WebDriverWait(driver, globalVar.Explicitly_Wait240);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	/*
	 * to open a new window in webpage
	 */
	public static void NewWindow(WebDriver driver) throws IOException {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.chord(Keys.ARROW_DOWN)).perform();
	}

	/*
	 * to open a new tab using  Class
	 */
	public static void openNewTab(WebDriver driver) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		wait_20();
	}

	/*
	 * to close the current window and come back to the parent window
	 */
	public static void CloseWindow(WebDriver driver, int i) {
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}

	/*
	 * to pass driver control to any tab based on the tab number
	 */
	public static void PassWindowControl(WebDriver driver, int i) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.switchTo().window(tabs.get(i));
	}

	/*
	 * to Move to a cordinate to perform any operation based on the X and Y
	 * Cordinate and wait till the element Visible
	 */
	public static void MoveToCordinateVisible(WebDriver driver, WebElement element) {
		int xCord = element.getLocation().getX();
		int yCord = element.getLocation().getY();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(element));
		act.moveToElement(element, xCord, yCord).perform();
		act.click(element).build().perform();
	}

	/*
	 * to Move to a cordinate to perform Click() based on the X and Y Cordinate and
	 * wait till the element Clickable
	 */
	public static void MoveToCordinateClickable(WebDriver driver, WebElement element) {
		int xCord = element.getLocation().getX();
		int yCord = element.getLocation().getY();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		act.moveToElement(element, xCord, yCord).build().perform();
		act.click(element).perform();
	}

	/*
	 * to handle any expected alert in webpage and return to main page
	 */
	public void acceptAlertAndReturn() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	/*
	 * to Read alert text
	 */
	public String getAlertText() throws Exception {
		String myalert = driver.switchTo().alert().getText();
		return myalert;
	}

	/*
	 * to Accept the Alert
	 */
	public void AcceptAlert() throws Exception {
		driver.switchTo().alert().accept();
	}

	/*
	 * to Dismiss the Alert
	 */
	public void DismissAlert() throws Exception {
		driver.switchTo().alert().dismiss();
	}

	/*
	 * to Enter Text in Alert Prompt pop-up
	 */
	public void enterTextInAlertPopUp(String text) throws Exception {
		driver.switchTo().alert().sendKeys(text);
	}

	/*
	 * to Navigate the browser Forward
	 */
	public void navigateForward() throws Exception {
		driver.navigate().forward();
	}

	/*
	 * to navigate the browser Back
	 */
	public static void navigateBack() throws Exception {
		driver.navigate().back();
	}

	/*
	 * to refresh the page
	 */
	public void browserRefresh() throws Exception {
		driver.navigate().refresh();
	}
	
	/*
	 * to enter any value in text box using sendkeys
	 */
	public static String getTextAndReturn(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		String viewText = element.getText();
		return viewText;
	}

	/*
	 * to enter any value in text box using sendkeys
	 */
	public static void sendText(WebDriver driver, WebElement element, String Text, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		element.sendKeys(Text);
	}

	/*
	 * to click and webelement using Click()
	 */
	public static void ToClick(WebDriver driver, WebElement element, int timeout) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		wait_30();
	}

	/*
	 * to clear any text box using Clear()
	 */
	public static void ToClear(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		element.clear();
	}

	/*
	 * to Switch to Parent/Default Window or Parent/Default Frames
	 */
	public static void switchToParentWindow() throws Exception {
		driver.switchTo().defaultContent();
	}

	/*
	 * to Switch to Frame By ID
	 */
	public static void switchToFrameById(String frameId) throws Exception {
		driver.switchTo().frame(frameId);
	}

	/*
	 * to Switch to Frame By Index
	 */
	public static void switchToFrameUsingIndex(int frameIndex) throws Exception {
		driver.switchTo().frame(frameIndex);
	}

	/*
	 * to Switch to Frame By Webelement
	 */
	public static void switchToFrameUsingXpath(WebElement element) throws Exception {
		driver.switchTo().frame(element);
	}

	/*
	 * to enter any text inside the frame
	 */
	public static void ToEnterValueInsideAFrame(String str) {
		driver.findElement(By.cssSelector("body")).sendKeys(str);
	}

	/*
	 * to click and hold the text entered inside the Frame
	 */
	public static void ToHoldTheTextInsideFrame() {
		WebElement element = driver.findElement(By.cssSelector("body"));
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		String TextInsideTheFrame = driver.findElement(By.cssSelector("body")).getCssValue("font-weight");
	}

	/*
	 * to scroll down the page
	 */
	public static void ScroolDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
	}

	/*
	 * to scroll up the page
	 */
	public static void ScroolUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-970)", "");
	}

	/*
	 * to scroll to any perticular element in the web page
	 */
	public static void scrollToelement(WebDriver driver, WebElement element) throws InterruptedException {
		WebElement ele = element;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	/*
	 * to go any perticular element in the web page using action class
	 */
	public static void scrollToCordinate(WebDriver driver, WebElement element) throws InterruptedException {
		int xCord = element.getLocation().getX();
		int yCord = element.getLocation().getY();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		act.moveToElement(element, xCord, yCord).build().perform();
		act.click(element).perform();
	}

	/*
	 * to select a year based on the text of the Year
	 */
	public static void SelectYear(WebDriver drive, WebElement YearList, WebElement Previous, String ClickYear) {
		String currentYear = YearList.getText();
		if (!currentYear.equals(ClickYear)) {
			do {
				Previous.click();
			} while (!YearList.getText().equals(ClickYear));
		}
	}

	/*
	 * to select month based on the text of the month
	 */
	public static void SelectMonth(WebDriver driver, WebElement MonthList, WebElement MonthClick, String ClickMonth) {
		String currentMonth = MonthList.getText();
		if (!currentMonth.equalsIgnoreCase(ClickMonth)) {
			do {
				MonthClick.click();
			} while (!MonthList.getText().trim().equalsIgnoreCase(ClickMonth));
		}
	}

	/*
	 * to click the next month button in the calendar pop up
	 */
	public static void SelectNextMonth(WebDriver driver, WebElement MonthList, WebElement Previous, String ClickMonth) {
		String currentMonth = MonthList.getText();
		if (!currentMonth.equalsIgnoreCase(ClickMonth)) {
			do {
				Previous.click();
			} while (!MonthList.getText().trim().equalsIgnoreCase(ClickMonth));
		}
	}

	/*
	 * to select a date from the date list based on the text of the date entered
	 */
	public static void SelectDate(WebDriver driver, List<WebElement> DateList, String SelectDate) {
		List<WebElement> Dates = DateList;
		for (int i = 0; i < Dates.size(); i++) {

			String GetDate = Dates.get(i).getText();
			if (GetDate.equals(SelectDate)) {
				DateList.get(i).click();
			}
		}
	}

	/*
	 * to select based on value
	 */
	public static void selectingByvalue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/*
	 * to select based on text
	 */
	public static void selectingByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/*
	 * to select based on Index (Index start from Zero)
	 */
	public static void seleictingByIndex(WebElement element, int index) throws InterruptedException {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/*
	 * to select based on Visible text
	 */
	public static void selectingByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/*
	 * to return the selected value in select dropdown box
	 */
	public static WebElement FirstSelectedOption(WebElement element) {
		Select sel = new Select(element);
		WebElement SelectedValue = sel.getFirstSelectedOption();
		return SelectedValue;
	}

	/*
	 * to randomly select a value from a select box
	 */
	public static void RandomSelect(WebElement element) throws InterruptedException {
		WebElement SelectList = element;
		Select Sel = new Select(SelectList);
		List<WebElement> weblist = Sel.getOptions();
		int inum = weblist.size();
		Random num = new Random();
		int iSelect = num.nextInt(inum);
		Sel.selectByIndex(iSelect);
		String SelectedText = weblist.get(iSelect).getText();
		wait_20();
	}

	/*
	 * to select a value from a range from a list of webelement
	 */
	public static void SelectInARange(WebElement element) throws InterruptedException {
		WebElement SelectList = element;
		Select Sel = new Select(SelectList);
		List<WebElement> weblist = Sel.getOptions();
		int inum = weblist.size();
		for (int i = 2; i < weblist.size() - 4; i++) {
			Sel.selectByIndex(i);
		}
	}

	/*
	 * to select a value randomly from list of webelement
	 */
	public static void RandomListSelect(List<WebElement> element) throws InterruptedException {
		List<WebElement> weblist = element;
		int iCnt = weblist.size();
		Random num = new Random();
		int iList = num.nextInt(iCnt);
		wait_20();
		weblist.get(iList).click();
	}

	/*
	 * to return a value once selected a value from a select box
	 */
	public static WebElement GetVisibleSelectedValue(WebElement element, String STR) {
		Select sel = new Select(element);
		sel.selectByVisibleText(STR);
		WebElement SelectedValue = sel.getFirstSelectedOption();
		return SelectedVisibleValue;
	}
	
	/*
	 * to convert the Amazon text to integer
	 */
	public static int priceAmazonConvert(String st) {
		   String intValue = st.replaceAll("[^0-9]", "");
		   String s3 =intValue.substring(0, intValue.length() - 2);
		   int Price = Integer.parseInt(s3);
		   return Price;
	}
	
	/*
	 * to convert flipkart price
	 */
	public static int priceFlipkartConvert(String st) {
		   String intValue2 = st.replaceAll("[^0-9]", "");
		   int FlipkartPrice = Integer.parseInt(intValue2);
		   return FlipkartPrice;
	}

  }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    