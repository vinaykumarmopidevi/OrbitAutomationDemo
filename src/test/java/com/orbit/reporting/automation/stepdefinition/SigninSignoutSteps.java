package com.orbit.reporting.automation.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orbit.reporting.automation.action.SignInAction;
import com.orbit.reporting.automation.action.SignoutAction;
import com.orbit.reporting.automation.page.LoginPage;
import com.orbit.reporting.automation.runner.RunCukesTest;
import com.orbit.reporting.automation.utils.GetNameAsAttr;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SigninSignoutSteps {
	public WebDriver driver;
	// public List<HashMap<String,String>> datamap;
	public String url;
	private String filepath;
	private String username;
	private String password;

	public SigninSignoutSteps() {
		driver = RunCukesTest.driver;
		url = RunCukesTest.url;
		filepath = RunCukesTest.filepath;
	}

	@Given("^I open orbit application website$")
	public void i_open_orbit_application_website() throws Throwable {
		driver.get(url);
	}

	@When("^I sign in username \"([^\"]*)\" and password \"([^\"]*)\" default credentials$")
	public void i_sign_in_username_and_password_default_credentials(String arg1, String arg2) throws Throwable {

		String[] datamap = { arg1, arg2 };
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, LoginPage.HeaderPage.class);

		SignInAction.Execute(driver, datamap);
	}

	@When("^I login to application username \"([^\"]*)\" and password \"([^\"]*)\" no validation$")
	public void i_login_to_application_username_and_password_no_validation(String arg1, String arg2) throws Throwable {
		String[] datamap = { arg1, arg2 };
		PageFactory.initElements(driver, LoginPage.class);
		SignInAction.Execute_NoValidation(driver, datamap);
	}

	@Then("^I sign out$")
	public void i_sign_out() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String[] args = {};
		SignoutAction.Execute(driver, args);
	}

	@And("^I login with newly created credentials$")
	public void i_login_with_newly_created_credentials() throws Throwable {
		
		try {
			username=GetNameAsAttr.getText("/applicationInfo/InfoUser/@username", filepath);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		password="Orbit123";
		
		String[] datamap = { username, password };
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, LoginPage.HeaderPage.class);

		try {
			SignInAction.Execute(driver, datamap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}