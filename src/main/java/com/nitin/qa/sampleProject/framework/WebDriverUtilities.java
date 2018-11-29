package com.nitin.qa.sampleProject.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverUtilities extends ProjectTestCase {

	/**
	 * Wait for a element to be displayed.
	 * @param by : Element
	 * @param maxWaitTime : Maximum waiting time in seconds.
	 * @throws Exception 
	 */
	public static void waitForElement(WebDriver driver, WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
	}
	
	public static void dragAndDrop(WebDriver driver , WebElement sourceLocator , WebElement targetLocator) throws Exception{
		
		//create object 'action' of Actions class
		Actions action = new Actions(driver);
		//use dragAndDrop() method. It accepts two parametes source and target.
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
		Thread.sleep(4000);
	}
	
public static void dragAndDropBy(WebDriver driver , WebElement sourceLocator , int xoffset , int yoffset) throws Exception{
		
		//create object 'action' of Actions class
		Actions action = new Actions(driver);
		//use dragAndDrop() method. It accepts two parametes source and target.
		action.dragAndDropBy(sourceLocator, xoffset, yoffset).build().perform();
		Thread.sleep(4000);
	}

	protected void log(String message) {
		Reporter.log(message, true);
	}

	protected void log(Object message) {
		if(message != null){
			Reporter.log(message.toString(), true);
		}else{
			Reporter.log("log method called with null object", true);
		}
	}
	
	
}
