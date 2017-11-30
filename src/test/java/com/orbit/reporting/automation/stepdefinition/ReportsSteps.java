package com.orbit.reporting.automation.stepdefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import com.orbit.reporting.automation.action.ReportsActions;
import com.orbit.reporting.automation.page.DomainPage;
import com.orbit.reporting.automation.page.ReportsPage;
import com.orbit.reporting.automation.runner.RunCukesTest;
import com.orbit.reporting.automation.utils.GetNameAsAttr;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ReportsSteps {
	public WebDriver driver;
	public List<HashMap<String, String>> datamap;
	public String url;
	private ReportsPage page;
	private String filepath;
	private String businessObject;
	private ReportsActions action;
	private HashMap<String, Object> exeMapObj;
	private String domain;
	private String reportName;
	private String reportFldName;

	public ReportsSteps() {
		driver = RunCukesTest.driver;
		// datamap = DataHelper.data();
		url = RunCukesTest.url;
		filepath = RunCukesTest.filepath;
		page = PageFactory.initElements(driver, ReportsPage.class);
		PageFactory.initElements(driver, DomainPage.class);
		try {
			businessObject = GetNameAsAttr.getText("/applicationInfo/InfoBusinessObject/@businessObject", filepath);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		//businessObject="Business1934Object";
		domain = "" + ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
		reportFldName = "Data" + domain + "ReportsFloder";
		reportName = "Data" + domain + "Reports";
		action = new ReportsActions();
		exeMapObj = new HashMap<String, Object>();

		/*
		 * try {
		 * GetNameAsAttr.setXmlValue("/applicationInfo/InfoReports/@reportName",
		 * reportName, filepath); } catch (XPathExpressionException |
		 * ParserConfigurationException | SAXException | IOException |
		 * TransformerException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	@And("^I clicked on New Report Button and choose the \"([^\"]*)\" from Menu List$")
	public void i_clicked_on_New_Report_Button_and_choose_the_from_Menu_List(String arg1) throws Throwable {

		String reportName = "Data Report";

		exeMapObj.put("ReportName", reportName);

		try {
			action.createReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@And("^I open Business Object Window enter the Object name in textfield$")
	public void i_open_Business_Object_Window_enter_the_Object_name_in_textfield() throws Throwable {

		exeMapObj.put("BusinessObject", businessObject);
		try {
			action.openBusinessObjectWindow(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@And("^I drag and drop attributes and ran the report$")
	public void i_drag_and_drop_attributes_and_ran_the_report() throws Throwable {
		exeMapObj.put("BusinessObject", businessObject);
		String[] draggables = { "DNAME" };
		exeMapObj.put("Draggables", draggables);
		try {
			action.runReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@And("^I Save report in folder$")
	public void i_Save_report_in_folder() throws Throwable {
		exeMapObj.put("ReportFolderName", reportFldName);
		exeMapObj.put("ReportName", reportName);
		try {
			action.saveReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@Then("I choose edit option from menu list and Run and Save report$")
	public void i_choose_edit_option_from_menu_list_and_Run_report() throws Throwable {
		reportName="Auto117";
		exeMapObj.put("ReportFolderName", reportFldName);
		exeMapObj.put("ReportName", reportName);
		try {
			action.EditReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@And("^I export the report in excel format$")
	public void i_export_the_report_in_excel_format() throws Throwable {
		/*
		 * try { reportName =
		 * GetNameAsAttr.getText("/applicationInfo/InfoReports/@reportName",
		 * filepath); } catch (XPathExpressionException |
		 * ParserConfigurationException | SAXException | IOException e) {
		 * e.printStackTrace(); }
		 */
		
		exeMapObj.put("ReportFolderName", reportFldName);
		exeMapObj.put("ReportName", reportName);
		try {
			action.exportReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@And("^I choose Generate Link option from menu list$")
	public void i_choose_Generate_Link_option_from_menu_list() throws Throwable {
		/*
		 * try { reportName =
		 * GetNameAsAttr.getText("/applicationInfo/InfoReports/@reportName",
		 * filepath); } catch (XPathExpressionException |
		 * ParserConfigurationException | SAXException | IOException e) {
		 * e.printStackTrace(); }
		 */
		reportName="Auto117";
		exeMapObj.put("ReportFolderName", reportFldName);
		exeMapObj.put("ReportName", reportName);
		try {
			action.generateReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();

	}

	@And("^I Generate report links$")
	public void i_Generate_report_link() throws Throwable {
		String[] args = { "Private", "Public" };
		exeMapObj.put("GenerateLinkType", args);
		exeMapObj.put("XmlFilePath", filepath);

		try {
			action.getReportLink(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

	@And("^I navigated to \"([^\"]*)\" link and Run report$")
	public void i_navigated_to_link_and_Run_report(String arg1) throws Throwable {

		exeMapObj.put("LinkType", arg1);
		exeMapObj.put("XmlFilePath", filepath);

		try {
			action.navigateAndRunReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();

	}

	@And("^I Run the report$")
	public void i_Run_the_report() throws Throwable {

		try {
			action.runGeneateReport(driver, exeMapObj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		exeMapObj.clear();
	}

}