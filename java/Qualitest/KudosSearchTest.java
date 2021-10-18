package Qualitest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.KudosSearch;
import pageObject.LoginPage;
import resources.Index;

public class KudosSearchTest extends Index {
	public WebDriver driver;
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
	public void Kudosearch() throws InterruptedException {
		KudosSearch obj4=new KudosSearch(driver);
		obj4.SearchKudos().click();
		Thread.sleep(2000);
		obj4.SearchBar().sendKeys("Amulya V Pujar  (amulya.pujar@qualitestgroup.com)");
		Thread.sleep(3000);
		obj4.SearchBtn().click();
		Thread.sleep(3000);
		
		
	}
	@AfterTest
	public void end()
	{
		driver.close();
	}

}
