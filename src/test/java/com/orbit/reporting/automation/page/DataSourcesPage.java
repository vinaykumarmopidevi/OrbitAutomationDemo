package com.orbit.reporting.automation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DataSourcesPage {

	@FindBy(how = How.NAME, using = "localName")
	public static WebElement ds_Name;

	@FindBy(how = How.NAME, using = "localDesc")
	public static WebElement ds_desc;

	@FindBy(how = How.NAME, using = "username")
	public static WebElement db_user;
	
	
	@FindBy(how = How.NAME, using = "password")
	public static WebElement db_pwd;	
	

	@FindBy(how = How.NAME, using = "hostname")
	public static WebElement db_hostname;
	
	@FindBy(how = How.NAME, using = "port")
	public static WebElement db_port;
	
	@FindBy(how = How.NAME, using = "databaseName")
	public static WebElement db_databaseName;
	
	
	
}
