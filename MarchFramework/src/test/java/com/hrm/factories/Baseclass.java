package com.hrm.factories;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.helper;

public class Baseclass {
	public static ExtentSparkReporter spark ;
	public static ExtentReports Reports;
	public static ExtentTest logger;
	public static WebDriver driver;
	@BeforeSuite
	public void statusReport()
	{
		System.out.println("**********************suit initiated ***************************");
		spark= new ExtentSparkReporter(
				System.getProperty("user.dir")+"/Reports/SeleniumReport"+helper.dateFormate()+".html");
		Reports = new ExtentReports();
		Reports.attachReporter(spark);
		System.out.println("**********************suit initiated ***************************");
	}
	
	@AfterMethod
	public void ResultReport(ITestResult result)
	{
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Test passed", MediaEntityBuilder.createScreenCaptureFromPath(
					helper.takeScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(
					helper.takeScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Test Skipped");
		}
		Reports.flush();
	}
	@BeforeClass
	public void startSession()
	{
		String browser=readData.getProperty("browser");
		String url=readData.getProperty("url");
		driver=Browserfactory.StartBrowser(browser, url);
	}
	@AfterClass
	public void endSession()
	{
		Browserfactory.closeBrowser(driver);
	}
}
