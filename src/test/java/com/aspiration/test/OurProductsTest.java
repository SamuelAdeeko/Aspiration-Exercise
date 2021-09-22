package com.aspiration.test;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aspiration.pages.OurProducts;

public class OurProductsTest extends TestBase{

	
	@Test
	public void init() {
		
		OurProducts ourProduct = PageFactory.initElements(driver, OurProducts.class);
		
		/*verify that we see card products Aspiration and Aspiration Plus
		 * I used assertEquals method to check if actual object 'actualProducts' is equals expected
		 * object 'products'
		 */
		
		String [] actualProducts = new String[2];
		String [] products = {"Aspiration", "Aspiration Plus"};
		// products() returns an array of Strings
		actualProducts = ourProduct.products();
		Assert.assertEquals( actualProducts, products);
		
		// Test to click get Aspirations plus and Aspiration
		
		ourProduct.aspiration();
		ourProduct.aspirationPlus();
		
		// Test to check if modal appears
		ourProduct.aspirationPlusModal();
		
		ourProduct.yearlyPayment();
		ourProduct.monthlyPayment();

	}
}
