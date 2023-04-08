package com.hrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.helper;

public class login {
	WebDriver driver;
	By username=By.xpath("//input[@name='username']");
	By password=By.xpath("//input[@name='password']");
	By submit_button=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	public void enteruserName()
	{
		
		//page
		System.out.println("enter username");
		helper.findAndSendKeys(driver, username, "Admin");
	}
	public void enterpassword()
	{
		helper.findAndSendKeys(driver, password, "admin123");
	}
	public void submit()
	{
		helper.findAndClick(driver, submit_button);
	}
	public login(WebDriver driver)
	{
		this.driver=driver;
	}

}