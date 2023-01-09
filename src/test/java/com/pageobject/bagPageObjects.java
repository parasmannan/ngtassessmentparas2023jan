package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class bagPageObjects {
	
	public static void clickMyntraLogo(WebDriver driver) {
		driver.findElement(By.xpath("//div[@class='myntra-logo']")).click();
	}
	
	public static void clickBagButton(WebDriver driver) {
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
	}

	public static void verifyEmptyBag(WebDriver driver) {
		Assert.assertTrue(driver.findElement(By.xpath("//div[.='Hey, it feels so light!']")).isDisplayed());
	}
	
	public static void enterProduct(WebDriver driver, String product) {
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys(product);
		driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
	}
	
	public static void clickProduct(WebDriver driver) {
		driver.findElement(By.xpath("//img[@alt='Wildcraft Unisex Lunar Backpack']")).click();
	}
	
	public static void clickAddToBag(WebDriver driver) {
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")).click();
	}
	
	public static void verifyFillBag(WebDriver driver) {
		Assert.assertTrue(driver.findElement(By.xpath("//a[.='Unisex Lunar Backpack']")).isDisplayed());
	}
	
}
