package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import resources.Index;
//code for validation of login page
public class LoginPage extends Index {
	public WebDriver driver;
	By username=By.name("username");
	By pass=By.name("pass");
	By loginbtn=By.cssSelector("button[type*='submit']");
	By color1=By.cssSelector("div.myHeading");
	By color2=By.cssSelector("div.container");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement username()
	{
		return driver.findElement(username);
	}
	public WebElement Password()
	{
		return driver.findElement(pass);
	}
	public WebElement LoginBtn()
	{
		return driver.findElement(loginbtn);
	}
	public String colorCheck()
	{
		String s= driver.findElement(color1).getCssValue("background-color");
		String hex=Color.fromString(s).asHex();
		
		if(hex.equalsIgnoreCase("#2A2559"))
		{
			System.out.println("Navy-"+hex);
		}
		else if(hex.equalsIgnoreCase("#fdcc16"))
		{
			System.out.println("Gold-"+hex);
		}
		else if(hex.equalsIgnoreCase("939598"))
		{
			System.out.println("White-"+hex);
		}
		else 
		{
			System.out.println("not qualitest approved color");
		}
		
		return hex;
	}
	public String colorCheck1()
	{
		String s= driver.findElement(loginbtn).getCssValue("background-color");
		String hex=Color.fromString(s).asHex();
		
		if(hex.equalsIgnoreCase("#2A2559"))
		{
			System.out.println("Navy-"+hex);
		}
		else if(hex.equalsIgnoreCase("#fdcc16"))
		{
			System.out.println("Gold-"+hex);
		}
		else if(hex.equalsIgnoreCase("939598"))
		{
			System.out.println("White-"+hex);
		}
		else 
		{
			System.out.println("not qualitest approved color");
		}
		
		return hex;
	}
	public String colorCheck2()
	{
		String hex= driver.findElement(loginbtn).getCssValue("color");
		
		if(hex.equalsIgnoreCase("white"))
		{
			System.out.println("White");
		}
		
		return hex;
	}
	public String title()
	{
		return driver.getTitle();
	}
	


}
