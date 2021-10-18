package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Index;
//code to send kudos from recent contacts
public class RecentContacts extends Index{
	By Contactsend=By.xpath("//*[@id=\"contact_list\"]/div[2]/div/h5/small/a");
	By card=By.cssSelector("div.card-body.effect-body");
	By comment=By.id("comment");
	By sendBtn=By.xpath("//*[@id=\"myModal\"]/div/div/div/button[2]");
	

	
	public RecentContacts(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement Contact()
	{
		return driver.findElement(Contactsend);
	}
	public WebElement CardSelect()
	{
		
		
	List<WebElement> options=driver.findElements(card);
		WebElement option=options.get(4);
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
