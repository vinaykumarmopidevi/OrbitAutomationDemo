package com.orbit.reporting.automation.action;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orbit.reporting.automation.logger.Log;
import com.orbit.reporting.automation.page.Constants;
import com.orbit.reporting.automation.page.DataSourcesPage;
import com.orbit.reporting.automation.utils.TestBase;

public class DataSourcesActions extends TestBase{

	private WebElement element;

	public void clickonNewDS(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, Constants.datasource);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
		
		
	}

	public void enterDataSource(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		String ds_username=(String)map.get("DataSourceName");
		/*
		 * enter ds name in text field
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DataSourcesPage.ds_Name));
		} catch (Exception e1) {

			e1.printStackTrace();
		}		

		
		try {
			Thread.sleep(2000);
			element.clear();
			
			element.sendKeys(ds_username);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	public void enterDSName(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String db_username=(String)map.get("db_username");
		/*
		 * enter ds name in text field
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DataSourcesPage.db_user));
		} catch (Exception e1) {

			e1.printStackTrace();
		}		

		
		try {
			Thread.sleep(2000);
			element.clear();
			element.sendKeys(db_username);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	public void enterDBpwd(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String db_pwd=(String)map.get("db_pwd");
		/*
		 * enter ds name in text field
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DataSourcesPage.db_pwd));
		} catch (Exception e1) {

			e1.printStackTrace();
		}		

		
		try {
			Thread.sleep(2000);
			element.clear();
			element.sendKeys(db_pwd);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	public void enterDBhostname(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String db_hostname=(String)map.get("db_hostname");
		/*
		 * enter ds name in text field
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DataSourcesPage.db_hostname));
		} catch (Exception e1) {

			e1.printStackTrace();
		}		

		
		try {
			Thread.sleep(2000);
			element.clear();
			element.sendKeys(db_hostname);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	public void enterDBport(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String db_port=(String)map.get("db_port");
		/*
		 * enter ds name in text field
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DataSourcesPage.db_port));
		} catch (Exception e1) {

			e1.printStackTrace();
		}		

		
		try {
			Thread.sleep(2000);
			element.clear();
			element.sendKeys(db_port);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	public void enterDBName(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String db_name=(String)map.get("db_name");
		/*
		 * enter ds name in text field
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DataSourcesPage.db_databaseName));
		} catch (Exception e1) {

			e1.printStackTrace();
		}		

		
		try {
			Thread.sleep(2000);
			element.clear();
			element.sendKeys(db_name);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	public void clicktestConnection(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, Constants.testConn);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
		
		
	
		
		
	}

	public String getConnectionStatus(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		/*
		 * click on create new domain button
		 */
		String status=null;
		try {
			element = extJSElementHandler(driver, Constants.datasource_conn_status);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			String element_id=element.getAttribute("id");
			 status =(String) ((JavascriptExecutor) driver).executeScript(Constants.getElementText.replace("$$$", element_id));
			
			
			 System.out.println(status);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return status;
		
		
		
	
		
		
	}

	public void clickonCancelDS(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, Constants.cancel_datasource);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
		
		
	}

	

	
	

}
