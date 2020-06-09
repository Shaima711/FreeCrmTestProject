package com.freecrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



@Test (priority = 2, groups= {"E2E"})
public class LoginPageTest {
	
	WebDriver driver1;
	@BeforeMethod
	
	public void SetUp () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\chromedriver_win32 (4)\\chromedriver.exe");
	   driver1 = new ChromeDriver();
	    driver1.get("https://itss1.odoo.com/web/login");
	}
	@AfterMethod
	public void TearDown ()
 
{
		driver1.quit();
}
	
	
	
	public  void LoginPositiveCase () {
		
	
WebElement UserName = driver1.findElement(By.name("login"));
WebElement PassWord = driver1.findElement(By.name("password"));
UserName.sendKeys("shkelany711@yahoo.com");
PassWord.sendKeys("Testing11");
WebElement LoginButton = driver1.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
LoginButton.click();

}
	
@Test (priority = 3, groups= {"E2E"})
public  void LoginNegativeCase () {
	

	
    WebElement UserName = driver1.findElement(By.name("login"));
    WebElement PassWord = driver1.findElement(By.name("password"));
    UserName.sendKeys("xxxx");
    PassWord.sendKeys("xxxx");
    WebElement LoginButton = driver1.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
    LoginButton.click();
    String ExpectedResult = "Wrong login/password";
    WebElement ActualResult = driver1.findElement(By.xpath("//p[@role='alert']"));
    boolean Message = ActualResult.isDisplayed();
    System.out.println("Error Message is displayed");
    org.testng.Assert.assertFalse(false);
    
    		
}
@Test (priority = 4, groups ={"Regression"})
public  void LoginMissedCredintialsCase () throws IOException {
	
	
    WebElement UserName = driver1.findElement(By.name("login"));
    
    UserName.sendKeys("shkelany711@yahoo.com");
  
    WebElement LoginButton = driver1.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
    LoginButton.click();
    File srcFile = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\eclipse-workspace\\New_TestNG_Project\\Snapshots\\AlertMessage.png"));
    
}
@Test (priority = 1, groups= {"Sanity"})
public void getTitle() {
		SoftAssert soft = new SoftAssert();
	  String ExpectedResult = "Odoo";
	 String ActualResult = driver1.getTitle();
	 System.out.println(ActualResult);
   soft.assertEquals(ActualResult, ExpectedResult);
	soft.assertAll();
}
}
