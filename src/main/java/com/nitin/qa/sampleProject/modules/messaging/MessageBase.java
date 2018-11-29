package com.nitin.qa.sampleProject.modules.messaging;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.nitin.qa.sampleProject.framework.WebDriverUtilities;
import com.nitin.qa.sampleProject.modules.basic.Basicbase;

public class MessageBase extends WebDriverUtilities  {
	
	
	public void openMessageModule(){
		WebElement messagemodule = driver.findElement(By.xpath("//h3[contains(@class,'ui-accordion-header')]/a[contains(text(),'Messaging')]"));
		messagemodule.click();
	}

	public void sendSms() throws Exception {
		
		waitForElement(driver, driver.findElement(By.id("link-create")));
		driver.findElement(By.id("link-create")).click();

		WebDriverUtilities.waitForElement(driver, driver.findElement(By.xpath("//button[contains(@class,'ui-corner-all done ui-button')]")));
		driver.findElement(By.xpath("//button[contains(@class,'ui-corner-all done ui-button')]")).click();
		driver.findElement(By.xpath("//a[@id='add-page']")).click();
		driver.findElement(By.xpath("//input[@name='name'][@class='indented submitonenter']")).sendKeys("Test");

		driver.findElement(By.xpath("//button[text()='Create'][contains(@class,'ui-button')]")).click();
		WebDriverUtilities.waitForElement(driver, driver.findElement(By.xpath("//a[@class='tab-label'][text()='Test']")));
		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@class,'ui-accordion-header')]/a[contains(text(),'Messaging')]")).isDisplayed());
		
		openMessageModule();
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'module-item-green ui-draggable')][text()='Send an SMS']")).isDisplayed());


		dragAndDropBy(driver, driver.findElement(By.xpath("//li[contains(@class,'module-item-green ui-draggable')][text()='Send an SMS']")), 250 , 100);


		List<WebElement> startNode = driver.findElements(By.xpath("//div[contains(@class,'start-module')]/div[contains(@class,'mod-south')]/div[contains(@class,'syn-node-active')]"));

		List<WebElement> sendSmsNode = driver.findElements(By.xpath("//div[contains(@class,'syn-module syn-module-green')]/div[contains(@class,'mod-north')]/div[contains(@class,'syn-receptor')]"));

		dragAndDrop(driver, startNode.get(1), sendSmsNode.get(0));
		driver.findElement(By.xpath("//textarea[@name='phone_constant']")).sendKeys("8105665169");
		driver.findElement(By.xpath("//textarea[@name='message_phrase[]']")).sendKeys("Hi");

		Basicbase.openBasicModule();
		
		Basicbase.exitApp(150, 150);
		Basicbase.exitApp(400, 350);
		Basicbase.exitApp(400, 500);
		
		

		List<WebElement> smsSent =driver.findElements(By.xpath("//div[contains(@class,'syn-module syn-module-green')]/div/div[3]/div/div[3]/div[contains(@class,'syn-node syn-node-attached-w ui-draggable syn-node-active')]"));
		



		List<WebElement> hangupNode = driver.findElements(By.xpath("//div[contains(@class,'syn-module-red')]/div[contains(@class,'mod-north')]/div"));

		dragAndDrop(driver, smsSent.get(0), hangupNode.get(0));

	}
	
	public void sendEmail() throws Exception{
		
		List<WebElement> hangupNode = driver.findElements(By.xpath("//div[contains(@class,'syn-module-red')]/div[contains(@class,'mod-north')]/div"));
		openMessageModule();
		List<WebElement> smsNotSent = driver.findElements(By.xpath("//div[contains(@class,'syn-module syn-module-green')]/div/div[3]/div/div[3]/div[contains(@class,'syn-node syn-node-attached-e ui-draggable syn-node-active')]"));

		WebElement sendEmail = driver.findElement(By.xpath("//li[contains(@class,'module-item-green ui-draggable')][text()='Send an Email']"));

		Thread.sleep(2000);
		dragAndDrop(driver, sendEmail,driver.findElement(By.xpath("//div[@id='tabs-2']")));
		
		List<WebElement> sendEmailnode = driver.findElements(By.xpath("//div[contains(@class,'syn-module syn-module-green')]/div[contains(@class,'mod-north')]/div[contains(@class,'syn-receptor')]"));
		
		dragAndDrop(driver, smsNotSent.get(0), sendEmailnode.get(1));
		
		List<WebElement> emailSent =driver.findElements(By.xpath("//div[contains(@class,'syn-module syn-module-green')]/div/div[3]/div/div[4]/div[contains(@class,'syn-node syn-node-attached-w ui-draggable syn-node-active')]"));
		List<WebElement> emailNotSent = driver.findElements(By.xpath("//div[contains(@class,'syn-module syn-module-green')]/div/div[3]/div/div[4]/div[contains(@class,'syn-node syn-node-attached-e ui-draggable syn-node-active')]"));
		
		dragAndDrop(driver, emailSent.get(0), hangupNode.get(1));
		dragAndDrop(driver, emailNotSent.get(0), hangupNode.get(2));
		
		driver.findElement(By.xpath("//input[@name='smtp_url']")).sendKeys("smtp.gmail.com");
		driver.findElement(By.xpath("//input[@name='port']")).sendKeys("465");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("nitin@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");
	}
}
