package codingTest.AequSwagLab.Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

//import codingTest.AequSwagLab.Listner.EventHandler;
import codingTest.AequSwagLab.ReadProperty.ReadPropertyFile;
import codingTest.AequSwagLab.Report.LogStatus;


public class Driver extends ReadPropertyFile
{
	//do not use a static driver
	//do not use null
	public static WebDriver driver=null;
	
	//getDriver() is way too long, consider breaking it in multiple smaller methods
	
	// Initializes browser based on inputs from properties file
	public static void getDriver ()
	{
		String browser=ReadPropertyFile.get("Browser");
		String headless=ReadPropertyFile.get("HeadlessMode");
		String imageDisable=ReadPropertyFile.get("DisableImage");
		
		//the second condition is useless, the first one is enough
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
		{
			try{
				
				System.setProperty("webdriver.chrome.driver",OsPath.getPath(browser));
				ChromeOptions options=new ChromeOptions();
				
				//no need for this argument, the session will be incognito by default
				options.addArguments("--incognito");
				
				//dont do this, it is not useful
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(options);
				}
				/*if(headless.equalsIgnoreCase("yes"))
				{
					new HeadlessMode().headless(options);
				}*/
				DesiredCapabilities capabilites=DesiredCapabilities.chrome();
				capabilites.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(options);
				
				LogStatus.pass("Chrome drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
								
			}
			catch (Exception e)
			{
				//if there is an exception, the execution should stop; logging info to console is not what you should do here
				e.printStackTrace();
			}
		}
		
		//same comments as above
		else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) 
		{
			try
			{
				
				System.setProperty("webdriver.gecko.driver",OsPath.getPath(browser));
				FirefoxOptions FFoptions=new FirefoxOptions();
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(FFoptions);
				}
				if(headless.equalsIgnoreCase("yes"))
				{
					new HeadlessMode().headless(FFoptions);
				}
				
				driver=new FirefoxDriver(FFoptions);
				
				
				LogStatus.pass("FF drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				LogStatus.fail(e);
			}
		}
		driver.manage().window().maximize();
		
		//implicit waits are a bad practice, if you need synchronization, use explicit waits and expected conditions
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(ReadPropertyFile.get("url"));
		
		//each session is clean, with no cookies persisted, no need to delete cookies
		driver.manage().deleteAllCookies();
	}
	
	//why the need to explain what it does? the method name and code are clear
	
	//quits browser
	public static void quit()
	{
		driver.quit();
	}
		
}
