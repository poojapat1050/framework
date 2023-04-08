package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {
	public static String dateFormate() {

		SimpleDateFormat sdf = new SimpleDateFormat("MM_YYYY_DD_mm_HH_SS");
		Date d = new Date();
		String datename = sdf.format(d);
		return datename;
	}

	public static WebDriver browserlaunch() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\suhar\\OneDrive\\Desktop\\code\\March Morning batch\\chromedriver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();

		co.addArguments("--no-sandbox");

		co.addArguments("--disable-extensions");
		co.addArguments("--remote-allow-origins=*");
		return driver = new ChromeDriver(co);
	}

	public static String takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);

		SimpleDateFormat sdf = new SimpleDateFormat("MM_YYYY_DD_mm_HH_SS");
		Date d = new Date();
		String datename = sdf.format(d);
		String destn = "C:\\Users\\suhar\\OneDrive\\Desktop\\workspace\\March_Automation\\screenshot\\" + datename
				+ ".png";
		File dest = new File(destn);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destn;

	}

	public static WebDriver findAndSendKeys(WebDriver driver, By ele, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		driver.findElement(ele).sendKeys(value);
		return driver;

	}

	public static WebDriver findAndClick(WebDriver driver, By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		driver.findElement(ele).click();
		return driver;

	}

	public static String findAndsendValue(WebDriver driver, By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		return driver.findElement(ele).getText();

	}
}
