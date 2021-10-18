package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//code to check if kusos can be sent
public class KudosPage {
	public WebDriver driver;
	public WebElement option;
	
	By send=By.cssSelector("a[href*='#myModal']");
	By sel=By.id("email_address");
	By card=By.cssSelector("div.card-body.effect-body");
	By comment=By.id("comment");
	By sendBtn=By.cssSelector("button.btn.btn-primary");
	
	public KudosPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement SendK()
	{
		return driver.findElement(send);
	}
	public WebElement Selection()
	{
		return driver.findElement(sel);
	}
	
	public WebElement CardSelect()
	{
		
		
	List<WebElement> options=driver.findElements(card);
		
		WebElement option=options.get(5);
		return option;
	}
	public WebElement Citation()
	{
		return driver.findElement(comment);
	}
	public WebElement sendButton()
	{
		return driver.findElement(sendBtn);
	}
		
	
	
}
