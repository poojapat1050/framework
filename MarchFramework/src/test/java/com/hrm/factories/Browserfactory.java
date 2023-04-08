package com.hrm.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browserfactory {
public static WebDriver StartBrowser(String browser, String url)
{System.out.println("**********************Browser initiated ***************************");
	WebDriver driver = null;
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\suhar\\OneDrive\\Desktop\\code\\March Morning batch\\chromedriver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();

		co.addArguments("--no-sandbox");

		co.addArguments("--disable-extensions");
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get(url);
	
	}
	else if(browser.equalsIgnoreCase("firfox"))
	{
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir")+"/src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions co = new ChromeOptions();

		co.addArguments("--no-sandbox");

		co.addArguments("--disable-extensions");
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	driver.manage().window().maximize();
	
	return driver;
	
}
public static void closeBrowser(WebDriver driver)
{
	driver.close();
}
}
