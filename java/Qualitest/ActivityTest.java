package Qualitest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.ActivityPage;
import pageObject.LoginPage;
import resources.Index;

public class ActivityTest extends Index{
	public WebDriver driver;
	private static Logger log =	LogManager.getLogger(Index.class.getName());
	@BeforeTest
	public void beforeRun() throws IOException, InterruptedException
	{
		driver=initializeBrowser();
		driver.get("https://qtrecognition.testqtwiz.com/");
		LoginPage obj1=new LoginPage(driver);
		obj1.username().sendKeys("archana.praveen@qualitestgroup.com");
		obj1.Password().sendKeys("P@ssw0rd");
		obj1.LoginBtn().click();
		Thread.sleep(3000);
	}
	@Test
	public void TestCase2() throws IOException
	{
		ActivityPage obj2=new ActivityPage(driver);
		obj2.imageValidation();
		log.info("image validation");
		System.out.println(obj2.nameValidation());
		log.info("name validation");
		System.out.println("Page Title is : "+driver.getTitle());
	}
	@AfterTest
	public void end()
	{
		driver.close();
	}

}
