package com.orbit.reporting.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class UserMgmtPage extends BaseClass {
	public UserMgmtPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.NAME, using = "login")
	public WebElement login;
	
	

	@FindBy(how = How.NAME, using = "firstName")
	public WebElement firstName;

	@FindBy(how = How.NAME, using = "lastName")
	public WebElement lastName;

	@FindBy(how = How.NAME, using = "email")
	public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//*[text()='User created successfully']")
	public WebElement created_successfully;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'USER')]")
	public WebElement assignRole0;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ADMIN')]")
	public WebElement assignRole1;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ANALYST')]")
	public WebElement assignRole2;
	
	
	@FindBy(how = How.XPATH, using = "//div[@data-qtip='Deactivated']")
	public WebElement lockIcon;
	
	@FindBy(how = How.LINK_TEXT, using = "Change Password")
	public WebElement changePwd;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Search')]")
	public WebElement searchPlaceholder;
	

}
