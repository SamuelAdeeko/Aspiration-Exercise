package com.aspiration.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aspiration.pages.HomePage;



public class HomePageTest extends TestBase {

	@Test
	public void init() throws InterruptedException {
		// Initializing HomePage using PageFactory
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// explicit wait- to wait for accept cookie button to be clickable
		homePage.waitForCookie();
		// call accept accept cookie method in the homePage object
		homePage.acceptCookie();
		Thread.sleep(4000);
		// click spend & save
		homePage.spendAndSave();	
	}
	
}
