package com.orangehrprojects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PimPage {
	public static Properties prop3;
	public static WebDriver driver;
	
@org.testng.annotations.BeforeMethod
public void beforeMethod() throws IOException {

	String Data3 = ".\\src\\main\\java\\com\\datapropertyfiles\\Pimpage.properties";
	FileInputStream file1 = new FileInputStream(Data3);
	prop3 = new Properties();
	prop3.load(file1);
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(prop3.getProperty("url"));
}

@Test(priority = 1)
public void validatepimWithvalidname() {
	driver.findElement(By.name(prop3.getProperty("user"))).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name(prop3.getProperty("pwd1"))).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name(prop3.getProperty("name1"))).sendKeys(prop3.getProperty("nam1"));
	driver.findElement(By.name(prop3.getProperty("name2"))).sendKeys(prop3.getProperty("nam2"));
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys(prop3.getProperty("empid"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
	String actual = prop3.getProperty("actual");
	String expected = prop3.getProperty("Expect");
	Assert.assertNotEquals(actual, expected);
	driver.quit();

}
@Test(priority = 2)
public void validatepimWithinvalidname() {
	driver.findElement(By.name(prop3.getProperty("user"))).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name(prop3.getProperty("pwd1"))).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name(prop3.getProperty("name1"))).sendKeys(prop3.getProperty("nam3"));
	driver.findElement(By.name(prop3.getProperty("name2"))).sendKeys(prop3.getProperty("nam4"));
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys(prop3.getProperty("empid"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
	String actual = prop3.getProperty("actual");
	String expected = prop3.getProperty("Expect");
	Assert.assertNotEquals(actual, expected);
	driver.quit();

}
@Test(priority = 3)
public void validatepimwithoutfirstname() {
	driver.findElement(By.name(prop3.getProperty("user"))).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name(prop3.getProperty("pwd1"))).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name(prop3.getProperty("name1"))).sendKeys(prop3.getProperty(" "));
	driver.findElement(By.name(prop3.getProperty("name2"))).sendKeys(prop3.getProperty("nam4"));
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys(prop3.getProperty("empid"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
	String actual = driver.getCurrentUrl();
	String expected = prop3.getProperty("Expect");
	Assert.assertEquals(actual, expected);
	driver.quit();
}
@Test(priority = 4)
public void validatepimWithoutname() {
	driver.findElement(By.name(prop3.getProperty("user"))).sendKeys(prop3.getProperty("uname"));
	driver.findElement(By.name(prop3.getProperty("pwd1"))).sendKeys(prop3.getProperty("Pwd"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton.xpath"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimbutton"))).click();
	driver.findElement(By.xpath(prop3.getProperty("Pimadduser"))).click();
	driver.findElement(By.name(prop3.getProperty("name1"))).sendKeys(prop3.getProperty(" "));
	driver.findElement(By.name(prop3.getProperty("name2"))).sendKeys(prop3.getProperty("  "));
	driver.findElement(By.xpath(prop3.getProperty("Employeeid"))).sendKeys(prop3.getProperty("empid"));
	driver.findElement(By.xpath(prop3.getProperty("savebutton"))).click();
	String actual = driver.getCurrentUrl();
	String expected = prop3.getProperty("Expect");
	Assert.assertNotEquals(actual, expected);
	driver.quit();
}

@AfterMethod
public void aftermethod() {
	driver.quit();
}}
