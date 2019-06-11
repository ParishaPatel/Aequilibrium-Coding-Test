package codingTest.AequSwagLab.Browser;

public class OsPath {
	
	//Provide browser exe path based on OS
	public static String getPath(String browser) 
	{
		String OS=System.getProperty("os.name");
		String driverPath=null;
		if(OS.toUpperCase().contains("WINDOWS"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//resources//chromedriver.exe";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//resources//geckodriver.exe";
				
			}
		}
		else if(OS.toUpperCase().contains("MAC"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//resources//chromedriver";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//resources//geckodriver";
			}
		}
		return driverPath;
	}

	
}
