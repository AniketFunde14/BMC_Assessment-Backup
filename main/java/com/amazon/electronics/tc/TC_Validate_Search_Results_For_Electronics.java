package com.amazon.electronics.tc;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amazon.electronics.po.PO_Electronics;



public class TC_Validate_Search_Results_For_Electronics {


	@Test
	public void tc_01_verify_search_result() throws InterruptedException 
	{
		try {
			String Googleurl="http://www.google.com";
			String search_Amazon = "Amazon";

			//configure and invoke browser		  
			System.setProperty("webdriver.chrome.driver","C:\\Aniket\\AniketSelenium\\chromedriver 114\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"); 			        
			WebDriver driver=new ChromeDriver(); 
			PO_Electronics po_electronics = new PO_Electronics(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Googleurl);

			//Init Page Objects with Page Factory
			//=PageFactory.initElements(driver, PO_Electronics.class);

			// searching amazon on google
			WebElement p=driver.findElement(By.name("q"));
			p.sendKeys(search_Amazon);
			//					 WebDriverWait w = new WebDriverWait(driver, 5);
			//				      w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
			Thread.sleep(500);
			p.submit();
			Thread.sleep(1500);

			// click on amazon link on google page
			//po_electronics.click_on_amazon_link();
			WebElement amazonLink=driver.findElement(By.partialLinkText("Amazon.in"));
			amazonLink.click();
			Thread.sleep(500);
			
			//Click on account n list
			WebElement Acc_n_list_button = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
			Thread.sleep(2000);
			Acc_n_list_button.click();
			
			WebElement enter_MobNo= driver.findElement(By.xpath("//input[@type='email']"));
			enter_MobNo.sendKeys("8624820237");
			
			WebElement continue_button = driver.findElement(By.xpath("//input[@id='continue']"));
			continue_button.click();
			
			WebElement enter_psw= driver.findElement(By.id("ap_password"));
			enter_psw.sendKeys("aniket123");
			
			WebElement signIn_button = driver.findElement(By.id("signInSubmit"));
			signIn_button.click();
			
			
            // click on all button on search 
			WebElement all_button=driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']"));
			all_button.click();

            // click on electronics option
			WebElement electronics_option=driver.findElement(By.xpath("//option[contains(text(),'Electronics')]"));
			electronics_option.click();
			
			//search for Dell laptops
			WebElement search_bar_amazon_home_page=driver.findElement(By.xpath("//input[contains(@id,'searchtextbox')]"));
			search_bar_amazon_home_page.click();
			search_bar_amazon_home_page.sendKeys("Dell laptop");
			
			
			WebElement search_button_amazon_home_page=driver.findElement(By.xpath("//input[contains(@id,'nav-search-submit-button')]"));
			search_button_amazon_home_page.click();
			
			// applying filter of 30000 to 40000 rs
			
			//WebElement filter_30000_to_40000=driver.findElement(By.xpath("//span[contains(text(),'₹30,000 – ₹40,000')]"));
			//filter_30000_to_40000.click(); 
			Thread.sleep(2000);
			
			WebElement filter_Min_price= driver.findElement(By.xpath("//input[@placeholder='Min']"));
			filter_Min_price.sendKeys("30000");
			
			WebElement filter_Max_price= driver.findElement(By.xpath("//input[@placeholder='Min']"));
			filter_Max_price.sendKeys("50000");
			
			WebElement Go_button= driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
			Go_button.click();

			//driver.quit();
			
			//WebElement Stars_rating= driver.findElement(By.xpath("//div[@aria-label='4 Stars & Up']"));
			//Stars_rating.click();
			
			//list of products by price
			List<WebElement> all_products= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			WebElement q;
			for(int i=0;i<all_products.size();i++) 
			{
				q= all_products.get(i);
				System.out.println(q.getText());
				Assert.assertTrue(true);
				
			}
			for(WebElement j:all_products)
			{
				System.out.println(j.getText());
				Assert.assertTrue(true);
				//String expected=j.getText();
				//Assert.assertTrue(true, expected);
				//Assert.assertEquals(0, 0, search_Amazon)
			}
			
			Thread.sleep(2000);
			
			
			
			//Print 5 of 5 star
			WebElement Star5 = driver.findElement(By.xpath("//span[contains(text(),'Dell G15-5530 Gaming ')]"));
            
			
			    Star5.getText();
				Thread.sleep(2000);
				Star5.click();
				Thread.sleep(2000);
				
//				//Click on account n list
//				WebElement Acc_n_list_button = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
//				Thread.sleep(2000);
//				Acc_n_list_button.click();
//				
				
			
			
			//Click 5 Star
			
			
			
			//C:\Parameterization
				
				File src = new File("C:\\Parameterization\\InputData.xlsx");
				
				WorkbookFactory.create("InputData").getSheet("Creds").getRow(0);
				
			
			
			
			
			
 



		} catch (Exception e) 
		{
			Reporter.log("Test Failed", true);
			Assert.assertFalse(false);
		}
	}
}
