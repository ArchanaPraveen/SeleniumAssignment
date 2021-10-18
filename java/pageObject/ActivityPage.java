package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.Index;

public class ActivityPage extends Index {
	//code to check if image and name of the user is displayed
	public WebDriver driver;
	By name=By.className("header-font-size");
	By image=By.xpath("//img[@alt='Sample Image']");
	
	
	public ActivityPage(WebDriver driver) {
		this.driver=driver;
	}


	public boolean nameValidation()
	{
		return driver.findElement(name).isDisplayed();//checking if the name is displayed
	}
	public String imageValidation()
	{
		String a=driver.findElement(image).getAttribute("alt");
		if(a.equalsIgnoreCase("Sample Image"))//check if image is uploaded or not
		{
			System.out.println("image not uploaded");
		}
		else
		{
			System.out.println("image uploaded");
		}
		return a;
	}

}
