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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminPage {
	public static Properties prop2;
	public static WebDriver driver;
	
@org.testng.annotations.BeforeMethod
public void BeforeMethod() throws IOException {

	String Data2 = ".\\src\\main\\java\\com\\datapropertyfiles\\Adminpage.properties";
	FileInputStream file1 = new FileInputStream(Data2);
	prop2 = new Properties();
	prop2.load(file1);
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(prop2.getProperty("url"));
}

@Test
public void validateAdminadduser() throws InterruptedException {
	driver.findElement(By.name(prop2.getProperty("user"))).sendKeys(prop2.getProperty("uname"));
	driver.findElement(By.name(prop2.getProperty("pwd1"))).sendKeys(prop2.getProperty("Pwd"));
	driver.findElement(By.xpath(prop2.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop2.getProperty("Adminbutton"))).click();
	driver.findElement(By.xpath(prop2.getProperty("Addbutton"))).click();
    WebElement role = driver.findElement(By.xpath(prop2.getProperty("role1")));
	role.click();
    Actions actadmin = new Actions(driver);
	actadmin.sendKeys(Keys.ARROW_DOWN).build().perform();
	Actions actadmin1 = new Actions(driver);
	actadmin1.sendKeys(Keys.ENTER).build().perform();
	Actions actadmin2 = new Actions(driver);
	actadmin2.moveToElement(role).click().build().perform();
	Thread.sleep(2000);
	WebElement Employeename =	driver.findElement(By.xpath(prop2.getProperty("employeename")));
	Thread.sleep(3000);
	Employeename.sendKeys("Pe");
	Thread.sleep(9000);
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ARROW_DOWN).build().perform();
	Thread.sleep(3000);
	Actions actionArrow1 = new Actions(driver);
	actionArrow1.sendKeys(Keys.ARROW_DOWN).build().perform();
	Actions actionArrow2 = new Actions(driver);
	actionArrow2.sendKeys(Keys.ARROW_DOWN).build().perform();
	Thread.sleep(3000);
	Actions action2 = new Actions(driver);
	action2.sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(3000);
	Actions action3= new Actions(driver);
	action3.moveToElement(Employeename).click().perform();
    WebElement Status =	driver.findElement(By.xpath(prop2.getProperty("Statusadmin")));
	Status.click();
	Actions actStatus = new Actions(driver);
	actStatus.sendKeys(Keys.ARROW_DOWN).build().perform();
	Actions actStatus1 = new Actions(driver);
	actStatus1.sendKeys(Keys.ENTER).build().perform();
	Actions actStatus2 = new Actions(driver);
	actStatus2.moveToElement(Status).click().build().perform();
	Thread.sleep(3000);
    driver.findElement(By.xpath(prop2.getProperty("unamee"))).sendKeys(prop2.getProperty("username"));
	driver.findElement(By.xpath(prop2.getProperty("unameepwd1"))).sendKeys(prop2.getProperty("userpwd"));
	driver.findElement(By.xpath(prop2.getProperty("unameconfirmpwd1"))).sendKeys(prop2.getProperty("confirmpwd"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop2.getProperty("savebutton1"))).click();
	String actual = driver.getCurrentUrl();
	String expect1= prop2.getProperty("expected1");
	Assert.assertEquals(actual, expect1);
    driver.quit();
}


@Test

public void validateadminAdduserwithinvalidData() throws InterruptedException {
	driver.findElement(By.name(prop2.getProperty("user"))).sendKeys(prop2.getProperty("uname"));
	driver.findElement(By.name(prop2.getProperty("pwd1"))).sendKeys(prop2.getProperty("Pwd"));
	driver.findElement(By.xpath(prop2.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop2.getProperty("Adminbutton"))).click();
	driver.findElement(By.xpath(prop2.getProperty("Addbutton"))).click();
    WebElement role = driver.findElement(By.xpath(prop2.getProperty("role1")));
	role.click();
    Actions actadmin = new Actions(driver);
	actadmin.sendKeys(Keys.ARROW_DOWN).build().perform();
	Actions actadmin1 = new Actions(driver);
	actadmin1.sendKeys(Keys.ENTER).build().perform();
	Actions actadmin2 = new Actions(driver);
	actadmin2.moveToElement(role).click().build().perform();
	Thread.sleep(2000);
    WebElement Employeename =	driver.findElement(By.xpath(prop2.getProperty("employeename")));
	Thread.sleep(3000);
	Employeename.sendKeys("Pe");
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
	action3.moveToElement(Employeename).click().perform();
    WebElement Status =	driver.findElement(By.xpath(prop2.getProperty("Statusadmin")));
	Status.click();
	Actions actStatus = new Actions(driver);
	actStatus.sendKeys(Keys.ARROW_DOWN).build().perform();
	Actions actStatus1 = new Actions(driver);
	actStatus1.sendKeys(Keys.ENTER).build().perform();
	Actions actStatus2 = new Actions(driver);
	actStatus2.moveToElement(Status).click().build().perform();
	Thread.sleep(3000);
    driver.findElement(By.xpath(prop2.getProperty("unamee"))).sendKeys(prop2.getProperty("invaliduser"));
	driver.findElement(By.xpath(prop2.getProperty("unameepwd1"))).sendKeys(prop2.getProperty("invalidPwd"));
	driver.findElement(By.xpath(prop2.getProperty("unameconfirmpwd1"))).sendKeys(prop2.getProperty("invalidPwd"));
	driver.findElement(By.xpath(prop2.getProperty("savebutton1"))).click();
	String actual = driver.getCurrentUrl();
	String expect1= prop2.getProperty("expected1");
	Assert.assertNotEquals(actual, expect1);

	driver.quit();
} 

public void afterMethod() {
	driver.quit();
}}


