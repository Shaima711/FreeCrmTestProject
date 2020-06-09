package com.freecrm.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ViewLinksTest {
	WebDriver driver;
	@Parameters({"URL"})

	@BeforeMethod
	
	public void Login (String URL) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\chromedriver_win32 (4)\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	    WebElement UserName = driver.findElement(By.name("login"));
	    WebElement PassWord = driver.findElement(By.name("password"));
	    UserName.sendKeys("shkelany711@yahoo.com");
	    PassWord.sendKeys("Testing11");
	   
	    WebElement LoginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
	    LoginButton.click();
	    
	    WebElement CRMicon = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/a[4]/div[1]"));
	    CRMicon.click();
	    
	    WebElement createbutton = driver.findElement(By.xpath("//button[@class='btn btn-primary o-kanban-button-new']"));
		createbutton.click();
	}
	@Test ( groups= {"Sanity"})
	public void checkviewsbuttons () throws InterruptedException, IOException
	{

		
		Actions action1 =  new Actions(driver);
	
	WebElement ViewKanbenButton = driver.findElement(By.xpath("//nav[contains(@class,'btn-group o_cp_switch_buttons')]//button[contains(@class,'active')]"));
    action1.moveToElement(ViewKanbenButton).doubleClick(ViewKanbenButton).build().perform();

	Thread.sleep(3000);

	WebElement viewListButton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/nav[2]/button[2]"));
    action1.moveToElement(viewListButton).doubleClick(viewListButton).build().perform();
    Thread.sleep(3000);

	WebElement viewCalendar = driver.findElement(By.cssSelector("button[aria-label='View calendar']"));
    action1.moveToElement(viewCalendar).doubleClick().build().perform();
	Thread.sleep(3000);

	WebElement viewgraph = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/nav[2]/button[5]"));
    action1.moveToElement(viewgraph).doubleClick().build().perform();
	Thread.sleep(3000);
    
	
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\eclipse-workspace\\New_TestNG_Project\\Snapshots\\Views.png"));

	}

	
}
