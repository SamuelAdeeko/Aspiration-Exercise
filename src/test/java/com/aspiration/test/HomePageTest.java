package com.aspiration.test;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aspiration.pages.HomePage;



public class HomePageTest extends TestBase {

	@Test
	public void init() throws InterruptedException {
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.acceptCookie();
		Thread.sleep(4000);
		homePage.spendAndSave();
	
		
	}
	
}
