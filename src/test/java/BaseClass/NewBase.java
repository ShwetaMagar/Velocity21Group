package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import PomClass.UtilityNew;




public class NewBase {

	protected WebDriver driver;
	public void launchBrowser() throws IOException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Documents\\selenium\\chromedriver_win32\\chromedriver_win32 (1)\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(UtilityNew.readDataFromProprtyFile("URL"));
	driver.manage().window().maximize();
	Reporter.log("Launching browser",true);
	UtilityNew.wait(driver, 1000);
	}
	
	
	
	
	
	
	public static void closingBrowser(WebDriver driver) throws 
	InterruptedException
	{
	Reporter.log("closing browser", true);
	Thread.sleep(500);
	driver.close();
	}
}
