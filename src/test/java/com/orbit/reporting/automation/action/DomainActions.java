package com.orbit.reporting.automation.action;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orbit.reporting.automation.logger.Log;
import com.orbit.reporting.automation.page.Constants;
import com.orbit.reporting.automation.page.DomainPage;
import com.orbit.reporting.automation.utils.PageHelpers;
import com.orbit.reporting.automation.utils.TestBase;

public class DomainActions extends TestBase implements Constants {

	private WebElement element;

	public void createdDomain(WebDriver driver, String[] args) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		/*
		 * click on create new domain button
		 */
		try {
			element = extJSElementHandler(driver, btn_CreateDomain);
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
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		/*
		 * Enter name and description
		 */

		Log.info("Enter domain name " + args[0]);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.name));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"), args[0]);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Log.info("Enter domain description " + args[1]);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.description));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.sendKeys(args[1]);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		/*
		 * Click on save button
		 */

		try {
			element = extJSElementHandler(driver, btn_SaveDomain);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(2000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void createdPhysicalModel(WebDriver driver, Object[] args) {
		// Actions actions=new Actions(driver);
		Log.info("right click and choose the option");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e2) {

			e2.printStackTrace();
		}

		/*
		 * right Click And ChooseOption - physical Models
		 */
		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.physicalModels));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, "Physical");
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * Enter the domain name and description and choose the data source
		 */
		Log.info("Enter Physical domain name " + args[0]);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.name));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {

			e2.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"), (String) args[0]);

		Log.info("Enter domain description " + args[0]);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.description));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		element.sendKeys((String) args[0]);

		/*
		 * try { element =
		 * wait.until(ExpectedConditions.visibilityOf(DomainPage.arrow)); }
		 * catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 * 
		 * try { Thread.sleep(2000);element.click(); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 * 
		 * try { element = extJSElementHandler(driver,
		 * "return Ext.ComponentQuery.query(\"ext\")[4].id"); } catch (Exception
		 * e1) {
		 * 
		 * e1.printStackTrace(); } try { element =
		 * wait.until(ExpectedConditions.visibilityOf(element));
		 * Thread.sleep(3000); Thread.sleep(2000);element.click();
		 * Thread.sleep(3000); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
		/*
		 * try { element = wait.until(ExpectedConditions
		 * .presenceOfElementLocated(By.xpath(
		 * "//ul[@class='x-list-plain']/li[starts-with(text(),'"+(String)
		 * args[1]+"')]"))); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } try { Thread.sleep(2000); } catch
		 * (InterruptedException e2) {
		 * 
		 * e2.printStackTrace(); }
		 * 
		 * try { JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", element); } catch
		 * (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		driver.findElement(By.name("dataSourceId")).sendKeys((String) args[1]);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int i = 1;
		while (true) {
			try {
				element = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//ul[@class='x-list-plain']/li[" + i + "]")));
			} catch (Exception e1) {

				e1.printStackTrace();
			}

			String text = null;
			try {
				text = element.getText();
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			try {
				if (!text.isEmpty() && text.equalsIgnoreCase((String) args[1])) {
					String id = element.getAttribute("id");
					// driver.findElement(By.id(id)).click();
					// wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();
					try {
						if (!id.isEmpty()) {
							wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id)))).click();
						}
					} catch (Exception e) {

						e.printStackTrace();
					}
					break;
				}
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			try {
				robot.keyPress(KeyEvent.VK_DOWN);

			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			i++;
		}

		/*
		 * Click save button
		 */
		Log.info("Click save button ");
		element = extJSElementHandler(driver, btn_SaveDomain);
		try {
			Thread.sleep(2000);
			element.click();
			Thread.sleep(1000);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void importObjectsPhysical_model(WebDriver driver, String[] args) {
		Log.info("right click on physical model and choose import object  " + args[0]);
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		/*
		 * Right click and choose Import Objects option
		 */

		try {

			element = driver.findElement(By.xpath(args[0]));
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			actions.moveToElement(element);
			actions.contextClick(element).build().perform();
		} catch (Exception e2) {

			e2.printStackTrace();
		}

		try {
			element = extJSElementHandler(driver, importObjects);
		} catch (Exception e2) {

			e2.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(2000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}
		/*
		 * enter schemaName details
		 * 
		 */

		element = extJSElementHandler(driver, schemaName);
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(args[3].toUpperCase());
			actions.build().perform();

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * Choose the relation objects
		 * 
		 */
		String[] tabs = { "EMP", "DEPT" };
		for (String str : tabs) {

			try {
				element = extJSElementHandler(driver, tableName);
			} catch (Exception e2) {

				e2.printStackTrace();
			}
			try {
				element = wait.until(ExpectedConditions.visibilityOf(element));
				actions.moveToElement(element);
				actions.click();
				actions.sendKeys(Keys.chord(Keys.CONTROL, "a"), str.toUpperCase());
				actions.build().perform();

			} catch (Exception e1) {

				e1.printStackTrace();
			}
			try {
				element = extJSElementHandler(driver, tablesbtn);
			} catch (Exception e2) {

				e2.printStackTrace();
			}
			try {
				element = wait.until(ExpectedConditions.visibilityOf(element));
				actions.moveToElement(element);
				actions.click();
				// actions.sendKeys(args[1].toUpperCase());
				actions.build().perform();

			} catch (Exception e1) {

				e1.printStackTrace();
			}

			String tableName_xpath = Constants.gridItem.replace("$$$", str);

			try {
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tableName_xpath)));
				// element = driver.findElement(By.xpath(tableName_xpath));
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
				element.click();
			} catch (Exception e) {

				e.printStackTrace();
			}

			try {
				element = extJSElementHandler(driver, moveTable);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				element = wait.until(ExpectedConditions.visibilityOf(element));
				actions.moveToElement(element);
				actions.click();
				actions.build().perform();

			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
		/*
		 * // Dept element = extJSElementHandler(driver, tableName); try {
		 * 
		 * actions.moveToElement(element); actions.click();
		 * actions.sendKeys(Keys.chord(Keys.CONTROL, "a"),
		 * args[2].toUpperCase()); actions.build().perform();
		 * 
		 * } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } element = extJSElementHandler(driver,
		 * tablesbtn); try {
		 * 
		 * actions.moveToElement(element); actions.click();
		 * actions.sendKeys(args[1].toUpperCase()); actions.build().perform();
		 * 
		 * } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 * 
		 * tableName_xpath = Constants.gridItem.replace("$$$", args[2]);
		 * 
		 * try { element = driver.findElement(By.xpath(tableName_xpath)); }
		 * catch (Exception e) {
		 * 
		 * e.printStackTrace(); } try { Thread.sleep(2000);element.click(); }
		 * catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * element = extJSElementHandler(driver, moveTable); try {
		 * 
		 * actions.moveToElement(element); actions.click();
		 * actions.build().perform();
		 * 
		 * } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); }
		 */

		/*
		 * Click on Import button
		 */
		try {
			element = extJSElementHandler(driver, btn_import);
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	public void createLogicalModel(WebDriver driver, String[] args) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info("right click and choose the option");
		/*
		 * Right click and choose the New Logical Model
		 * 
		 */

		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.logicalModels));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, "Logical");
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		/*
		 * Enter details Name , description and Click save button
		 * 
		 */

		Log.info("Enter Physical domain name ");

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.name));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"), (String) args[0]);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Log.info("Enter domain description " + args[0]);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.description));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.sendKeys((String) args[0]);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

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
			Thread.sleep(2000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void relationshipTables(WebDriver driver, String[] args) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		/*
		 * Check expander and click
		 */
		try {
			element = extJSElementHandler(driver, expandDomainTree);

		} catch (Exception e2) {

			e2.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			actions.moveToElement(element).click().build().perform();
			Thread.sleep(3000);
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

		/*
		 * String expander_xpath = args[2];
		 * 
		 * try { Thread.sleep(2000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * expander_xpath))); } catch (Exception e2) {
		 * 
		 * e2.printStackTrace(); }
		 * 
		 * if (element.isDisplayed()) { Thread.sleep(2000); element.click(); }
		 */
		/*
		 * Right Click And Choose Option - Open Option from menu item
		 */
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(args[3])));
		} catch (Exception e2) {

			e2.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, args[4]);
		} catch (Exception e2) {

			e2.printStackTrace();
		}
		/*
		 * Drag and drop Objects into Canvas
		 */

		WebElement To = DomainPage.canvas;
		try {
			To = wait.until(ExpectedConditions.visibilityOf(To));
		} catch (Exception e3) {

			e3.printStackTrace();
		}

		for (int i = 0; i < 2; i++) {
			String tableRelation = Constants.treecolumn.replace("$$$", args[i]);

			WebElement From;
			try {
				From = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tableRelation)));
				actions.clickAndHold(From).build().perform();
				actions.moveToElement(To).build().perform();
				actions.release(To).build().perform();
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
		/*
		 * tableRelation = Constants.treecolumn.replace("$$$", args[1]);
		 * 
		 * 
		 * try { From =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * tableRelation))); actions.clickAndHold(From).build().perform();
		 * actions.moveToElement(To).build().perform();
		 * actions.release(To).build().perform(); } catch (Exception e2) {
		 * 
		 * e2.printStackTrace(); }
		 */

		try {
			element = extJSElementHandler(driver, fitButton);

		} catch (Exception e2) {

			e2.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * 
		 * Give the relation between tables
		 * 
		 */
		try {
			sikuliDragDrop();
		} catch (Exception e) {

			e.printStackTrace();
		}
		/*
		 * Click on relationship button
		 * 
		 */

		try {
			Thread.sleep(2000);
			element = extJSElementHandler(driver, btn_relationship);
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(2000);
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		/*
		 * Click on Save button
		 */
		try {
			element = extJSElementHandler(driver, btn_saveDomain);
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element);
			actions.click();

			actions.build().perform();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	public void createBusinessObject(WebDriver driver, HashMap<String, Object> map) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		/*
		 * Check expander and click
		 */
		String expander_xpath = (String) map.get("logicalModel_expander");
		String businessObject = (String) map.get("businessObject");

		try {
			element = extJSElementHandler(driver, expandDomainTree);

		} catch (Exception e2) {

			e2.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		/*
		 * try { Thread.sleep(2000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * expander_xpath))); } catch (Exception e2) {
		 * 
		 * e2.printStackTrace(); }
		 * 
		 * if (element.isDisplayed()) { try { Thread.sleep(2000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } element.click(); }
		 */

		Log.info("right click and choose the option");
		/*
		 * Right click and choose the New Logical Model
		 * 
		 */

		try {
			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.businessObjects));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, "Business");
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		/*
		 * Enter details Name , description and Click save button
		 * 
		 */

		Log.info("Enter Business Objectsname ");

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.name));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"), businessObject);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Log.info("Enter Business Objects description " + businessObject);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(DomainPage.description));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.sendKeys(businessObject);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

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
			Thread.sleep(2000);
			element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void buildingBusineeObject_ChooseOpenOption(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		/*
		 * Check expander and click
		 */
		// String expander_xpath = (String) exeMapObj.get("expander");
		String customBusineesObject = (String) exeMapObj.get("CustomBusineesObject");
		String menuItem = (String) exeMapObj.get("MenuItem");
		String categoryName = (String) exeMapObj.get("CategoryName");

		/*
		 * try { element = extJSElementHandler(driver, onExpandAll1);
		 * 
		 * } catch (Exception e2) {
		 * 
		 * e2.printStackTrace(); }
		 */
		/*try {
			// element.click();
			Thread.sleep(2000);
			actions.moveToElement(element).click().build().perform();
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}*/

		/*
		 * try { Thread.sleep(2000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * expander_xpath))); } catch (Exception e2) {
		 * 
		 * e2.printStackTrace(); }
		 * 
		 * if (element.isDisplayed()) { try { Thread.sleep(2000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } element.click(); }
		 */
		/*
		 * Right Click And Choose Option - Open Option from menu item
		 */
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(customBusineesObject)));
		} catch (Exception e2) {

			e2.printStackTrace();
		}
		
		/*try {
			element = extJSElementHandler(driver, newBusinessComp);

		} catch (Exception e2) {

			e2.printStackTrace();
		}*/
		

		try {
			try {
				element = wait.until(ExpectedConditions.visibilityOf(element));
				actions.moveToElement(element);
				actions.contextClick(element).build().perform();

			} catch (Exception e) {

				e.printStackTrace();
			}

			try {
				element = extJSElementHandler(driver, newCategory);

			} catch (Exception e2) {

				e2.printStackTrace();
			}
			try {
				element = wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
				actions.moveToElement(element);
				actions.sendKeys(categoryName);
				actions.sendKeys(Keys.ENTER);
				// actions.click();
				actions.build().perform();
			} catch (Exception e) {

				e.printStackTrace();
			}
		} catch (Exception e2) {

			e2.printStackTrace();
		}
	}

	public void buildingBusineeObject_moveColumsToCategory(WebDriver driver, HashMap<String, Object> exeMapObj) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		/*
		 * Check expander and click
		 */
		String expander_xpath1 = (String) exeMapObj.get("expander1");
		String expander_xpath2 = (String) exeMapObj.get("expander2");

		String customBusineesObject = (String) exeMapObj.get("CustomBusineesObject");
		String menuItem = (String) exeMapObj.get("MenuItem");
		String categoryName = (String) exeMapObj.get("CategoryName");
		String[] draggables = (String[]) exeMapObj.get("Draggables");
		String role = (String) exeMapObj.get("ADMIN");
		categoryName="New Category 1";
		/*try {
			element = extJSElementHandler(driver, onExpandAll1);

		} catch (Exception e2) {

			e2.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		} catch (Exception e4) {
			
			e4.printStackTrace();
		}*/

		String[] expanders = { expander_xpath1, expander_xpath2 };
		for (String expander_xpath : expanders) {

			try {
				Thread.sleep(2000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(expander_xpath)));
			} catch (Exception e2) {

				e2.printStackTrace();
			}

			if (element.isDisplayed()) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				element.click();
			}
		}

		/*
		 * Right Click And Choose Option - Open Option from menu item
		 */
		/*try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(customBusineesObject)));
		} catch (Exception e2) {

			e2.printStackTrace();
		}

		try {
			rightClickAndChooseOption(driver, element, menuItem);
		} catch (Exception e2) {

			e2.printStackTrace();
		}
		
		 * Given name to category
		 
		String NewCtgry = treecolumn.replace("$$$", "New Category");
		By newCtgry_xpath = By.xpath(NewCtgry);

		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(newCtgry_xpath));
		} catch (Exception e2) {

			e2.printStackTrace();
		}

		try {
			actions.moveToElement(element).doubleClick().sendKeys(categoryName).sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {

			e.printStackTrace();
		}
		*/
		
		
		
		
		/*
		 * Drag and Drop elements
		 */
		String CustomCtgry = treecolumn.replace("$$$", categoryName);
		By CustomCtgry_xpath = By.xpath(CustomCtgry);
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomCtgry_xpath));
		} catch (Exception e2) {

			e2.printStackTrace();
		}
		for (String drag : draggables) {
			String columns = treecolumn.replace("$$$", drag);
			By drag_columns = By.xpath(columns);

			WebElement drag_element = null;
			try {
				drag_element = wait.until(ExpectedConditions.presenceOfElementLocated(drag_columns));
			} catch (Exception e2) {

				e2.printStackTrace();
			}
			
			  try{
				

						/*actions.clickAndHold(drag_element).build().perform();
						actions.moveToElement(element).build().perform();
						actions.release(element).build().perform();*/
						
						actions.clickAndHold(drag_element);
						actions.moveToElement(element);
						actions.release(element).build().perform();
					
					//	actions.dragAndDrop(drag_element, element).build().perform();
			    
			  } catch(Exception e){
			   e.printStackTrace();
			  }
			
			

			

			
		}

	/*
	 * Assign Role
	 */
	// Click on Business Object - name in category panel
	try

	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(customBusineesObject)));
	}catch(
	Exception e2)
	{

		e2.printStackTrace();
	}

	try
	{
		Thread.sleep(2000);
		element.click();
	}catch(
	Exception e1)
	{
		e1.printStackTrace();
	}

	String str = PageHelpers.javascriptExecutor(driver, searchItems);

	try
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(str)));
	}catch(
	Exception e2)
	{

		e2.printStackTrace();
	}try
	{
		Thread.sleep(2000);
		element.click();
	}catch(
	Exception e1)
	{

		e1.printStackTrace();
	}

	try
	{
		element = wait.until(ExpectedConditions.visibilityOf(DomainPage.assignRole1));
	}catch(
	Exception e)
	{

		e.printStackTrace();
	}

	try
	{
		Thread.sleep(2000);
		element.click();
	}catch(
	Exception e1)
	{

		e1.printStackTrace();
	}

	/*
	 * Click on Save in reports page
	 */

	try
	{
		element = wait.until(ExpectedConditions.visibilityOf(DomainPage.saveDomain));
	}catch(
	Exception e)
	{
		Log.error("unable to identify the  Save button", e);
		e.printStackTrace();
	}

	try
	{
		Thread.sleep(2000);
		element.click();
	}catch(
	Exception e)
	{
		Log.error("error displayed while clicking on Save button", e);
		e.printStackTrace();
	}
}}
