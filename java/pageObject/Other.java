package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Index;
//code to check if other features of the application work
public class Other extends Index{
	public WebDriver driver;
	By Kudosme=By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/h5/a/span");
	By Kudostome=By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[4]/div/h5/a/span");
	By count=By.id("todayCount");
	
	public Other(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement kudosFromMe()
	{
		return driver.findElement(Kudosme);
	}
	public WebElement kudosToMe()
	{
		return driver.findElement(Kudostome);
	}
	public WebElement kudosCount()
	{
		return driver.findElement(count);
	}

}
