package com.orbit.reporting.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.orbit.reporting.automation.logger.Log;

public class TestBase {
	public  WebElement extJSElementHandler(WebDriver driver, String query) {

		String btn_id = null;
		try {
			btn_id = PageHelpers.javascriptExecutor(driver, query);
		} catch (Exception e) {

			e.printStackTrace();
		}

		Log.info("Id locator property " + btn_id);

		WebElement element = null;
		try {
			element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(btn_id)));
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return element;
	}

	
	public  void rightClickAndChooseOption(WebDriver driver, WebElement element,String text) {
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element);
			actions.contextClick(element).build().perform();

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			String str="//a[@class='x-menu-item-link']/span[contains(text(),'"+text+"')]";			
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str)));			
			actions.moveToElement(element);
			actions.click();
			actions.build().perform();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void sikuliDragDrop(){
		String img_path = System.getProperty("user.dir") + "\\src\\test\\resources\\images";
		Pattern image1 = new Pattern(img_path + "\\emp.png");

		Pattern image2 = new Pattern(img_path + "\\dept.png");

		Screen screen = new Screen();

		try {
			screen.find(image1);
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		try {
			screen.find(image2);
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		try {
			screen.dragDrop(image1, image2);
		} catch (FindFailed e) {

			e.printStackTrace();
		}
	}
	

}
