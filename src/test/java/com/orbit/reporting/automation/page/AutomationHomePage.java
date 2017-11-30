package com.orbit.reporting.automation.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AutomationHomePage extends BaseClass{

	public AutomationHomePage(WebDriver driver){
		super(driver);
	}   
	
	public static WebElement user_image() {

		String queryString = "return Ext.ComponentQuery.query(\"image[referenceKey='profilepic']\")[0].id";
		String resultString = (String) ((JavascriptExecutor) driver).executeScript(queryString);

		WebElement element = driver.findElement(By.id(resultString));

		return element;
	}
	
	public static WebElement logout_user() {

		String queryString = "return Ext.ComponentQuery.query(\"button[text='Sign Out']\")[0].id";
		String resultString = (String) ((JavascriptExecutor) driver).executeScript(queryString);

		WebElement element = driver.findElement(By.id(resultString));

		return element;
	}
	
	public static WebElement change_password() {

		String queryString = "return Ext.ComponentQuery.query(\"label[text='Change Password']\")[0].id";
		String resultString = (String) ((JavascriptExecutor) driver).executeScript(queryString);

		WebElement element = driver.findElement(By.id(resultString));

		return element;
	}
		
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	