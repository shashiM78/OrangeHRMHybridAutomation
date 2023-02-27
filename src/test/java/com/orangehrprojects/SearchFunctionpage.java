package com.orangehrprojects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFunctionpage {
	public static Properties prop4;

	 public static WebDriver driver;
	 
	 
	
	 @BeforeMethod
		public void beforemethod() throws Exception {
		 String Data = ".\\src\\main\\java\\com\\datapropertyfiles\\Searchfunction.properties";
		 FileInputStream file = new FileInputStream(Data);
		 prop4 = new Properties();
		 prop4.load(file);

		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get(prop4.getProperty("url"));
	 }	      



	 @Test(priority = 1)
	 public void searchFunctionwithvalidData() throws InterruptedException {
		 driver.findElement(By.name(prop4.getProperty("user"))).sendKeys(prop4.getProperty("uname"));
		 driver.findElement(By.name(prop4.getProperty("pwd1"))).sendKeys(prop4.getProperty("Pwd"));

		 driver.findElement(By.xpath(prop4.getProperty("savebutton.xpath"))).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(prop4.getProperty("feature"))).sendKeys(prop4.getProperty("searchfeature"));
		 driver.findElement(By.xpath(prop4.getProperty("Button"))).click();
		 String actual = driver.getCurrentUrl();
		 String expected = prop4.getProperty("expturl");
		 Assert.assertEquals(actual, expected);
		 driver.quit();

	 }



	 @Test(priority = 2)
	 public void searchFunctionwithInavalidData() throws InterruptedException {
		 driver.findElement(By.name(prop4.getProperty("user"))).sendKeys(prop4.getProperty("uname"));
		 driver.findElement(By.name(prop4.getProperty("pwd1"))).sendKeys(prop4.getProperty("Pwd"));
		 driver.findElement(By.xpath(prop4.getProperty("savebutton.xpath"))).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(prop4.getProperty("feature"))).sendKeys(prop4.getProperty("searchfeature2"));
		 driver.findElement(By.xpath(prop4.getProperty("Button"))).click();
		 String actual = driver.getCurrentUrl();
		 String expected = prop4.getProperty("expturl");
		 Assert.assertEquals(actual, expected);
		 driver.quit();

	 }
	 @Test(priority = 3)
	 public void searchFunctionwithoutData() throws InterruptedException {
		 driver.findElement(By.name(prop4.getProperty("user"))).sendKeys(prop4.getProperty("uname"));
		 driver.findElement(By.name(prop4.getProperty("pwd1"))).sendKeys(prop4.getProperty("Pwd"));
		 driver.findElement(By.xpath(prop4.getProperty("savebutton.xpath"))).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(prop4.getProperty("feature"))).sendKeys(prop4.getProperty("  "));
		 driver.findElement(By.xpath(prop4.getProperty("Button"))).click();
		 String actual = driver.getCurrentUrl();
		 String expected = prop4.getProperty("expturl");
		 Assert.assertEquals(actual, expected);
		 driver.quit();

	 }
	 @org.testng.annotations.AfterMethod
	 public void AfterMethod() {
		 driver.quit();

	 }
}



