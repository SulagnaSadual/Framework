package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication (WebDriver driver, String browserName,String appURL)
	
	{
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/ritsulu/Downloads/chromedriver");
		    driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browserName.equals("Firefox"))
		{
			
		}
		else if(browserName.equals("IE"))
		{
			
		}
		else
		{
			System.out.println("we donot support project");
		}
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	
 public static void quitBrowser(WebDriver driver)
 {
	 driver.quit();
 }
}
