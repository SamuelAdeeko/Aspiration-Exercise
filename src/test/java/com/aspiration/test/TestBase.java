package com.aspiration.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

	
	public static WebDriver driver = null;
	
	
	@BeforeSuite
	public void initialize() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//adekoyaadeeko//Downloads//chromedriver");
		// create an object of chrome driver
		driver = new ChromeDriver();
		
		// maximize the window
		driver.manage().window().maximize();
		
		//Implicitly wait for some seconds for browser to load
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//read properties from the properties file
		
		Properties properties = new Properties();
		FileInputStream inputStream = new FileInputStream("/Users/adekoyaadeeko/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE/Aspiration-Exercise/src/test/resources/testdata.properties");
		properties.load(inputStream);
		String url = properties.getProperty("url");
		
		//open the web page
		driver.get(url);
	}
	
	@AfterSuite
	public void endTest() {
		
			TestBase.driver.quit();
	}
	
}
