package com.amazon.electronics.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PO_Electronics {
	
	//Initialize driver
		WebDriver driver;

		//Parameterized Constructor 
		public PO_Electronics(WebDriver d)
		{
			driver=d;	
		}

		//Elements
		@FindBy(xpath ="//a[contains(@href,'/electronics')]")
		private  WebElement electronics;
		
		
		@FindBy(name ="q")
		private  WebElement search_bar_on_google_page;
		
		@FindBy(xpath ="//a[@href='https://www.amazon.com/']")
		private  WebElement amazon_link_on_google_search;
		
		//@FindBy(xpath = "")
		
		@FindBy(xpath = "//section[@aria-label='4 Stars & Up']")
		private WebElement Stars_rating;
		
		
		//Methods
		public void search_on_google (String text) {
			search_bar_on_google_page.click();
			search_bar_on_google_page.sendKeys(text);
		}
		
		//click 
		public void click_on_amazon_link () {
			amazon_link_on_google_search.click();
		}
		
		
			
			
			 public void validateProductPrices() {
			        // Loop through the first two pages
			        for (int page = 1; page <= 2; page++) {
			            // Locate and extract the price elements on the page
			            java.util.List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-price"));

			            // Validate prices on the current page
			            for (WebElement priceElement : priceElements) {
			                String priceText = priceElement.getText().replace("Rs ", "").replace(",", "");
			                int price = Integer.parseInt(priceText);

			                // Check if the price is within the specified range
			                Assert.assertTrue(price >= 30000 && price <= 50000, "Price is not within the range: Rs 30,000 - Rs 50,000");
			            }

			            // If it's the last page, break the loop
			            if (page == 2) {
			                break;
			            }

			            // Navigate to the next page
			            WebElement nextPageButton = driver.findElement(By.cssSelector(".next-page-button"));
			            nextPageButton.click();
		}

  }
}
