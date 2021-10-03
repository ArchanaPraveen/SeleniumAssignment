import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationDriver {
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");// invoke .exe file

		WebDriver driver = new ChromeDriver();// web driver object creation
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");// url to test
		driver.manage().window().maximize();
		exercise1(driver);
		exercise2(driver);
		exercise3(driver);
		exercise4(driver);
		exercise5(driver);
		exercise6(driver);
		exercise7(driver);
		exercise8(driver);
		exercise9(driver);
	}
	public static void exercise1(WebDriver driver)
	{
		
		WebElement radio1 = driver.findElement(By.cssSelector("input[value='radio1'"));
		radio1.click();
		System.out.println(radio1.isSelected());// to verify if Radio1 is selected
		WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2'"));
		radio2.click();
		System.out.println(radio2.isSelected());// to verify if Radio2 is selected
		WebElement radio3 = driver.findElement(By.cssSelector("input[value='radio3'"));
		radio3.click();
		System.out.println(radio3.isSelected());// to verify if Radio3 is selected
	}
	public static void exercise2(WebDriver driver)
	{
	    driver.findElement(By.id("autocomplete")).sendKeys("United States");
	 try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//selecting all the options and storing it in a webelement options
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		  
		
		for(WebElement option : options)//for each loop iterate through each options 
		{
			
			//checking if the selected option is same as entered string
			if(option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))
			{
				option.click();//if the condition is true click on the option
				break;
			}
		}

	}
	public static void exercise3(WebDriver driver)
	{
		WebElement staticDropdown=driver.findElement(By.id("dropdown-class-example"));
		staticDropdown.click();
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByIndex(1);//selection of option based on index
		System.out.println(dropdown.getFirstSelectedOption().getText());//print the selected option
		dropdown.selectByIndex(2);//selection of option based on index
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(3);//selection of option based on index
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
	}
	
	public static void exercise4(WebDriver driver)
	{
		
		WebElement check1=driver.findElement(By.id("checkBoxOption1"));
		check1.click();
		check1.click();
		WebElement check2=driver.findElement(By.id("checkBoxOption2"));
		check2.click();
		check2.click();
		WebElement check3=driver.findElement(By.id("checkBoxOption3"));
		check3.click();
		check3.click();
		
	}
	public static void exercise5(WebDriver driver)
	{
		//Selection of checkboxes
		WebElement check1=driver.findElement(By.id("checkBoxOption1"));
		check1.click();
		WebElement check2=driver.findElement(By.id("checkBoxOption2"));
		check2.click();
		WebElement check3=driver.findElement(By.id("checkBoxOption3"));
		check3.click();
		//deselection of the selected checkboxes
		check1.click();
		check2.click();
		check3.click();
	}
	public static void exercise6(WebDriver driver)
	{
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();//iterates through multiple windows
		String ParentId=it.next();
		String ChildId=it.next();
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		driver.switchTo().window(ChildId).close();//switching from parent to child window
		driver.switchTo().window(ParentId);
		
	}
	public static void exercise7(WebDriver driver)
	{
		driver.findElement(By.id("name")).sendKeys("john");
		
		WebDriverWait w =new WebDriverWait(driver,5);
		//explicit wait
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertbtn"))).click();
		driver.switchTo().alert();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().dismiss();//switching to alert 
		
	}
	public static void exercise8(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;//typecasting driver to javascript
		js.executeScript("window.scroll(0,660)");//scroll the window down to display table
		String before="//*[@id=\"product\"]/tbody/tr[";//xpath pattern to print elements of each rows
		String after="]";//xpath pattern to print elements of each rows
		for(int i=1;i<=11;i++)
		{
			String Actualpath=before+i+after;
			WebElement element=driver.findElement(By.xpath(Actualpath));
			
			if(element.equals(null))
			{
				System.out.println("No element printed");//if the row is empty
			}
			else
			{
				System.out.println(element.getText());//print all the elements of the row
			}
		}
		
	}
	public static void exercise9(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;//typecasting driver to javascript
		js.executeScript("window.scroll(0,900)");//scroll the window down to display table
		Actions a = new Actions(driver);//creating object for action
		WebElement w=driver.findElement(By.id("mousehover"));
		a.moveToElement(w).build().perform();//moving the element
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		a.click(driver.findElement(By.xpath("//a[text()='Top']"))).build().perform();//click the option based on the xpath
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();//closes the window
		
		
	}

	


}
