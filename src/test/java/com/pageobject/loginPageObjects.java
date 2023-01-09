package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginPageObjects {
	
	public static void verifyProfileButton(WebDriver driver) {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='desktop-user']")).isDisplayed());
	}
	
	public static void sendEmail(WebDriver driver, String email) {
		driver.findElement(By.id("mobileNumberPass")).sendKeys(email);
	}

	public static void sendPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(password);
	}
	
	public static void clickLoginButton(WebDriver driver) {
		driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	}
	
	public static void verifyPageTitle(WebDriver driver) {
		//
	}
}
