package com.orbit.reporting.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		// PageFactory.initElements(webDriver, this);
	}

	@FindBy(how = How.ID, using = "usrname")
	@CacheLookup
	public static WebElement usrname;

	public static By usrname_by=By.id("usrname");
	
	@FindBy(how = How.ID, using = "pwd")
	@CacheLookup
	public static WebElement password;
	
	public static By password_by=By.id("pwd");
	

	@FindBy(how = How.CSS, using = "#submit")
	@CacheLookup
	public static WebElement signin_button;

	public static By signin_button_by=By.cssSelector("#submit");
	
	public static class HeaderPage {

		@FindBy(how = How.CSS, using = "div[class~='top-user-name']")
		@CacheLookup
		public static WebElement headerValue;
	}

	

}
