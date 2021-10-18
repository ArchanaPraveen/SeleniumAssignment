package Qualitest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.Other;
import pageObject.RecentContacts;
import resources.Index;

public class OtherTest extends Index{
	private static Logger log =	LogManager.getLogger(Index.class.getName());
	@BeforeTest
	public void beforeRun() throws IOException, InterruptedException
	{
		driver=initializeBrowser();
		driver.get("https://qtrecognition.testqtwiz.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;//typecasting driver to javascript
		js.executeScript("window.scroll(0,1000)");
		LoginPage obj1=new LoginPage(driver);
		obj1.username().sendKeys("archana.praveen@qualitestgroup.com");
		obj1.Password().sendKeys("P@ssw0rd");
		obj1.LoginBtn().click();
		Thread.sleep(3000);
	}
	@Test
	public void TestCase4() throws InterruptedException
	{
		
		Other obj5=new Other(driver);
		
		obj5.kudosFromMe().click();
		Thread.sleep(2000);
		obj5.kudosToMe().click();
		Thread.sleep(3000);
		System.out.println(obj5.kudosCount().getText());
		RecentContacts obj6=new RecentContacts(driver);
		obj6.Contact().click();
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		//a.moveToElement(obj6.CardSelect()).click().build().perform();
		obj6.Citation().sendKeys("Great Work");
		obj6.sendButton().click();
		Thread.sleep(4000);
		System.out.println(obj6.driver.findElement(By.xpath("//*[@id=\'display_message\']/span/center")).getText());//if card not selected
		
		
		
	}
	@AfterTest
	public void end()
	{
		driver.close();
	}
}
