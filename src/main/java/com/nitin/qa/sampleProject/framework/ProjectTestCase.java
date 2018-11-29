package com.nitin.qa.sampleProject.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public class ProjectTestCase {
	
	
	protected static WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception{

		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/test/resources/geckodriver");
		
		if(driver == null){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(Config.LOGIN_URL);
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

	/**
	 * 
	 * @throws Exception
	 */
	public void userLogin() throws Exception {	

		
	}

	public void userLogout(){
		
		tearDown();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			try{
				tearDown();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@AfterSuite
	public void tearDown(){
		log("closing webdriver");
		driver.close();
		if(driver != null){
			driver = null;
		}
		log("webdriver closed.");
	}
}
