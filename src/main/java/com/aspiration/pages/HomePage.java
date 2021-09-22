package com.aspiration.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	private WebDriver driver;
	private static Logger log = Logger.getLogger(HomePage.class);
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	// using FindBy to get page web elements
	
	@FindBy(how=How.LINK_TEXT, using = "Spend & Save") WebElement viewProduct;
	@FindBy(how=How.XPATH, using = "//button[@id= 'onetrust-accept-btn-handler']") WebElement acceptCookieButton;
	
	
	public void waitForCookie() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
	}
	
	public void acceptCookie() {
		acceptCookieButton.click();
		log.info("cookie accepted");
//		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}
	
	public void waitForSpendAndSave() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Spend & Save")));
	}
	
	public void spendAndSave() {
		viewProduct.click();
		log.info("Spend and Save link clicked");
	}
	
}
