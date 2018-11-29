package com.nitin.qa.sampleProject.modules.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nitin.qa.sampleProject.framework.WebDriverUtilities;

public class Basicbase extends WebDriverUtilities {
	
	public static void exitApp(int xoffset , int yoffset) throws Exception{
		
		WebElement hangup = driver.findElement(By.xpath("//li[contains(@class,'module-item-red')]"));
		dragAndDropBy(driver, hangup, xoffset, yoffset);
		
	}
	
	public static void openBasicModule(){
		WebElement basicModule = driver.findElement(By.xpath("//h3[contains(@class,'ui-accordion-header')]/a[contains(text(),'Basic')]"));
		basicModule.click();
	}

}
