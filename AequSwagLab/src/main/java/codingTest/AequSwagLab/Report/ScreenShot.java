package codingTest.AequSwagLab.Report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        // 
        	String dateName = new SimpleDateFormat("MMddyyyy_ hh_mm_ss").format(new Date());
        	TakesScreenshot ts = (TakesScreenshot) driver;
        	File source = ts.getScreenshotAs(OutputType.FILE);

        	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
        	File finalDestination = new File(destination);
        	FileUtils.copyFile(source, finalDestination);

        	return destination;
	}
}
