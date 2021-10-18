package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Index
{
	public WebDriver driver;//globally declaring WebDriver
	public Properties prop;//global declaration of properties
	public WebDriver initializeBrowser() throws IOException
	
	{
		
		prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\QTRecgnition\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browserName=prop.getProperty("browser");
		System.out.println( browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");

			 driver = new FirefoxDriver();
		}
		return driver;
	}
	public void getScreenShot(String textCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts= (TakesScreenshot)driver;
		
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+textCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	}
	

}

