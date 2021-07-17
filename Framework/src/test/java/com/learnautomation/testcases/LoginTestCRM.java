package com.learnautomation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class LoginTestCRM extends BaseClass {

	@Test(priority = 1)
	public void LoginApp() throws InterruptedException {

		System.out.println(driver.getTitle());
		ExcelDataProvider excel = new ExcelDataProvider();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger = report.createTest("Login to CRM");
		logger.info("Starting Application");
		logger.pass("Login Succeeeeeeessfully");

	}

	@Test(priority = 2)
	public void LoginApp1() throws InterruptedException {

		logger = report.createTest("Logout");
		logger.fail("Log out failed");

	}

}