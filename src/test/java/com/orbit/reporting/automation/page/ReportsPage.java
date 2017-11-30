package com.orbit.reporting.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class ReportsPage extends BaseClass {
	public ReportsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'x-component visualizations x-fit-item x-component-default x-scroller')]/div[contains(@class,'visualization')]/img[contains(@src,'icon-grid')]")
	public static WebElement visualDataReport;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid-cell-inner'][1]")
	public static WebElement choose_BusinessObject;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-component x-box-item x-component-default']/preceding-sibling::div")
	public static WebElement dragDropFields;
	


	@FindBy(how = How.XPATH, using = "//*[@class='x-btn report-run-button x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small'][2]")
	public static WebElement runReport;
	
	/*@FindBy(how = How.XPATH, using = "//div[@class='x-grid-cell-inner x-grid-cell-inner-treecolumn']/span[contains(text(),'Folders')]")
	public static WebElement saveReport1;*/
	
	
	
	@FindBy(how = How.XPATH, using = "//a[@data-qtip='Save Report']")
	public static WebElement saveReport;
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'x-menu-item x-menu-item-default x-box-item')]/a[contains(@class,'x-menu-item-link')]/span[contains(@class,'x-menu-item-text x-menu-item-text-default x-menu-item-indent-no-separator x-menu-item-indent-right-arrow') and contains(text(),'Export') ]")
	public static WebElement exportReport;
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-menu-item x-menu-item-default x-box-item']/a[@class='x-menu-item-link']/span[@class='x-menu-item-text x-menu-item-text-default x-menu-item-indent-no-separator' and contains(text(),'Excel xlsx')]")
	public static WebElement exportExcelReport;
	
	
	@FindBy(how = How.XPATH, using = "(//input[starts-with(@class,'x-form-field x-form-required-field x-form-text x-form-text-default')])[2]")
	public static WebElement nameFld;
	@FindBy(how = How.XPATH, using = "(//textarea[contains(@class,'x-form-textarea')])[3]")
	public static WebElement descFld;
}


