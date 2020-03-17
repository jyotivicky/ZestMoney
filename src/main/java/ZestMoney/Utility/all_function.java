package ZestMoney.Utility;

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

    public class all_function {
	public static WebElement SelectedVisibleValue;
	public static WebDriver driver = null;
	
	public all_function(WebDriver driver) {
		this.driver= driver;
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
	 * to wait till expected title is present
	 */
	public static void WaitTillTitlePresent(WebDriver driver, String Title) {
		WebDriverWait wait = new WebDriverWait(driver, globalVar.Explicitly_Wait240);
		wait.until(ExpectedConditions.titleContains(Title));
	}

	/*
	 * to wait till web element is visible in the web page using java script
	 */
	public static void WaitTillPageLoad() {
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
	 * MouseOver by JavaScript-
	 */
	public static void mouseOverByJS(String elementName, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].onmouseover()", element);
	}

	/*
	 * to handle mouse hover webelement
	 */
	public static void MoveToElement(WebDriver driver, WebElement element) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		wait_30();
	}

	/*
	 * to hit Enter
	 */
	public static void Enter(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		wait_30();
	}

	/*
	 * to perform drag and drop
	 */
	public static void dragAndDropByActions(WebElement fromElement, WebElement ToElement) {
		Actions act = new Actions(driver);
		Action dragAndDrop = act.clickAndHold(fromElement).moveToElement(ToElement).release(ToElement).build();
		dragAndDrop.perform();
	}

	/*
	 * to perform double click on a element
	 */
	public static void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element);
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
	public static void SendKeys(WebDriver driver, WebElement element, String Text, int timeout) {
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


}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    