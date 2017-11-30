package com.orbit.reporting.automation.action;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.orbit.reporting.automation.logger.Log;
import com.orbit.reporting.automation.page.AutomationHomePage;
import com.orbit.reporting.automation.utils.SeleniumHelper;
public class SignoutAction {
	public static void Execute(WebDriver driver,String[] args) throws Exception{
		SeleniumHelper.waitforelementToBeClickable(driver,AutomationHomePage.user_image());
		AutomationHomePage.user_image().click();
		SeleniumHelper.waitforelementToBeClickable(driver,AutomationHomePage.logout_user());
		AutomationHomePage.logout_user().click();
		Log.info("Sign out is performed");
		Reporter.log("Sign out is performed");
	}
}
