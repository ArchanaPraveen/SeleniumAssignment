package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Index;
//code to search kudos
public class KudosSearch extends Index {
	public WebDriver driver;
	By search=By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[5]/div/h5/a/span");
	By searchBar=By.cssSelector("input.form-control");
	By searchBtn1=By.cssSelector("button.btn.btn-primary");

	
	
	public KudosSearch(WebDriver driver) {
		this.driver=driver;
	}



	public WebElement SearchKudos()
	{
		return driver.findElement(search);
	}
	public WebElement SearchBar()
	{
		return driver.findElement(searchBar);
	}
	public WebElement SearchBtn()
	{
		return driver.findElement(searchBtn1);
	}
}
