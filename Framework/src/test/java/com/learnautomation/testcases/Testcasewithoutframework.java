package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcasewithoutframework {
	@Test
	public  void test1() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
//driver.get("https://www.spicejet.com/");
		driver.get("https://ui.cogmento.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * Select select=new Select(driver.findElement(By.
		 * xpath("//select[contains(.,'Departure City')]/following::span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']"
		 * ))); select.selectByVisibleText("Bengaluru (BLR)");
		 */
		driver.findElement(By.name("email")).sendKeys("sulagnas.sadual@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Globalsupport@980");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();

//driver.quit();
	}
}
