**************************Aequilibrium coding challenge************************************

Important Points:
1. All test data required is placed in "TestRunDetails.properties" file which is available in resources
2. Path for browser is provided by OsPath.java class inside codingTest.AequSwagLab.Browser package.
3. This script is capable to execute in Image disable mode and Headless mode. However headless mode works only for Firefox Browser.
4. Browser, Headless mode or image disable mode can be on figured using "TestRunDetails.properties"
5. Please execute this program from testng.xml
6. Browser exe driver files are available in resources
7. Extent report is generated inside ExtentReports folder.Its is a kind of log file.
8. Capture the screen shot and store in FailedTestScrenShots folder.
7. I try to fetch data from Excel file for all Login Test (UserName , Password ) But not working . I need more time to fix this bug.
***************************Working of Program**********************************************************************
1. Open browser
2. Open www.saucedemo.com
3. Enter Username and Password dynamic and verify the login feature. 
4. If  test fail then capture the image and store in FailedTestsScreenshots.
5. Every time Browser close after test Pass.
6. When Test Fail, browser in not closing - It is bug i need more time to fix , I think i have to use Listner class to fix this error but today is last day to submit the test 


************************************About project and Structure********************************************************
1.src/main/java : contains all main functions
	PACKAGES, Class and Functions
	1.codingTest.AequSwagLab.Browse: this package contains class files for browser launch and configuration
		a.DisableImage.java: This class contains functions to disable browser image loading	
		b.Driver: This class contains function to launch browser and quit browser 
		c.HeadlessMode.java: This class will configure the browser to run in headless mode. it will work only with fire fox/
		d.OsPath.java: Determines the OS and provides browser path accordingly.
	2.codingTest.AequSwagLab.Report: This package contains class related to reports.
		a.ExtentReport.java: contains function to initialize report and set path and report name.
		b.Logstatus.java: contains function to log test steps.
		c.ScrrenShot.java: contains function to take screen shot.
	3.resource: Contains TestRunDetails.properties file, browser exe files and Extentreport File
	4.src/test/java: contains classes to test www.saucedemo.com website for challenge.
		a.LoginTest.java: contains Static DataProvide function , Main Test for open browser and get xpath of the username , password and pass the data from dataprovider. 
		b.TestSetup.java: contains function to initialize  report.
	5.ExtentReports:
		contains generated reports, naming is done on time at which test is run	
	6.FailedTestsScreenshots:
	    contains screenshot , naming is done on time at which test is run.
		
	