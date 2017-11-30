package com.orbit.reporting.automation.action;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.orbit.reporting.automation.logger.Log;
import com.orbit.reporting.automation.page.LoginPage;
import com.orbit.reporting.automation.utils.PageHelpers;
public class SignInAction {
	public static void Execute(WebDriver driver,String[] arg) throws Exception{
	//	AutomationHomePage.sign_in.click();
		Log.info("Click action is perfromed on My Account link" );
		LoginPage.usrname.sendKeys(arg[0]);
		Log.info(" is entered in UserName text box" );
		LoginPage.password.sendKeys(arg[1]);
		Log.info(" is entered in Password text box" );
		LoginPage.signin_button.click();
		Log.info("Click action is performed on Submit button");
		PageHelpers.waitForVisibility(driver,LoginPage.HeaderPage.headerValue);
		if(LoginPage.HeaderPage.headerValue.isDisplayed()){
			System.out.println("Value displayed");
		}else{
			System.out.println("Value not displayed");
		}
		Reporter.log("SignIn Action is successfully perfomred");
	}
	
	public static void Execute_NoValidation(WebDriver driver,String[] arg) throws Exception{
		//	AutomationHomePage.sign_in.click();
			Log.info("Click action is perfromed on My Account link" );
			LoginPage.usrname.sendKeys(arg[0]);
			Log.info(" is entered in UserName text box" );
			LoginPage.password.sendKeys(arg[1]);
			Log.info(" is entered in Password text box" );
			LoginPage.signin_button.click();
			Log.info("Click action is performed on Submit button");
			
			Reporter.log("SignIn Action is successfully perfomred");
		}
}
