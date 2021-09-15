package com.aspiration.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OurProducts {

	private static Logger log = Logger.getLogger(OurProducts.class);
	private WebDriver driver;
	
	public OurProducts(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// using FindBy to get page web elements
	
	@FindBy(how=How.XPATH, using="//button[@class='btn btn-v3 btn--blue ng-binding']") WebElement getAspirationPlus;
//	@FindBy(how =How.XPATH, using="//div[@class='circle']/h3") WebElement yearlyModal;
//	@FindBy(how =How.XPATH, using="//div[@class='option']/div/h3") WebElement monthlyModal;
	

		// verify there are two card products, Aspiration and Aspiration plus
		public String[] products() {
			String[] product = new String[2];
			List<WebElement> element = new ArrayList<>();
			 element = driver.findElements(By.xpath("//div[@class = 'plan-content']/h2"));
				String one = element.get(0).getText() ;
				String two = element.get(1).getText();
				product[0] = one;
				product[1] = two;
				log.info("Text one == " + one);
				log.info("Text two == " + two);
				return product;
		}
		
		public void getAspirationPlus() {
			getAspirationPlus.click();
			log.info("Aspiration plus clicked");
		}
		
		public void yearlyModal() {
//			String text = yearlyModal.getText();
//			log.info("Modal: " + text);
		}


}
