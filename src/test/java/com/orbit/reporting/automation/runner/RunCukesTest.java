package com.orbit.reporting.automation.runner;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.xml.sax.SAXException;

import com.orbit.reporting.automation.listener.ExtentProperties;
import com.orbit.reporting.automation.listener.Reporter;
import com.orbit.reporting.automation.utils.GetNameAsAttr;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"classpath:features"},
        glue = {"com.orbit.reporting.automation.stepdefinition"},
        plugin = {"com.orbit.reporting.automation.listener.ExtentCucumberFormatter:"}
)
public class RunCukesTest extends AbstractTestNGCucumberTests {
	
	public static WebDriver driver;
	public static String filepath;
	public static String browserType;
	public static String url;

	
	
    @BeforeSuite
    public  static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//        extentProperties.setExtentXServerUrl("http://localhost:1337");
//        extentProperties.setProjectName("TestNGProject");
        //"src/test/resources/features/Domain.feature","src/test/resources/features/02Domain.feature"
      
        		//features = {"classpath:features"},
        extentProperties.setReportPath("output/myreport.html");
    }

    @AfterSuite
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        
    	//driver.quit();
    }
    



  
	@BeforeTest
	/**
	 * Delete all cookies at the start of each scenario to avoid shared state
	 * between tests
	 */
	public void openBrowser() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		

		filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\applicationInfo.xml";
		browserType = GetNameAsAttr.getText("/applicationInfo/Info/@browserName", filepath);
		url = GetNameAsAttr.getText("/applicationInfo/Info/@appURL", filepath);

		switch (browserType) {
		case "Mozilla":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\binaries\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\binaries\\chromedriver.exe");
			// driver = new ChromeDriver();

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			LoggingPreferences loggingprefs = new LoggingPreferences();
			loggingprefs.enable(LogType.BROWSER, Level.ALL);
			capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
			driver = new ChromeDriver(capabilities);
			break;
		case "ie":
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			File file = new File(System.getProperty("user.dir") + "\\binaries\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
			break;
		default:
			System.out.println("No Driver Found");
			System.exit(0);
		}

		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		

	}

	@AfterTest
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot() {
		
		driver.quit();
	

	}


}
