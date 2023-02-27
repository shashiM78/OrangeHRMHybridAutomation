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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecuritmentPage {
	public static Properties prop;

	 public static WebDriver driver;
	 
	 
	
	 @BeforeMethod
		public void beforemethod() throws Exception {
		String Data = ".\\src\\main\\java\\com\\datapropertyfiles\\Recruitment.properties";
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
	public void validaterecruitmentWithValiddata() throws InterruptedException {
		driver.findElement(By.name(prop.getProperty("user"))).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.name(prop.getProperty("pwd1"))).sendKeys(prop.getProperty("Pwd"));
		driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("recuirtbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("Addbutton"))).click();
		driver.findElement(By.name(prop.getProperty("name1"))).sendKeys(prop.getProperty("firstNam"));
		driver.findElement(By.name(prop.getProperty("name2"))).sendKeys(prop.getProperty("middleNam"));
		driver.findElement(By.name(prop.getProperty("name3"))).sendKeys(prop.getProperty("lastNam"));
		
		WebElement Vacancy  = driver.findElement(By.xpath(prop.getProperty("RecuirtVacancy")));
		Vacancy.click();
		Actions actVacancy = new Actions(driver);
		actVacancy.sendKeys(Keys.ARROW_DOWN).build().perform();
	    Actions actVacancy2 = new Actions(driver);
	    actVacancy2.sendKeys(Keys.ENTER).build().perform();
	    Actions actVacancy3= new Actions(driver);
	    actVacancy3.moveToElement(Vacancy).build().perform();
        driver.findElement(By.xpath(prop.getProperty("mailxpath"))).sendKeys(prop.getProperty("maidId2"));
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(prop.getProperty("mobxpath"))).sendKeys(prop.getProperty("mobnumber"));
	    Thread.sleep(2000);
      WebElement Date = driver.findElement(By.xpath(prop.getProperty("recuritdate")));
	  Date.sendKeys("02/02/2023");
	  Actions actdate = new Actions(driver);
	  actdate.sendKeys(Keys.ARROW_DOWN).build().perform();
	  Actions actdate2 = new Actions(driver);
	  actdate2.sendKeys(Keys.ENTER).build().perform();
	  Actions actdate3= new Actions(driver);
	  actdate3.moveToElement(Date).build().perform();
	  //Thread.sleep(4000);
	//  driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
	 String excpect= prop.getProperty("expect");
	 String actual = driver.getCurrentUrl();
	 Assert.assertEquals(excpect, actual);
	 driver.quit();
	}
	@Test

	public void ValidateRecruitmentWithoutData() throws InterruptedException {
		driver.findElement(By.name(prop.getProperty("user"))).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.name(prop.getProperty("pwd1"))).sendKeys(prop.getProperty("Pwd"));
		driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("recuirtbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("Addbutton"))).click();
		driver.findElement(By.name(prop.getProperty("name1"))).sendKeys(prop.getProperty("  "));
		driver.findElement(By.name(prop.getProperty("name2"))).sendKeys(prop.getProperty("  "));
		driver.findElement(By.name(prop.getProperty("name3"))).sendKeys(prop.getProperty("lastNam"));
		
		WebElement Vacancy1 = driver.findElement(By.xpath(prop.getProperty("RecuirtVacancy")));
		Vacancy1.click();
		Actions actVacancy1 = new Actions(driver);
		actVacancy1.sendKeys(Keys.ARROW_DOWN).build().perform();
	 Actions actVacancy4 = new Actions(driver);
	 actVacancy4.sendKeys(Keys.ENTER).build().perform();
	 Actions actVacancy6= new Actions(driver);
	actVacancy6.moveToElement(Vacancy1).build().perform();

	 driver.findElement(By.xpath(prop.getProperty("mailxpath"))).sendKeys(prop.getProperty(" "));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("mobxpath"))).sendKeys(prop.getProperty("   "));
	Thread.sleep(2000);
	String excpect= prop.getProperty("expect");
	String actual = driver.getCurrentUrl();
	Assert.assertNotEquals(excpect, actual);
	driver.quit();
}
	@Test
	
	public void validateRecruitmentinvalidData() throws InterruptedException {
		driver.findElement(By.name(prop.getProperty("user"))).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.name(prop.getProperty("pwd1"))).sendKeys(prop.getProperty("Pwd"));
		driver.findElement(By.xpath(prop.getProperty("savebutton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("recuirtbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("Addbutton"))).click();
		driver.findElement(By.name(prop.getProperty("name1"))).sendKeys(prop.getProperty("invaliddata1"));
		driver.findElement(By.name(prop.getProperty("name2"))).sendKeys(prop.getProperty("invaliddata2"));
		driver.findElement(By.name(prop.getProperty("name3"))).sendKeys(prop.getProperty("invaliddata3"));
		
		WebElement Vacancy2 = driver.findElement(By.xpath(prop.getProperty("RecuirtVacancy")));
		Vacancy2.click();
		Actions actVacancy1 = new Actions(driver);
		actVacancy1.sendKeys(Keys.ARROW_DOWN).build().perform();
	 Actions actVacancy4 = new Actions(driver);
	 actVacancy4.sendKeys(Keys.ENTER).build().perform();
	 Actions actVacancy6= new Actions(driver);
	actVacancy6.moveToElement(Vacancy2).build().perform();
    driver.findElement(By.xpath(prop.getProperty("mailxpath"))).sendKeys(prop.getProperty("mailid"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("mobxpath"))).sendKeys(prop.getProperty("mobno"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
	String excpect= prop.getProperty("expect");
	String actual = driver.getCurrentUrl();
	Assert.assertNotEquals(excpect, actual);
	driver.quit();
	}
	
	public void aftermethod() {
		driver.quit();
	}
}
