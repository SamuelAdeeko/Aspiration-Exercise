package com.aspiration.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OurProducts {

	private static Logger log = Logger.getLogger(OurProducts.class);
	private WebDriver driver;
	
	public OurProducts(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// using FindBy to get page web elements
	
	@FindBy(how=How.XPATH, using="//button[@class='btn btn-v3 btn--blue ng-binding']") WebElement getAspirationPlus;
	@FindBy(how=How.XPATH, using = "//input[@id='join-waitlist-input']") WebElement joinWaitList;
	@FindBy(how =How.XPATH, using="//div[@class='modal-content']") WebElement aspirationPlusModal;
//	@FindBy(how =How.XPATH, using="//div[@class='option']/h3") WebElement monthlyModal;
	

		// verify there are two card products, Aspiration and Aspiration plus
		public String[] products() {
			String[] product = new String[2];
			List<WebElement> element = new ArrayList<>();
			
			/* Both cards have the same div class name,
			by using findElements I am able to get all Web elements with same class name
			*/
			 element = driver.findElements(By.xpath("//div[@class = 'plan-content']/h2"));
				String one = element.get(0).getText() ;
				String two = element.get(1).getText();
				product[0] = one;
				product[1] = two;
				log.info("Text one == " + one);
				log.info("Text two == " + two);
				return product;
		}
		
		public void aspiration() {
			
			List<WebElement> element = new ArrayList<>();
			element = driver.findElements(By.xpath("//button[@class='btn btn-v3 btn--blue ng-binding']"));
			String a = element.get(0).getText();
			log.info("This is A: " + a);
			String b = element.get(1).getText();
			log.info("This is B: " + b);
			Boolean isFalse = false;
			
			if(a.equals("GET ASPIRATION") || b.equals("GET ASPIRATION")) {
				element.get(0).click();
				log.info("Get Aspiration is clicked");
				isFalse = joinWaitList();
				// If isFalse is True, navigate back
				if(isFalse) {
					driver.navigate().back();
					log.info("Navigated to previous product page.");
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					homePage.spendAndSave();
				}
			}
			
		}
			
	

		public void aspirationPlus() {

			List<WebElement> element = new ArrayList<>();
			element = driver.findElements(By.xpath("//button[@class='btn btn-v3 btn--blue ng-binding']"));
			String a = element.get(0).getText();
			log.info("This is A: " + a);
			String b = element.get(1).getText();
			log.info("This is B: " + b);
			Boolean isFalse = false;
			
			if(a.equals("GET ASPIRATION PLUS") || b.equals("GET ASPIRATION PLUS")) {
				element.get(1).click();
				log.info("Get Aspiration plus is clicked");
				isFalse = aspirationPlusModal();
				// If isFalse is True, navigate back
				if(isFalse) {
					log.info("Modal Appears");
				}
			
			}
			
			
		}
			
		public Boolean joinWaitList() {
			return joinWaitList.isDisplayed();
		}

		//  modal with monthly and yearly plan is displayed
		public Boolean aspirationPlusModal() {
			Boolean isFalse = false;
			isFalse = aspirationPlusModal.isDisplayed();
			if(isFalse) {
				log.info("Aspiration plus modal is displayed");
				return isFalse;
			}
			return isFalse;
		}
		

		
		public void yearlyPayment() {
			
			WebElement element =  driver.findElement(By.xpath("//div[@class='option selected']"));
		
			String a = element.getText();
			log.info("Text: " + a);
		}
		
		public void monthlyPayment() {
			
			WebElement element =  driver.findElement(By.xpath("//div[@class='option']"));
		
			String a = element.getText();
			log.info("Text: " + a);
		}
		
}
