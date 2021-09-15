package com.aspiration.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

	
	public static WebDriver driver = null;
	
	
	@BeforeSuite
	public void initialize() {
		
		System.setProperty("webdriver.chrome.driver", "//Users//adekoyaadeeko//Downloads//chromedriver");
		// create an object of chrome driver
		driver = new ChromeDriver();
		
		// maximize the window
		driver.manage().window().maximize();
		
		//Implicitly wait for some seconds for browser to load
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//open the web page
		driver.get("https://aspiration.com/");
		
	}
	
	@AfterSuite
	public void endTest() {
		
			TestBase.driver.quit();
	}
	
}
