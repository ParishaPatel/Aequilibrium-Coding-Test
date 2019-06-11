package codingTest.AequSwagLab.Test;

import codingTest.AequSwagLab.Browser.Driver;
import codingTest.AequSwagLab.Report.ExtentReport;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterSuite;

public class TestSetup {
 //Initializes browser and reports
  @BeforeSuite
  public void beforeSuite() 
  {
	  ExtentReport.initialize();
	  
	  ExtentReport.logger= ExtentReport.report.startTest("Aequilibrium coding challenge");
	  //
	  

  }
//closed browser and report object
  @AfterSuite
  public void afterSuite() 
  {
	  Driver.quit();
	  ExtentReport.report.flush();
	  
  }

}

