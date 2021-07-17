package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void SetUpSuite()
	{
		Reporter.log("Setting up the reports and Test Started ", true);
			 excel=new ExcelDataProvider();
			 config=new ConfigDataProvider();
			 
			 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
			 report=new ExtentReports();
			 report.attachReporter(extent);
		Reporter.log("Setting up done and Test can be Started ", true);	 
	}

@BeforeClass
	
	public void SetUp()
	{
	Reporter.log("Setting up the Browser and application is getting ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Browser and applocation is up and running ", true);
	}
	
	
	@AfterClass
	
    public void tearDown()
	
	{
		
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		if (result.getStatus()==ITestResult.FAILURE) {
			 //Helper.captureScreenshot(driver);
			 //Attaching ss to report
		

		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		System.out.println("FAILED report");
		
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}
		report.flush();
		Reporter.log("Test completed and reports generated", true);
			
	}
		
	}


