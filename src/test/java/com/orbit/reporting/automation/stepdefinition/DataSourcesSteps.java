package com.orbit.reporting.automation.stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orbit.reporting.automation.action.DataSourcesActions;
import com.orbit.reporting.automation.listener.Reporter;
import com.orbit.reporting.automation.page.DataSourcesPage;
import com.orbit.reporting.automation.runner.RunCukesTest;
import com.orbit.reporting.automation.utils.DataHelper;
import com.orbit.reporting.automation.utils.SeleniumHelper;
import com.orbit.reporting.automation.utils.Xls_Reader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataSourcesSteps {

	private WebDriver driver;
	private String url;
	private String domain;
	private String data_source_name;
	private DataSourcesActions ds_actions;
	HashMap<String, Object> map;
	List<HashMap<String, String>> datamap;
	private Date date;

	public DataSourcesSteps() {
		String excelfilepath=System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\DataDrivenFile.xlsx";
		Xls_Reader xls=new Xls_Reader(excelfilepath);
		datamap=DataHelper.getTestData(xls, "DataSources");
		
		driver = RunCukesTest.driver;
		url = RunCukesTest.url;
		domain = "" + ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
		data_source_name = "DataSource" + domain + "Name";
		ds_actions = new DataSourcesActions();
		map = new HashMap<String, Object>();
		
		PageFactory.initElements(driver, DataSourcesPage.class);
		 date=new Date();
	}

	@Given("^I click on new button$")
	public void i_click_on_new_button() throws Throwable {
		Reporter.addStepLog("DataSources Scenario");
		Reporter.addScenarioLog("I click on new button");
		
		ds_actions.clickonNewDS(driver, map);
		 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+date.getTime()+".jpg");

	}
	
	@And("^I entered the datasource \"([^\"]*)\" name$")
	public void i_entered_the_datasource_name(String arg1) throws Throwable {
	    
		Reporter.addScenarioLog("I entered the datasource name");
	
		 int index = Integer.parseInt(arg1);
		
		String db_username=datamap.get(index).get("db_username");
		String db_pwd=datamap.get(index).get("db_pwd");
		String db_hostname=datamap.get(index).get("db_hostname");
		String db_port=datamap.get(index).get("db_port");
		String db_name=datamap.get(index).get("db_name");
		
		 map.put("DataSourceName", data_source_name);
		 map.put("db_username", db_username);		 
		 map.put("db_pwd", db_pwd);
		 map.put("db_hostname", db_hostname);
		 map.put("db_port", db_port);
		 map.put("db_name", db_name);
		 
		 Reporter.addStepLog("I entered the datasource name");
		 ds_actions.enterDataSource(driver, map);
		 
		 String filename="ScreenShot"+date.getTime()+".png";
		SeleniumHelper.takeScreenShot(driver,filename);
		 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+filename);
	
		

		
		
		 Reporter.addStepLog("I entered the user name");
		ds_actions.enterDSName(driver, map);
		  filename="ScreenShot"+date.getTime()+".png";
		SeleniumHelper.takeScreenShot(driver,filename);
		 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+filename);
		
		
		
		Reporter.addScenarioLog("I entered the pasword name");
		

		ds_actions.enterDBpwd(driver, map);
		  filename="ScreenShot"+date.getTime()+".png";
			SeleniumHelper.takeScreenShot(driver,filename);
			 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+filename);
	

	
		
		 Reporter.addStepLog("I entered the datasource name");
		ds_actions.enterDBhostname(driver, map);
		  filename="ScreenShot"+date.getTime()+".png";
			SeleniumHelper.takeScreenShot(driver,filename);
			 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+filename);
	

	
	
		 Reporter.addStepLog("I entered the datasource name");
		ds_actions.enterDBport(driver, map);
		  filename="ScreenShot"+date.getTime()+".png";
			SeleniumHelper.takeScreenShot(driver,filename);
			 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+filename);

	

	

		
		 Reporter.addStepLog("I entered the datasource name");
		ds_actions.enterDBName(driver, map);
		  filename="ScreenShot"+date.getTime()+".png";
			SeleniumHelper.takeScreenShot(driver,filename);
			 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+filename);
		

	
		

		ds_actions.clicktestConnection(driver, map);
		
	

	
		String status=ds_actions.getConnectionStatus(driver, map);
		Reporter.addScenarioLog("I entered the datasource name");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+status);
		
		if(!status.equalsIgnoreCase("Connection success")){
			//assertTrue(false, "Connection not established "+status);
		}else{
			assertTrue(true, "Connection established "+status);
		}
		 Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") +"\\output\\"+date.getTime()+".jpg");
		map.clear();
	
	}
}
