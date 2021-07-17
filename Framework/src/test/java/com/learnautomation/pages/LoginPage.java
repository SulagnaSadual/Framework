package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.learnautomation.utilities.BrowserFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//This is new code from Sulagna

	public LoginPage(WebDriver ldriver)
	{
			this.driver=ldriver;
	}
	
	@FindBy (name="email") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//div[contains(text(),'Login')]") WebElement loginbutton;
	
	public void loginToCRM(String usernameApplication, String passwordApplication) throws InterruptedException
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		loginbutton.click();
		Thread.sleep(5000);
	}
}
