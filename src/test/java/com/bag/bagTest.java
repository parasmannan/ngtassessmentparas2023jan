package com.bag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobject.bagPageObjects;

public class bagTest extends bagPageObjects{

static WebDriver driver;
	
	String rootFolder = System.getProperty("user.dir");
	Properties propObj = new Properties();
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		propObj.load(new FileInputStream(rootFolder + "//src//test//resources//data.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propObj.getProperty("url"));
	}
	
	@Test
	public void verifyBag() throws FileNotFoundException, IOException, InterruptedException {
		propObj.load(new FileInputStream(rootFolder + "//src//test//resources//data.properties"));
		bagPageObjects.clickBagButton(driver);
		bagPageObjects.verifyEmptyBag(driver);
		bagPageObjects.clickMyntraLogo(driver);
		bagPageObjects.enterProduct(driver, propObj.getProperty("product"));
		bagPageObjects.clickProduct(driver);
		Thread.sleep(2000);
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
		bagPageObjects.clickAddToBag(driver);
		bagPageObjects.clickBagButton(driver);
		bagPageObjects.verifyFillBag(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
