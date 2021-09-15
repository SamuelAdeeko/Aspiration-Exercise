package com.aspiration.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {

	private WebDriver driver;
	private static Logger log = Logger.getLogger(HomePage.class);
	
	public HomePage() {
		super();
	}
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// using FindBy to get page web elements
	
	@FindBy(how=How.LINK_TEXT, using = "Spend & Save") WebElement viewProduct;
	@FindBy(how=How.XPATH, using = "//button[@id= 'onetrust-accept-btn-handler']") WebElement acceptCookieButton;
	
	
	
	public void acceptCookie() {
		acceptCookieButton.click();
		log.info("cookie accepted");
	}
	
	public void spendAndSave() {
		viewProduct.click();
		log.info("Spend and Save link clicked");
	}
	
}
