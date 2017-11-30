package com.orbit.reporting.automation.action;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import com.orbit.reporting.automation.logger.Log;
import com.orbit.reporting.automation.page.Constants;
import com.orbit.reporting.automation.page.DomainPage;
import com.orbit.reporting.automation.page.ReportsPage;
import com.orbit.reporting.automation.utils.GetNameAsAttr;
import com.orbit.reporting.automation.utils.PageHelpers;
import com.orbit.reporting.automation.utils.TestBase;

public class ReportsActions extends TestBase implements Constants {

	private WebElement element;

	public void createReport(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, btn_Createeport);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * click on create new Report button
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.visualDataReport));
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			Thread.sleep(3000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, btn_BusinessObject);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	public void openBusinessObjectWindow(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		String boName = (String) exeMapObj.get("BusinessObject");

		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, openBusinessObjectWindow);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * click on create new domain button
		 */
		/*
		 * try { element = extJSElementHandler(driver,
		 * textfield_BusinessObject); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 */
		String id = null;
		try {
			Log.info("Click on Create Domain button ");
			// element = wait.until(ExpectedConditions.visibilityOf(element));
			id = PageHelpers.javascriptExecutor(driver, textfield_BusinessObject);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {

			// actions.moveToElement(element);
			// actions.click();

			/*
			 * try { element.sendKeys(businessObject); } catch (Exception e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); }
			 */

			/*
			 * try { JavascriptExecutor executor = (JavascriptExecutor)driver;
			 * 
			 * executor.executeScript("document.getElementById("+id+").value='"+
			 * businessObject+"';"); } catch (Exception e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

			try {
				Thread.sleep(2000);
				actions.moveToElement(element).sendKeys(boName).build().perform();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * try { element=driver.findElement(By.
		 * xpath("//*[@data-qtip='Refresh' or aria-label='Refresh']")); } catch
		 * (Exception e2) {
		 * 
		 * e2.printStackTrace(); } try { actions.moveToElement(element);
		 * actions.click(); actions.build().perform(); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 */

		try {
			Thread.sleep(3000);
			element = driver.findElement(By.xpath("//div[text()='" + boName.trim() + "']"));
		} catch (Exception e2) {

			e2.printStackTrace();
		}

		try {
			Thread.sleep(3000);
			actions.moveToElement(element);
			actions.doubleClick();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

	public void runReport(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		//String[] draggables = (String[]) exeMapObj.get("Draggables");
		//.String[] draggables={"DNAME"};
		/*
		 * Click on Expand All
		 */
		try {
			Thread.sleep(2000);
			element = extJSElementHandler(driver, onExpandAll);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(3000);
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(3000);
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.dragDropFields));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}

		//for (String drag : draggables) {
			
			//String columns="(//span[contains(text(),'DNAME')])[2]";
		
			/*WebElement drag_element=null;
			try {
				Thread.sleep(2000);
				 drag_element = extJSElementHandler(driver, reports_drag_columns);
			} catch (Exception e1) {

				e1.printStackTrace();
			}*/
			
			
			/*try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			By drag_columns = By.xpath(columns);*/

			WebElement drag_element = null;
			try {
				By loc=By.xpath("//div[contains(@class,'x-tree-icon x-tree-icon-custom x-tree-icon-leaf ORBIT-Icons orb-text data-text-style')]/following-sibling::span[contains(text(),'DNAME')]");
				drag_element = wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			} catch (Exception e2) {

				e2.printStackTrace();
			}
			
			

			try {
				Thread.sleep(3000);
				actions.click(drag_element).build().perform();
				actions.clickAndHold(drag_element).build().perform();
				actions.moveToElement(element).build().perform();
				actions.release(element).build().perform();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

		//}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.runReport));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

	public void saveReport(WebDriver driver, HashMap<String, Object> exeMapObj) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		String reportFolderName = (String) exeMapObj.get("ReportFolderName");
		String reportName = (String) exeMapObj.get("ReportName");

		Log.info("right click and choose the option");
		/*
		 * Folder Right click and choose the New Logical Model
		 * 
		 */

		// String arg = treecolumn.replace("$$$", folder);
		String arg = "//span[starts-with(text(),'Folders')]";

		try {
			element = extJSElementHandler(driver, btn_saveReport);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			// element.sendKeys(Keys.chord(Keys.CONTROL, "a"),
			// reportFolderName);
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * Right click and choose the New Logical Model
		 * 
		 */

		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(arg)));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			rightClickAndChooseOption(driver, element, "New Folder");
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		/*
		 * Enter details Name , description and Click save button
		 * 
		 */

		Log.info("Enter folder name ");

		try {
			element = extJSElementHandler(driver, textFieldName2);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			// element.sendKeys(Keys.chord(Keys.CONTROL, "a"),
			// reportFolderName);
			actions.moveToElement(element);
			actions.sendKeys(Keys.chord(Keys.CONTROL, "a"), reportName);
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Log.info("Enter domain description " + reportFolderName);

		/*
		 * try { element = extJSElementHandler(driver, textareaFieldDesc2); }
		 * catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { //element.sendKeys(reportFolderName);
		 * actions.moveToElement(element);
		 * actions.sendKeys(Keys.chord(Keys.CONTROL, "a"), reportFolderName);
		 * actions.build().perform(); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 */

		Log.info("Click save button ");
		try {
			element = extJSElementHandler(driver, btn_SaveDomain);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {

			Thread.sleep(3000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

		/*
		 * Reports
		 * 
		 */
		/*
		 * Enter details Name , description and Click save button
		 * 
		 */

		Log.info("Enter folder name ");

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.name));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"), reportName);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Log.info("Enter domain description " + reportName);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.description));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element.sendKeys(reportName);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Log.info("Click save button ");
		try {
			element = extJSElementHandler(driver, saveFldBtn);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.saveReport));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

	public void EditReport(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		// String reportFolderName = (String)exeMapObj.get("ReportFolderName");
		String reportName = (String) exeMapObj.get("ReportName");

		/*
		 * Click on Expand All
		 */
		try {
			element = extJSElementHandler(driver, expandTree);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {

			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		String arg = treecolumn.replace("$$$", reportName);

		/*
		 * Right click and choose the New Logical Model
		 * 
		 */

		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(arg)));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, "Edit");
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * Log.info("Click edit button "); try { element =
		 * extJSElementHandler(driver, editReport); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { element =
		 * wait.until(ExpectedConditions.visibilityOf(element)); } catch
		 * (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { Thread.sleep(3000);element.click();
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

		try {
			Log.info("Click on Create run button ");
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.runReport));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {

			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.saveReport));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

	public void exportReport(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		Log.info("Click edit button ");
		try {
			element = extJSElementHandler(driver, reportOPtions);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.exportReport));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(ReportsPage.exportExcelReport));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element.click();
			Thread.sleep(3000);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * try { Thread.sleep(3000); element = extJSElementHandler(driver,
		 * reportToast_ProcessID); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { element =
		 * wait.until(ExpectedConditions.visibilityOf(element)); } catch
		 * (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try {
		 * actions.moveToElement(element).build().perform();
		 * System.out.println(element.getText());
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * try { element = extJSElementHandler(driver, btn_reportsDownloads); }
		 * catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { element =
		 * wait.until(ExpectedConditions.visibilityOf(element)); } catch
		 * (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { Thread.sleep(3000);element.click();
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

	public void generateReport(WebDriver driver, HashMap<String, Object> exeMapObj) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		// String reportFolderName = (String)exeMapObj.get("ReportFolderName");
		String reportName = (String) exeMapObj.get("ReportName");

		/*
		 * Click on Expand All
		 */
		try {
			element = extJSElementHandler(driver, expandTree);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Log.info("Click on Create Domain button ");
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {

			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		String arg = treecolumn.replace("$$$", reportName);

		/*
		 * Right click and choose the New Logical Model
		 * 
		 */

		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(arg)));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, "Generate Link");
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * Log.info("Click edit button "); try { element =
		 * extJSElementHandler(driver, editReport); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { element =
		 * wait.until(ExpectedConditions.visibilityOf(element)); } catch
		 * (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { Thread.sleep(3000);element.click();
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

	public void getReportLink(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		String[] linktypes = (String[]) exeMapObj.get("GenerateLinkType");
		String filepath = (String) exeMapObj.get("XmlFilePath");

		Log.info("Click edit button ");

		for (String linktype : linktypes) {

			if (linktype.equalsIgnoreCase("Public")) {
				try {
					element = extJSElementHandler(driver, generate_publicLink);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				try {
					element = wait.until(ExpectedConditions.visibilityOf(element));
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				try {
					Thread.sleep(2000);
					element.click();

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			try {
				element = extJSElementHandler(driver, generate_button);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			try {
				element = wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
				element.click();

			} catch (Exception e) {

				e.printStackTrace();
			}

			try {
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("url")));
				Thread.sleep(2000);
			} catch (Exception e) {

				e.printStackTrace();
			}
			String genUrl = element.getAttribute("value");
			try {
				System.out.println(genUrl);
				GetNameAsAttr.setXmlValue("/applicationInfo/InfoGenerateReport/@" + linktype.toLowerCase() + "", genUrl,
						filepath);
			} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException
					| TransformerException e) {

				e.printStackTrace();
			}

		}

		try {
			element = extJSElementHandler(driver, close_button);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void navigateAndRunReport(WebDriver driver, HashMap<String, Object> exeMapObj) {

		String linkType = (String) exeMapObj.get("LinkType");
		String filepath = (String) exeMapObj.get("XmlFilePath");
		String navigateReportURL = null;
		try {
			navigateReportURL = GetNameAsAttr
					.getText("/applicationInfo/InfoGenerateReport/@" + linkType.toLowerCase() + "", filepath);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			driver.navigate().to(navigateReportURL);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void runGeneateReport(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = extJSElementHandler(driver, runReportMain_button);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
