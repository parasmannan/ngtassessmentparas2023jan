package com.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobject.loginPageObjects;

public class loginTest extends loginPageObjects {

	static WebDriver driver;
	
	String rootFolder = System.getProperty("user.dir");
	Properties propObj = new Properties();
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		propObj.load(new FileInputStream(rootFolder + "//src//test//resources//data.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propObj.getProperty("urlEP"));
	}
	
	@Test
	public void verifyLogin() throws FileNotFoundException, IOException, InterruptedException {
		propObj.load(new FileInputStream(rootFolder + "//src//test//resources//data.properties"));
		loginPageObjects.sendEmail(driver, propObj.getProperty("email"));
		loginPageObjects.sendPassword(driver, propObj.getProperty("password"));
		loginPageObjects.clickLoginButton(driver);
		Thread.sleep(30000);
		loginPageObjects.clickLoginButton(driver);
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, propObj.getProperty("expectedTitle"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
