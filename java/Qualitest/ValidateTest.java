package Qualitest;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import resources.Index;

public class ValidateTest extends Index {
	public WebDriver driver;
	private static Logger log =	LogManager.getLogger(Index.class.getName());
	@Test
	public void indexNavigation() throws IOException
	{
		driver=initializeBrowser();
		driver.get("https://qtrecognition.testqtwiz.com/");
		LoginPage obj1=new LoginPage(driver);
		obj1.username().sendKeys("archana.praveen@qualitestgroup.com");
		
		obj1.Password().sendKeys("P@ssw0rd");
		System.out.println("The title of the page is :"+obj1.title());
		obj1.LoginBtn();
		
		log.info("color validation");
		obj1.colorCheck1();
		obj1.colorCheck2();
		obj1.colorCheck();
		}
	
	@AfterTest
	public void end()
	{
		driver.close();
	}
}
