package com.orbit.reporting.automation.stepdefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import com.orbit.reporting.automation.action.DomainActions;
import com.orbit.reporting.automation.page.Constants;
import com.orbit.reporting.automation.page.DomainPage;
import com.orbit.reporting.automation.page.LoginPage;
import com.orbit.reporting.automation.runner.RunCukesTest;
import com.orbit.reporting.automation.utils.GetNameAsAttr;

import cucumber.api.java.en.And;

public class DomainSteps {
	public WebDriver driver;
	public List<HashMap<String, String>> datamap;
	public String url;
	private DomainPage page;
	private String filepath;
	private String domain;
	private DomainActions action;
	private String physicalModel;
	private String logicalModel;
	private HashMap<String, Object> exeMapObj;
	private String businessObject;
	private String Category;
	
	public DomainSteps() {
		driver = RunCukesTest.driver;
		//datamap = DataHelper.data();
		url = RunCukesTest.url;
		filepath = RunCukesTest.filepath;
		page = PageFactory.initElements(driver, DomainPage.class);
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, LoginPage.HeaderPage.class);

		domain = "" + ThreadLocalRandom.current().nextInt(1000, 5000 + 1);

		physicalModel = "Physical" + domain + "Model";
		logicalModel = "logical" + domain + "Model";		
		businessObject = "Business" + domain + "Object";
		Category="New" + domain + "Category";
		
		try {
			GetNameAsAttr.setXmlValue("/applicationInfo/InfoBusinessObject/@businessObject", businessObject, filepath);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException
				| TransformerException e) {
			
			e.printStackTrace();
		}
		action = new DomainActions();
	    exeMapObj=new HashMap<String, Object>();
	}

	@And("^I created New Domain name$")
	public void i_created_New_Domain_name() throws Throwable {
		String[] args = { "Automation" + domain + "Domain", "Automation" + domain + "Domain" };
		action.createdDomain(driver, args);
	}

	@And("^I created New Physical model with \"([^\"]*)\" data source name$")
	public void i_created_New_Physical_model_with_data_source_name(String arg1) throws Throwable {
		Object[] args = { physicalModel, arg1 };
		action.createdPhysicalModel(driver, args);
	}

	@And("^I Selected Objects \"([^\"]*)\" and \"([^\"]*)\" from relational database \"([^\"]*)\" to be included in the physical model$")
	public void i_Selected_Objects_and_from_relational_database_to_be_included_in_the_physical_model(String arg1,
			String arg2, String arg3) throws Throwable {
		String physicalModel_xpath = Constants.treecolumn.replace("$$$", physicalModel);
		String[] args = { physicalModel_xpath, arg1, arg2, arg3 };
		action.importObjectsPhysical_model(driver, args);
	}

	@And("^I created new Logical Model$")	
	public void i_created_new_Logical_Model() throws Throwable {
		
		String[] args = { logicalModel };
		action.createLogicalModel(driver, args);
		
	}

	@And("^I give relationship between \"([^\"]*)\" and \"([^\"]*)\" tables$")
	public void i_give_relationship_between_and_tables(String arg1, String arg2) throws Throwable {
		//String expander_xpath = Constants.expander.replace("$$$", physicalModel);
		String customLogicalModel=Constants.treecolumn.replace("$$$", logicalModel);
		String[] args = { arg1, arg2, "",customLogicalModel,"Open" };
		action.relationshipTables(driver, args);
	}
	@And("^I created new Business Object$")
	public void i_created_new_Business_Object() throws Throwable {
		//String expander_xpath = Constants.expander.replace("$$$", logicalModel);
		String businessObj=Constants.treecolumn.replace("$$$", logicalModel);
		
		
		
		exeMapObj.put("logicalModel_expander", "");
		exeMapObj.put("businessObj", businessObj);
		exeMapObj.put("businessObject", businessObject);
		
		action.createBusinessObject(driver, exeMapObj);
		exeMapObj.clear();
	}
	
	@And("^I built the business object layer$")
	public void i_built_the_business_layer() throws Throwable {
		//String expander_xpath = Constants.expander.replace("$$$", "Business Objects");
		String str="//div[@class=' x-tree-icon x-tree-icon-custom x-tree-icon-parent-expanded x-fa fa-cube']/following-sibling::span[contains(text(),'$$$')]";
		String customBusineesObject=str.replace("$$$", businessObject);
		exeMapObj.put("expander", "");
		exeMapObj.put("CustomBusineesObject", customBusineesObject);
		exeMapObj.put("MenuItem", "Open");
		exeMapObj.put("CategoryName", Category);
		
		try {
			action.buildingBusineeObject_ChooseOpenOption(driver, exeMapObj);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		exeMapObj.clear();
		
	}
	@And("^I built New Category and moved data columns for chosen business objects$")
	public void i_built_New_Category_and_moved_data_columns_for_chosen_business_objects() throws Throwable {
	   
		String expander_xpath1 = Constants.expander.replace("$$$", "EMP");
		String expander_xpath2 = Constants.expander.replace("$$$", "DEPT");
		String customBusineesObject=Constants.treecolumn.replace("$$$", businessObject);
		String[] draggables={"DNAME"};
		
		exeMapObj.put("expander1", expander_xpath1);
		exeMapObj.put("expander2", expander_xpath2);
		exeMapObj.put("CustomBusineesObject", customBusineesObject);
		exeMapObj.put("MenuItem", "New Category");
		exeMapObj.put("CategoryName", Category);
		exeMapObj.put("Draggables", draggables);
		exeMapObj.put("Role", "ADMIN");
		
		
		try {
			action.buildingBusineeObject_moveColumsToCategory(driver, exeMapObj);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		exeMapObj.clear();
	}


}
