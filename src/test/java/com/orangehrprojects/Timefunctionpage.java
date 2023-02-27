package com.orangehrprojects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Timefunctionpage {
	
	public static Properties prop4;
    public static WebDriver driver;
    
    
	 @BeforeMethod
	 public void beforemethod() throws IOException  {
		 String Data6 = ".\\src\\main\\java\\com\\datapropertyfiles\\Time.properties";
		 FileInputStream file = new FileInputStream(Data6);
		 prop4 = new Properties();
		 prop4.load(file);
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get(prop4.getProperty("url"));

	 }	 	


	 @Test
	 public void validatetimeSheet() throws InterruptedException {
		 driver.findElement(By.name(prop4.getProperty("user"))).sendKeys(prop4.getProperty("uname"));
		 driver.findElement(By.name(prop4.getProperty("pwd1"))).sendKeys(prop4.getProperty("Pwd"));
		 driver.findElement(By.xpath(prop4.getProperty("savebutton.xpath"))).click();
		 driver.findElement(By.xpath(prop4.getProperty("addbutton"))).click();
		 String employname = prop4.getProperty("hint");
		 Thread.sleep(4000);
		 WebElement employeeNameBox = driver.findElement(By.xpath(prop4.getProperty("Employbox")));
		 employeeNameBox.sendKeys(employname);
		 Thread.sleep(9000);
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.ARROW_DOWN).build().perform();
		 Thread.sleep(3000);
		 Actions actionArrow1 = new Actions(driver);
		 actionArrow1.sendKeys(Keys.ARROW_DOWN).build().perform();
		 Thread.sleep(3000);
		 Actions action2 = new Actions(driver);
		 action2.sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(3000);
		 Actions action3= new Actions(driver);
		 action3.moveToElement(employeeNameBox).click().perform();
		 driver.findElement(By.xpath(prop4.getProperty("button2"))).click();
		 String Expt = prop4.getProperty("expected");
		 String actual = driver.getCurrentUrl();
		 Assert.assertNotEquals(actual, Expt);
		 driver.quit();
	 }
	 @Test
	 public void validatetimeSheetwithinvaliddata() throws InterruptedException {
		 driver.findElement(By.name(prop4.getProperty("user"))).sendKeys(prop4.getProperty("uname"));
		 driver.findElement(By.name(prop4.getProperty("pwd1"))).sendKeys(prop4.getProperty("Pwd"));
		 driver.findElement(By.xpath(prop4.getProperty("savebutton.xpath"))).click();
		 driver.findElement(By.xpath(prop4.getProperty("addbutton"))).click();
		 String employname = prop4.getProperty("hint1");
		 WebElement employeeNameBox = driver.findElement(By.xpath(prop4.getProperty("Employbox")));
		 employeeNameBox.sendKeys(employname);
		 Thread.sleep(9000);
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.ARROW_DOWN).build().perform();
		 Thread.sleep(3000);
		 Actions actionArrow1 = new Actions(driver);
		 actionArrow1.sendKeys(Keys.ARROW_DOWN).build().perform();
		 Thread.sleep(3000);
		 Actions action2 = new Actions(driver);
		 action2.sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(3000);
		 Actions action3= new Actions(driver);
		 action3.moveToElement(employeeNameBox).click().build().perform();
		 driver.findElement(By.xpath(prop4.getProperty("button2"))).click();
		 String Expt = prop4.getProperty("expected");
		 String actual = driver.getCurrentUrl();
		 Assert.assertNotEquals(actual, Expt);
		 driver.quit();
	 }

	 @AfterMethod
	 public void aftermethod() {
		 driver.quit();
	 }}




