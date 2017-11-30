package com.orbit.reporting.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DomainPage extends BaseClass {
	public DomainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.NAME, using = "name")
	public static WebElement name;
	
	@FindBy(how = How.NAME, using = "description")
	public static WebElement description;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid-cell-inner x-grid-cell-inner-treecolumn']/span[contains(text(),'Physical Models')]")
	public static WebElement physicalModels;
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default')]")
	public static WebElement arrow;
	
	
	
	@FindBy(how = How.XPATH, using = "//ul[@class='x-list-plain']/li")
	public static WebElement datasource;
	
	
	public static By datasource_options=By.xpath("//ul[@class='x-list-plain']/li");
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid-cell-inner x-grid-cell-inner-treecolumn']/span[contains(text(),'Logical Models')]")
	public static WebElement logicalModels;
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-container x-border-item x-box-item x-container-default' and starts-with(@id,'lm')]")
	public static WebElement canvas;
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid-cell-inner x-grid-cell-inner-treecolumn']/span[contains(text(),'Business Objects')]")
	public static WebElement businessObjects;
	
	
	@FindBy(how = How.XPATH, using = "//a[@data-qtip='Save Domain']")
	public static WebElement saveDomain;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'USER')]")
	public static WebElement assignRole0;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ADMIN')]")
	public static WebElement assignRole1;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ANALYST')]")
	public static WebElement assignRole2;
	
}
