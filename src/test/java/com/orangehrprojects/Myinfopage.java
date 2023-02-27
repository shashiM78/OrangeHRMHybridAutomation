package com.orangehrprojects;

import java.io.FileInputStream;
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

public class Myinfopage {
	public static Properties prop;

	 public static WebDriver driver;
	 
	 
	
	 @BeforeMethod
		public void beforemethod() throws Exception {
		 String Data = ".\\src\\main\\java\\com\\datapropertyfiles\\Myinfo.properties";
		 FileInputStream file = new FileInputStream(Data);
		 prop = new Properties();
		 prop.load(file);

		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
         driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get(prop.getProperty("url"));
	 }	 

	 @Test

	 public void validatemyinfovalidData() throws InterruptedException {
		 driver.findElement(By.name(prop.getProperty("user"))).sendKeys(prop.getProperty("uname"));
		 driver.findElement(By.name(prop.getProperty("pwd1"))).sendKeys(prop.getProperty("Pwd"));
		 driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(prop.getProperty("Myinfobutton"))).click();
		 WebElement  firstname = driver.findElement(By.name(prop.getProperty("name1")));
		 firstname.sendKeys(prop.getProperty("nam1"));
		 WebElement  middlename = driver.findElement(By.name(prop.getProperty("name2")));
		 middlename.sendKeys(prop.getProperty("nam2"));
		 WebElement  lastname = driver.findElement(By.name(prop.getProperty("name3")));
		 lastname.sendKeys(prop.getProperty("nam3"));
		 driver.findElement(By.xpath(prop.getProperty("EmplyId"))).sendKeys(prop.getProperty("empid"));
		 driver.findElement(By.xpath(prop.getProperty("Lience"))).sendKeys(prop.getProperty("licno"));
		 WebElement country = driver.findElement(By.xpath(prop.getProperty("count")));
		 country.sendKeys(prop.getProperty("countr"));
		 Thread.sleep(3000);
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
		 action3.moveToElement(country).click().perform();
		 driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
		 String actual3 = driver.getCurrentUrl();
		 String expect= prop.getProperty("expt");
		 Assert.assertEquals(actual3, expect);
		 driver.quit();

	 }

	 @Test

	 public void validatemyinfoinvalidData() throws InterruptedException {
		 driver.findElement(By.name(prop.getProperty("user"))).sendKeys(prop.getProperty("uname"));
		 driver.findElement(By.name(prop.getProperty("pwd1"))).sendKeys(prop.getProperty("Pwd"));
		 driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(prop.getProperty("Myinfobutton"))).click();
		 WebElement  firstname = driver.findElement(By.name(prop.getProperty("name1")));
		 firstname.sendKeys(prop.getProperty("nam1"));
		 WebElement  middlename = driver.findElement(By.name(prop.getProperty("name2")));
		 middlename.sendKeys(prop.getProperty("nam2"));
		 WebElement  lastname = driver.findElement(By.name(prop.getProperty("name3")));
		 lastname.sendKeys(prop.getProperty("nam3"));
		 driver.findElement(By.xpath(prop.getProperty("EmplyId"))).sendKeys(prop.getProperty("empid"));
		 driver.findElement(By.xpath(prop.getProperty("Lience"))).sendKeys(prop.getProperty("licno"));;
		 WebElement country = driver.findElement(By.xpath(prop.getProperty("count")));
		 country.sendKeys(prop.getProperty("count1"));
		 Thread.sleep(3000);
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
		 action3.moveToElement(country).click().perform();
		 driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
		 String actual3 = driver.getCurrentUrl();
		 String expect1=prop.getProperty("expt");
		 Assert.assertNotEquals(actual3, expect1);
		 driver.quit();
	 }
	 @AfterMethod
	 public void aftermethod() {
		 driver.quit();
	 }}
