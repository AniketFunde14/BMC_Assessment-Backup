package com.amazon.electronics.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {
	

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Aniket\\\\AniketSelenium\\\\chromedriver 114\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		
		
	}
	
	
	
}
