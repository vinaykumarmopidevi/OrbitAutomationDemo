package com.orbit.reporting.automation.stepdefinition;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orbit.reporting.automation.action.SignInAction;
import com.orbit.reporting.automation.logger.Log;
import com.orbit.reporting.automation.page.AutomationHomePage;
import com.orbit.reporting.automation.page.Constants;
import com.orbit.reporting.automation.page.LoginPage;
import com.orbit.reporting.automation.page.UserMgmtPage;
import com.orbit.reporting.automation.runner.RunCukesTest;
import com.orbit.reporting.automation.utils.GetNameAsAttr;
import com.orbit.reporting.automation.utils.PageHelpers;
import com.orbit.reporting.automation.utils.ReadMailSample;
import com.orbit.reporting.automation.utils.SeleniumHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UserMgmtSteps {
	public WebDriver driver;
	public List<HashMap<String, String>> datamap;
	public String url;
	private UserMgmtPage page;
	private String filepath;
	private String newUsername;
	private String systemGenPwd;
	private String newPassword;
	private String activationKey;
	private boolean flag;
	WebElement element = null;
	WebDriverWait wait=null;
	private Actions actions;
	public UserMgmtSteps() {
		driver = RunCukesTest.driver;
		//datamap = DataHelper.data();
		url = RunCukesTest.url;
		filepath=RunCukesTest.filepath;
		page = PageFactory.initElements(driver, UserMgmtPage.class);
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, LoginPage.HeaderPage.class);
		
		newUsername="autouser" + ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
		Log.info(newUsername);
		systemGenPwd="";
		activationKey="";
		newPassword="Orbit123";
		
		 wait = new WebDriverWait(driver, 30);
		  actions = new Actions(driver);
	}

	@Then("^I navigate to \"([^\"]*)\" page$")
	public void i_navigate_to_Users_page(String sub) throws Throwable {
		Thread.sleep(5000);
		driver.get(url + "home#" + sub);

	}

	@And("^I click on new user button$")
	public void i_click_on_new_user_button() throws Throwable {
	
		
		By createBtn = null;
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,Constants.newUserBtn));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			element.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@And("^I enter \"([^\"]*)\" user name$")
	public void i_enter_user_name(String username) throws Throwable {
		if ("NewUser".equalsIgnoreCase(username)) {
			
			try {
				Thread.sleep(2000);
				element = wait.until(ExpectedConditions.visibilityOf(page.login));
			} catch (Exception e) {
			
				e.printStackTrace();
			}

			try {
				element.clear();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			try {
				element.sendKeys(newUsername);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			
		}

		

	}

	@And("^I enter first name$")
	public void i_enter_first_name() throws Throwable {
	
		
		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.visibilityOf(page.firstName));
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		try {
			element.clear();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		try {
			element.sendKeys("Auto");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}

	@And("^I enter last name$")
	public void i_enter_last_name() throws Throwable {
		
		
		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.visibilityOf(page.lastName));
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		try {
			element.clear();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		try {
			element.sendKeys("User");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	@And("^I enter email \"([^\"]*)\" address$")
	public void i_enter_email_address(String arg1) throws Throwable {
	
		
		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.visibilityOf(page.email));
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		try {
			element.clear();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		try {
			element.sendKeys(arg1);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	@And("^I click on save \"([^\"]*)\" button$")
	public void i_click_on_save_button(String arg) throws Throwable {
		
		
		By createBtn = null;
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,Constants.saveBtn));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			element.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}

	/*@And("^I click on saveAll \"([^\"]*)\" button$")
	public void i_click_on_saveAll_button(String arg) throws Throwable {
		Actions actions=new Actions(driver);
		WebDriverWait wait =new WebDriverWait (driver,10);
		
		By saveBtn = By.id(PageHelpers.javascriptExecutor(driver,
				"return Ext.ComponentQuery.query(\"button[handler='"+arg+"']\")[0].id"));
		
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
		
		actions.moveToElement(element).click().build().perform();
	}*/


	
	
	/*@And("^I verified \"([^\"]*)\" response$")
	public void i_verified_URL_response(String arg) throws Throwable {

		String response = UrlGetResponse.getURLResponce(url + arg);
		System.out.println(response);
	}
*/
	@And("^I click on search icon$")
	public void i_click_on_search_icon() throws Throwable {
		
		By createBtn = null;
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,	Constants.searchIcon));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			element.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@And("^I search \"([^\"]*)\" user name$")
	public void i_search_user_name(String arg1) throws Throwable {
		

	

		
		By createBtn = null;
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,	Constants.textfield_login));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		try {
			actions.moveToElement(element);
			actions.click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			
			actions.sendKeys(newUsername);
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}

	@And("^I moved to lock icon and double click on icon$")
	public void i_moved_to_lock_icon_and_double_click_on_icon() throws Throwable {
		/*try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),'Assigned Roles')]")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}*/
		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.visibilityOf(page.lockIcon));
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		
		try {
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^I click on Yes button on Status Change popup$")
	public void i_click_on_Yes_on_Status_Change_popup() throws Throwable {
		
		
		By createBtn = null;
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,	Constants.yes_btn));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			
			element.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	@And("^I assigned \"([^\"]*)\" role to new user$")
	public void i_assigned_and_role_to_new_user(String arg1) throws Throwable {
		
		By createBtn = null;
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,	Constants.btn_onShowSearch));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			
			//element.click();
			actions.moveToElement(element).click().build().perform();
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
			//grid[reference="searchGrid"]
			element = wait.until(ExpectedConditions.visibilityOf(page.searchPlaceholder));
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		
		try {
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(Keys.chord(Keys.CONTROL, "a"),newUsername );
			actions.build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			Thread.sleep(2000);
			//createBtn = By.xpath("//div[contains(text(),'"+newUsername+"')]");
			createBtn = By.xpath("//div[@class='x-grid-cell-inner x-grid-checkcolumn-cell-inner']/span[@class='x-grid-checkcolumn']");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
			actions.moveToElement(element).click().build().perform();
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		try {
			Thread.sleep(2000);
			createBtn = By.id(PageHelpers.javascriptExecutor(driver,	Constants.btn_saveChanges));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			
			element.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	@And("^I Activated new user and captured system generated password using email \"([^\"]*)\" and password \"([^\"]*)\" configaration$")
	public void i_Activated_new_user_and_captured_system_generated_password_using_email_and_password_configaration(String arg1, String arg2) throws Throwable {

		ReadMailSample readMail=new ReadMailSample();
		flag =false;
				
		while(!flag ){
			 activationKey=readMail.getUserActivation(arg1,arg2);
			 if(activationKey.isEmpty()){
				 Thread.sleep(1000);
			 }else{
				 flag=true;
			 }
		
		
		 
		 
		
		try {
			driver.navigate().to(url+"registrationConfirm?activationKey="+activationKey);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		
		
		flag =false;
		while(!flag ){
			systemGenPwd=readMail.getLoginCredentials_Passwrod(arg1,arg2);
			 if(activationKey.isEmpty()){
				 Thread.sleep(1000);
			 }else{
				 flag=true;
			 }
		}
		
		
	
		}
	   
	}

	

	@And("^I sign with custom credentials$")
	public void i_sign_with_custom_credentials() throws Throwable {
		driver.get(url);
		Thread.sleep(2000);
		
		String[] datamap={newUsername,systemGenPwd.trim()};
    	

		SignInAction.Execute(driver,datamap);
		
		
	}

	@And("^I change password$")
	public void i_reset_the_password() throws Throwable {
		
		Thread.sleep(2000);
		SeleniumHelper.waitforelementToBeClickable(driver,AutomationHomePage.user_image());
		AutomationHomePage.user_image().click();
		
		
		
		//String pwd = GetNameAsAttr.getText("/applicationInfo/InfoUser/@password", filepath);
		
		try {
			String str = PageHelpers.javascriptExecutor(driver, "return Ext.ComponentQuery.query(\"label[text='Change Password']\")[0].id");
			WebElement element = driver.findElement(By.id(str));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
		
		String str = PageHelpers.javascriptExecutor(driver, "return Ext.ComponentQuery.query(\"textfield[reference='oldPassword']\")[0].id");
		WebElement element = driver.findElement(By.id(str));
		// element.clear();
		// element.sendKeys(systemGenPwd);
		 
		
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(systemGenPwd);
			actions.build().perform();
			
		
		 str = PageHelpers.javascriptExecutor(driver, "return Ext.ComponentQuery.query(\"textfield[reference='newPassword']\")[0].id");
		 element = driver.findElement(By.id(str));
		// element.clear();
		// element.sendKeys(newPassword);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(newPassword);
			actions.build().perform();
		
		 str = PageHelpers.javascriptExecutor(driver, "return Ext.ComponentQuery.query(\"textfield[reference='confirmNewPassword']\")[0].id");
		 element = driver.findElement(By.id(str));
		// element.clear();
		// element.sendKeys(newPassword);;
		 actions.moveToElement(element);
			actions.click();
			actions.sendKeys(newPassword);
			actions.build().perform();
		
		// GetNameAsAttr.setXmlValue("/applicationInfo/InfoUser/@password", newPassword, filepath);
		 
		 str = PageHelpers.javascriptExecutor(driver, "return Ext.ComponentQuery.query(\"button[handler='onSubmit']\")[0].id");
		 element = driver.findElement(By.id(str));
		 actions.moveToElement(element);
			actions.click();			
			actions.build().perform();
			
			Thread.sleep(2000);
			
			 str = PageHelpers.javascriptExecutor(driver, "return Ext.ComponentQuery.query(\"button[itemId='ok']\")[0].id");
			 element = driver.findElement(By.id(str));
			 actions.moveToElement(element);
				actions.click();			
				actions.build().perform();

	}

	@And("^I sign in with custom credentials$")
	public void i_sign_in_with_custom_credentials() throws Throwable {
		//String user = GetNameAsAttr.getText("/applicationInfo/InfoUser/@username", filepath);
		//String pwd = GetNameAsAttr.getText("/applicationInfo/InfoUser/@password", filepath);
		//String[] datamap={newUsername,newPassword};
    	//PageFactory.initElements(driver, LoginPage.class);
		//PageFactory.initElements(driver, LoginPage.HeaderPage.class);
		/*Thread.sleep(5000);
		
		driver.navigate().to(url);
		
		
		
		 try {
			Actions actions=new Actions(driver);
			 actions.moveToElement(LoginPage.usrname);
				actions.click();	
				actions.sendKeys(newUsername);
				actions.build().perform();
				
				
				 actions.moveToElement(LoginPage.password);
					actions.click();	
					actions.sendKeys(newPassword);
					actions.build().perform();
				
					 actions.moveToElement(LoginPage.signin_button);
						actions.click();						
						actions.build().perform();
		} catch (Exception e) {
			SignInAction.Execute(driver,datamap);
		}*/
					
	
		/*PageHelpers.waitForVisibility(driver,LoginPage.HeaderPage.headerValue);
		if(LoginPage.HeaderPage.headerValue.isDisplayed()){
			System.out.println("Value displayed");
		}else{
			System.out.println("Value not displayed");
		}*/
		
		
		//String[] datamap={newUsername,newPassword};
		Thread.sleep(5000);
		try {
			SeleniumHelper.sendByLocator(driver, LoginPage.usrname_by,newUsername);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			SeleniumHelper.sendByLocator(driver, LoginPage.password_by,newPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			SeleniumHelper.clickByLocator(driver, LoginPage.signin_button_by);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(5000);
		
		try {
			GetNameAsAttr.setXmlValue("/applicationInfo/InfoUser/@username", newUsername, filepath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}