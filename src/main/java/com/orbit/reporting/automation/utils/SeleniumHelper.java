package com.orbit.reporting.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orbit.reporting.automation.logger.Log;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumHelper {
	// public static WebDriver driver;
	public static int WAIT_SECONDS = 5;
	public static int WAIT_FOR_SECONDS = 30;
	private static InputStream inputStream;
	private static Properties testProps;
	public static String subFolderName;
	private static Logger logger = Logger.getLogger("Browser");
	public static int scount = 1;

	public static String getText(WebElement element) {
		return element.getText();
	}

	/**
	 * Use this method to right click on a element to open the content menu
	 * 
	 * @param element
	 *            Name of the element on which right click to be performed
	 */
	public static void rightClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();
			waitFor(4000);
			Log.info("Right clicked on element: " + element);
		} catch (StaleElementReferenceException e) {
			Log.info("Stale Element " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			Log.info("Element " + element + " was not found " + e.getStackTrace());
		} catch (Exception e) {
			Log.info("Element " + element + " was not clickable " + e.getStackTrace());
		}
	}

	/**
	 * Use this method to double click on an element
	 * 
	 * @param element
	 *            Webelement to double click
	 */
	public static void doubleClick(WebDriver driver, WebElement element) {
		try {

			Actions action = new Actions(driver).doubleClick(element);
			action.build().perform();
			waitFor(4000);
			Log.info("Double clicked element: " + element);
		} catch (StaleElementReferenceException e) {
			Log.info("Element is not attached to the page document " + e.getMessage());
		} catch (NoSuchElementException e) {
			Log.info("Element was not found in DOM " + e.getMessage());
		} catch (Exception e) {
			Log.info("Element was not clickable " + e.getMessage());
		}
	}

	/*
	 * private static class BrowserCleanup implements Runnable { public void
	 * run() { Log.info("BrowserCleanup"); driver.close(); } }
	 */
	/**
	 * Use this method to load a particular URL
	 * 
	 * @param url
	 *            Name of the URL to load
	 */
	public static void loadPage(WebDriver driver, String url) {
		Log.info("Directing browser to:" + url);
		Log.info("Load page: [" + url + "]");
		driver.get(url);
	}

	/**
	 * Use this method to reopen the current browser session and load the URL
	 * 
	 * @param url
	 *            Name of the URL to load
	 */
	public static void reopenAndLoadPage(WebDriver driver, String url) {
		driver = null;

		loadPage(driver, url);
	}

	public static WebElement waitForElement(WebDriver driver, WebElement elementToWaitFor) {
		return waitForElement(driver, elementToWaitFor, null);
	}

	public static WebElement waitForElement(WebDriver driver, WebElement elementToWaitFor, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = WAIT_FOR_SECONDS;
		}

		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}

	/**
	 * Use this method to wait until the element can be clicked
	 * 
	 * @param elementToWaitFor
	 *            element to wait for
	 * @param waitTimeInSeconds
	 *            wait in seconds
	 * @return Returns an web element
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement elementToWaitFor,
			Integer waitTimeInSeconds) {
		Log.info("Waiting for element to be clickable: " + elementToWaitFor);
		Log.info("elementToWaitFor: " + elementToWaitFor.toString());
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = WAIT_FOR_SECONDS;
		}

		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
		wait.withMessage("Waiting for the element to be clickable");
		return wait.until(ExpectedConditions.elementToBeClickable(elementToWaitFor));
	}

	public static WebElement getParent(WebElement element) {
		return element.findElement(By.xpath(".."));
	}

	/**
	 * Get a node's previous node (equivalent to DOM's "previousSibling"
	 * attribute)
	 */
	public static WebElement getPreviousSibling(WebDriver driver, WebElement element) {
		Object response = ((JavascriptExecutor) driver).executeScript("return arguments[0].previousSibling", element);
		if (response instanceof WebElement) {
			return (WebElement) response;
		} else {
			return null;
		}
	}

	public static List<WebElement> getDropDownOptions(WebElement webElement) {
		Select select = new Select(webElement);
		return select.getOptions();
	}

	public static WebElement getDropDownOption(WebElement webElement, String value) {
		WebElement option = null;
		List<WebElement> options = getDropDownOptions(webElement);
		for (WebElement element : options) {
			if (element.getAttribute("value").equalsIgnoreCase(value)) {
				option = element;
				break;
			}
		}
		return option;
	}

	public static String getPageHTML(WebDriver driver) {
		return driver.getPageSource();
	}

	public static WebElement waitforelementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.withMessage("Waiting for the element to be clickable");
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * Use this method to click on desired webelement and wait after clicking
	 * the element
	 * 
	 * @param element
	 *            Name of the element to be clicked
	 * @param waitForElement
	 *            Name of the element to wait for after clicking
	 */
	public static void click(WebDriver driver, WebElement element, WebElement waitForElement) {
		waitForElementToBeClickable(driver, element, null);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		Log.info("clicked element: " + element);
		waitForElementToBeClickable(driver, waitForElement, null);
	}

	public static void sendKeys(WebDriver driver, By by, String text) {
		try {
			WebElement element = driver.findElement(by);
			element.clear();
			Log.info("Typing text: " + text);
			typeChar(element, text);
		} catch (NoSuchElementException e) {
			Log.info("Element not found: " + e.getMessage());
		}
	}

	/*
	 * public static void sendKeys(WebElement element, String text) {
	 * waitForElement(element); JavascriptExecutor jsExecutor =
	 * ((JavascriptExecutor) driver);
	 * jsExecutor.executeScript("arguments[0].value='"+text+"';", element);
	 * waitFor(200); }
	 */

	public static void sendKeys(WebDriver driver, WebElement element, String text) {
		Log.info("Typing text: " + text);
		waitForElement(driver, element);

		element.clear();
		typeChar(element, text);
	}

	private static void typeChar(WebElement element, String text) {
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
			waitFor(5);
		}
	}

	/**
	 * Use this method to press a desired key
	 * 
	 * @param key
	 */
	public static void press(WebDriver driver, Keys key) {
		new Actions(driver).keyDown(key).keyUp(key).perform();
	}

	/**
	 * Use this method to switch the focus to iFrame
	 * 
	 * @param element
	 *            frame webelement
	 */
	public static void switchToFrame(WebDriver driver, WebElement element) {
		try {
			waitForElement(driver, element);
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			Log.info("Unable to locate frame with element " + element + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			Log.info("Element with " + element + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			Log.info("Unable to navigate to frame with element " + element + e.getStackTrace());
		}
	}

	public static void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * Use this method to wait for specified milliseconds
	 * 
	 * @param millis
	 *            Milliseconds to wait for
	 */
	public static void waitFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Use this method to get a XPATH of the desired webelement
	 * 
	 * @param element
	 *            Name of the element for which XPATH is needed
	 * @return Returns the XPATH as string
	 */
	public static String getXPath(WebDriver driver, WebElement element) {
		String jscript = "function getPathTo(node){" + " var stack = [];" + " while(node.parentNode !== null) {"
				+ "  stack.unshift(node.tagName + '[id=' + node.id + ',class=' + node.className + ']');"
				+ "  node = node.parentNode;" + " }" + " return stack.join('/');" + "}"
				+ "return getPathTo(arguments[0]);";
		return (String) ((JavascriptExecutor) driver).executeScript(jscript, element);
	}

	/**
	 * For some reason, getting children using By.CssSelector is very slow with
	 * WebElement... this is so much faster
	 */
	public static List<WebElement> getChildren(WebDriver driver, WebElement element) {
		String jscript = "return arguments[0].childNodes";
		List<Object> children = (List<Object>) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].childNodes", element);
		List<WebElement> elements = new ArrayList<WebElement>();
		for (Object child : children) {
			if (child instanceof WebElement) {
				elements.add((WebElement) child);
			}
		}
		return elements;
	}

	public static boolean isDisplayed(WebElement element) {
		int numberOfIterations = WAIT_SECONDS * 5;
		for (int i = 0; i < numberOfIterations; i++) {
			if (element.isDisplayed()) {
				return true;
			} else {
				waitFor(200);
			}
		}
		return false;
	}

	public static boolean isNotDisplayed(WebElement element) {
		Log.info("isNotDisplayed: " + element);
		int numberOfIterations = WAIT_SECONDS * 5;
		// if element is deleted return true (i.e catch noSuchElementException)
		try {
			for (int i = 0; i < numberOfIterations; i++) {
				if (element.isDisplayed()) {
					Log.info("Waiting for 200ms");
					waitFor(200);
				} else {
					return true;
				}
			}
			return false;
		} catch (NoSuchElementException e) {
			return true;
		} catch (StaleElementReferenceException e) {
			return true;
		}
	}

	/**
	 * Use this method to wait for emelemt to disappear from the screen
	 * 
	 * @param xpath
	 *            XPATH to the element
	 * @return true if the element is present even after 15 secs, otherwise
	 *         false
	 */
	public static boolean waitForElementToDisappear(WebDriver driver, String xpath) {
		Log.info("waitForElementToDisappear: " + xpath);

		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);

			boolean elementStatus = webDriverWait.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

			return elementStatus;
		} catch (Exception e) {
			Log.info("Either element still visible on page or something went wrong: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Use this method to wait for a particular element on screen
	 * 
	 * @param xpath
	 *            XPATH string to the element on screen
	 */
	public static void waitForElement(WebDriver driver, String xpath) {
		Log.info("waitForElement: " + xpath);

		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);

		webDriverWait.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class)
				.withMessage("Waiting for the element to be clickable")
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * Use this method to wait for a particular text to appear on screen
	 * 
	 * @param element
	 *            Webelement where text will be shown
	 * @param text
	 *            Text to be matched
	 */
	public static void waitForText(WebDriver driver, final WebElement element, String text) {
		Log.info("waitForText: " + text);
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.withMessage("Waiting for the text: " + text)
				.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Use this method to wait for a particular text to appear on screen
	 * 
	 * @param text
	 *            Text to be matched
	 */
	public static void waitForText(WebDriver driver, final String text) {
		Log.info("waitForText: " + text);
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.withMessage("Waiting for the text: " + text)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
	}

	/**
	 * This method will wait for both Javascript and jQuery to finish loading
	 * 
	 * @return
	 */
	public static boolean waitForPageLoad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	/**
	 * USe this method to execute JavaScript
	 * 
	 * @param jsCode
	 *            JavaScript snippet to be executed by web driver
	 */
	public static void executeJS(WebDriver driver, String jsCode) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsCode);
	}

	public static void MouseOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public static void MouseOverOn(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public static void openNewTab(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}

	/**
	 * Use this method to switch to tab next to current one
	 */
	public static void switchToTab(WebDriver driver) {
		// Switching between tabs using CTRL + tab keys.
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

		Log.info("Switched to TAB with its Title: " + driver.getTitle());

		// Switch to current selected tab's content.
		driver.switchTo().defaultContent();
	}

	/**
	 * Use this method to click YES on the confirmation popup
	 */
	public static void confirm(WebDriver driver) {
		/*
		 * try { WebDriverWait webDriverWait = new WebDriverWait(driver,2);
		 * webDriverWait.until(ExpectedConditions.alertIsPresent()); Alert alert
		 * = driver.switchTo().alert(); Log.info("Alert text is " +
		 * alert.getText()); alert.accept(); } catch (NoAlertPresentException e)
		 * { Log.info(""); } catch (Exception e) {
		 * Log.info("Something went wrong: " + e.getMessage()); }
		 */
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public static int getFrameCount(WebDriver driver) {
		int totalFrames = driver.findElements(By.xpath("//iframe")).size();
		return totalFrames;
	}

	public static WebElement getCurrentFrameElement(WebDriver driver) {
		WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript("return window.frameElement");
		return element;
	}

	/*
	 * public static WebElement dynamicWaitToDisplayElement( final WebElement
	 * element, WebDriver driver) { new
	 * FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.MINUTES)
	 * .pollingEvery(5, TimeUnit.SECONDS)
	 * .ignoring(NoSuchElementException.class) .until(new Predicate<WebDriver>()
	 * { public boolean apply(WebDriver d) { return element.isDisplayed(); } });
	 * 
	 * return element; }
	 */

	public static String getProperty(String strName) {
		final java.util.Properties PROPS = new java.util.Properties();
		final String PROPERTIES_FILE = "./src/test/resources/Properties/conf.properties";
		java.io.FileInputStream fis = null;
		try {
			fis = new java.io.FileInputStream(PROPERTIES_FILE);
		} catch (java.io.FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PROPS.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return PROPS.getProperty(strName);
	}

	public static void openAEM_WCM(WebDriver driver) throws IOException {
		inputStream = new FileInputStream("./src/test/resources/Properties/login.properties");
		testProps = new Properties();
		testProps.load(inputStream);

		driver.get(testProps.getProperty("AEM_WCM") + "");
		driver.manage().window().maximize();
	}

	public static String getRandomText(int length) {
		StringBuilder b = new StringBuilder();
		Random r = new Random();

		for (int i = 0; i < length; i++) {
			char c = (char) (65 + r.nextInt(25));
			b.append(c);

		}
		return b.toString();
	}

	public static void saveScreenshot(String folderName, String methodName, String screenshotFileName, WebDriver driver,
			String status) throws IOException {

		screenshotFileName = scount++ + "_" + screenshotFileName;

		// creating sub folder name with passing value and date and time
		if ("Start".equalsIgnoreCase(status)) {
			subFolderName = methodName + "_" + getDateTime();
		}

		File mainFolder = new File(folderName);
		File subFolder = new File(subFolderName);
		File screenshot = null;

		// if the test case step is first one then we are creating subfolder
		// with above subfolder name

		try {
			if (subFolder.exists() == false) {
				subFolder.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// checking main folder is existing or not based on that main folder
		// will be created with passing value
		try {
			if (mainFolder.exists() == false) {
				mainFolder.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if ("Alert".equalsIgnoreCase(status)) {
			screenshot = takeAlertScreenShot(screenshotFileName);
		} else {
			// taking the screenshot for the passing step
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// taking screenshot and moving into subfolder
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		}

		// moving the screenshot to subfolder
		FileUtils.moveFileToDirectory(new File(screenshotFileName), subFolder, false);

		// if testcase step is last one then moving sub folder to main folder.
		if ("End".equalsIgnoreCase(status)) {
			// moving sub folder to main folder
			FileUtils.moveDirectoryToDirectory(subFolder, mainFolder, false);
		}
	}

	/**
	 * Used this method to take screen shots
	 * 
	 * @param screenshotFileName
	 * @return
	 */
	private static File takeAlertScreenShot(String screenshotFileName) {
		try {
			Thread.sleep(1000);
			BufferedImage image = new Robot()
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(screenshotFileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new File(screenshotFileName);
	}

	public static String getDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		return dateFormat.format(date).toString();

	}

	/**
	 * Used this method to switch window
	 */
	public static void switchToWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String windw = null;

		while (it.hasNext()) {

			windw = it.next();
			System.out.println("sub window" + windw);

		}
		driver.switchTo().window(windw);
	}

	/**
	 * Used this method to execute Java script
	 * 
	 * @param type
	 * @param ele
	 * @param arg
	 */
	public static void executeJSScript(WebDriver driver, String type, WebElement ele, String arg) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		if (arg.equalsIgnoreCase("test"))
			jse.executeScript(type, ele);
		else
			jse.executeScript(type, arg);
	}

	/**
	 * Use this method to drag and drop component
	 * 
	 * @param sourceElement
	 * @param destinationElement
	 */
	public static void dragAndDrop(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		(new Actions(driver)).dragAndDrop(sourceElement, destinationElement).perform();

		SeleniumHelper.waitFor(6000);

	}

	public static WebElement presenceOfElementLocated(WebDriver driver, By selector) {
		WebElement myDynamicElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return myDynamicElement;
	}

	public static void clickByLocator(WebDriver driver, final By locator) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		myDynamicElement.click();
	}

	public static void sendByLocator(WebDriver driver, final By locator, String str) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		myDynamicElement.clear();
		myDynamicElement.sendKeys(str);
	}

	public void waitForElementPresent(WebDriver driver, final By by, int timeout) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
				.ignoring(StaleElementReferenceException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				WebElement element = webDriver.findElement(by);
				return element != null && element.isDisplayed();
			}
		});
	}

	public static void clickByLocator1(WebDriver driver, final By locator) {

		final long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(90000, TimeUnit.MILLISECONDS)
				.pollingEvery(5500, TimeUnit.MILLISECONDS);
		// .ignoring( StaleElementReferenceException.class );
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				try {
					webDriver.findElement(locator).click();
					return true;
				} catch (StaleElementReferenceException e) {

					return false;
				}
			}
		});
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

	}

	public static WebElement getElementByLocator(WebDriver driver, final By locator) {

		final long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(90000, TimeUnit.MILLISECONDS)
				.pollingEvery(5500, TimeUnit.MILLISECONDS);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				try {
					webDriver.findElement(locator).getTagName();
					return true;
				} catch (StaleElementReferenceException e) {

					return false;
				}
			}
		});
		WebElement we = null;
		try {
			we = driver.findElement(locator); // is this error prone?
		} catch (StaleElementReferenceException e) {

		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		return we;
	}

	public static WebElement getElementByLocator2(WebDriver driver, By locator) {

		long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		WebElement we = null;
		boolean unfound = true;
		int tries = 0;
		while (unfound && tries < 20) {
			tries += 1;

			try {
				we = driver.findElement(locator);
				unfound = false; // FOUND IT
			} catch (StaleElementReferenceException ser) {

				unfound = true;
			} catch (NoSuchElementException nse) {

				unfound = true;
			} catch (Exception e) {

			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return we;
	}

	public static WebElement getElementByLocator3(WebDriver driver, final By locator) {

		final long startTime = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class);
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		while ((System.currentTimeMillis() - startTime) < 91000) {

			try {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				found = true;
				break;
			} catch (StaleElementReferenceException e) {

			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {

		} else {

		}
		return we;
	}

	public void untilCondition() {
		// wait.until( webDriver -> webDriver.findElement( By.id( "foo" ) ) );

		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout( 30, TimeUnit.SECONDS ) .pollingEvery( 5,
		 * TimeUnit.SECONDS ) .ignoring( NoSuchElementException.class,
		 * StaleElementReferenceException.class ); // using a customized
		 * expected condition WebElement foo1 = wait.until(new
		 * Function<WebDriver, WebElement>() { public WebElement apply(WebDriver
		 * driver) { return driver.findElement(By.id("foo1")); } }); // using a
		 * built-in expected condition WebElement foo2 = wait.until(
		 * ExpectedConditions .presenceOfElementLocated( By.id("foo2") ) ); //
		 * careful with this next one. it requires visibility attribute on html
		 * tag WebElement foo3 = wait.until( ExpectedConditions
		 * .visibilityOfElementLocated( By.id("foo3") ) );
		 */

	}

	public void ExtractJSLogs(WebDriver driver) {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		}
	}

	public static void takeScreenShot(WebDriver driver,String screenshotFile) {
		// fileName of the screenshot
		//Date d = new Date();
		//String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\output\\" + screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catcsh block
			e.printStackTrace();
		}
		// put screenshot file in reports
		//test.log(LogStatus.INFO, "Screenshot-> "
				//+ test.addScreenCapture(System.getProperty("user.dir") + "//screenshots//" + screenshotFile));

	}
}
