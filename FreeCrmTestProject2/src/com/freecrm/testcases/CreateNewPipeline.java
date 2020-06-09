package com.freecrm.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;




@Test (priority=1, groups= {"E2E"})
public class CreateNewPipeline {
	
	WebDriver driver;
	

	@BeforeMethod
	

	public void Login ( ) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\chromedriver_win32 (4)\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://itss1.odoo.com/web/login");
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
	@AfterMethod
	public void TearDown ()
 
{
		driver.quit();
}
	
public void checkcreatebutton ()
{
	

WebElement createbutton = driver.findElement(By.xpath("//button[@class='btn btn-primary o-kanban-button-new']"));
createbutton.click();

WebElement htmltable=driver.findElement(By.xpath("//table[@class='o_group o_inner_group']//tbody"));
List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
 System.out.println("No of rows = "+rows.size());

 WebElement SecondRow = htmltable.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"));
System.out.println("found");

WebElement TextboxSecondRow = SecondRow.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
System.out.println("foundText");
TextboxSecondRow.sendKeys("Presentation");

WebElement ThirdRow = htmltable.findElement(By.xpath("//table[@class='o_group o_inner_group']"));
ThirdRow.click();

WebElement SelectText =ThirdRow.findElement(By.xpath("/html[1]/body[1]/ul[2]/li[1]/a[1]"));
SelectText.click();

WebElement ForthRow =htmltable.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]"));
System.out.println("found row");

WebElement TextboxForthRow = ForthRow.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/input[1]"));
TextboxForthRow.click();
TextboxForthRow.clear();
TextboxForthRow.sendKeys("1000000");
WebElement AddButton = driver.findElement(By.xpath("//div[@class='o_kanban_quick_create']//div//button[@class='btn btn-primary o_kanban_add'][contains(text(),'Add')]"));
AddButton.click();

}
@Test  (priority=2, groups= {"E2E"})
public void checkDiscardbutton ()
{
	
	WebElement Discardbutton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[3]"));
	Discardbutton.click();
	

}
@Test (priority=3, groups= {"Regression"})
public void checkmandatoryfieldsalertmessages() throws InterruptedException, IOException 
{
	WebElement AddButton = driver.findElement(By.xpath("//div[@class='o_kanban_quick_create']//div//button[@class='btn btn-primary o_kanban_add'][contains(text(),'Add')]"));
	AddButton.click();
    String ExpectedResult = "The following fields are invalid:";
    String ActualResult = driver.findElement(By.xpath("//div[@class='d-flex align-items-center mr-auto font-weight-bold o_notification_title']")).getText();
  Thread.sleep(3000);
    //String ActualResult = AlertMessage.getAttribute("Message");

    assertEquals(ActualResult, ExpectedResult);
    
    File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\eclipse-workspace\\New_TestNG_Project\\Snapshots\\ErrortMessage.png"));
    
    
}
}
