package Qualitest;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.KudosPage;
import pageObject.LoginPage;
import pageObject.RecentContacts;
import resources.Index;


public class kudosTest extends Index{
	
	public WebDriver driver;
	
	
	@Test(dataProvider="TestCase5")
	public void sendkudos(String email) throws InterruptedException, IOException
		{
		driver=initializeBrowser();
		driver.get("https://qtrecognition.testqtwiz.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;//typecasting driver to javascript
		js.executeScript("window.scroll(0,1000)");
		LoginPage obj1=new LoginPage(driver);
		obj1.username().sendKeys("archana.praveen@qualitestgroup.com");
		obj1.Password().sendKeys("P@ssw0rd");
		obj1.LoginBtn().click();
		KudosPage obj3=new KudosPage(driver);
		obj3.SendK().click();
			Thread.sleep(2000);
			obj3.Selection().sendKeys(email);
			obj3.Selection().click();
			Actions a = new Actions(driver);
			a.moveToElement(obj3.CardSelect()).click().build().perform();
			obj3.Citation().sendKeys("Great Work");
			obj3.sendButton().click();
			//Assert.assertFalse("user cannot send kudos to themselves", email.equalsIgnoreCase("archana.praveen@qualitestgroup.com"));
				
			
			
		}
	@AfterMethod
	public void end()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] TestCase5()
	{
		Object[][] obj=new Object[2][1];
		obj[0][0]="Amulya V Pujar  (amulya.pujar@qualitestgroup.com)";
		obj[1][0]="Archana Praveen  (archana.praveen@qualitestgroup.com)";
		return obj;
	}
	

}
