package codingTest.AequSwagLab.Test;
import java.io.IOException;


//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import codingTest.AequSwagLab.Browser.Driver;
import codingTest.AequSwagLab.Report.LogStatus;
import codingTest.AequSwagLab.Report.ScreenShot;

public class LoginTest {

	//you should remove all comments
	//having comments in your code is not a good thing for an interview test
	
	
//	public static XSSFWorkbook workbook;
//    public static XSSFSheet worksheet;
//    public static DataFormatter formatter= new DataFormatter();
//    public static String file_location = System.getProperty("user.dir")+"\\src//main//java//resources//Data.xlsx";
//    static String SheetName= "LoginData";
     /*@BeoreTest
     public void initialize()
     {

    	 Driver.initialize();

     }*/
	
     //a good test does not include any WebDriver objects and WebDriver methods
     //instead, it uses page objects
     //i do not see any page objects here
     @Test(dataProvider="getData")
     public void loginTest(String Username,String Password) 
     {
   
	 //there is no need to use a static getDriver() method
	//there are ways of not using static methods  
    	 Driver.getDriver();
    	 String title =Driver.driver.getTitle();
    	 String expectedTitle ="Swag Labs";
    	 
	 //if the page is very slow, this way of checking if the page title is correct will fail
	 //you should use expected conditions and explicit waits for the same purpose
    	 if(title.equalsIgnoreCase(expectedTitle)) {
    		 	Assert.assertEquals(expectedTitle,title );
		 	//if the assertion fails, the next line is not executed
		 	//it is better to add an error message to the assertEquals assertion
    		 	LogStatus.pass("Title matched");
    	     	 }
    	 else {
    		 //Assert.assertEquals(expectedTitle,title );
    		 LogStatus.fail("Title didn't match");
    	 }
    	 
	    
    	 LogStatus.info("UserName - " + Username + " Password -" + Password);
    	 
	 //you are executing repeatedly Driver.driver; why not save this in a variable?
	 //a locator that uses * is a bad one; the element has a tag so use it; in this case you should use By.id
	 Driver.driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(Username);
    	 
	 //use By.id instead of By.xpath
    	 Driver.driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Password);
    	 
	 Driver.driver.findElement(By.xpath("//input[@type='submit']")).click();
    	 
	 //where is the final assertion? how do you know that the test passed?    
	 LogStatus.pass("Login test pass ");
	     
	 //driver.quit() should be in the @AfterMethod, not in the test 
    	 Driver.quit();
    	     	    	 
     }
     
     //there are much better ways of doing this using TestNG listeners
     @AfterMethod
     public void getResult(ITestResult result) throws IOException
     {
         if(result.getStatus() == ITestResult.FAILURE)
         {
             String screenShotPath;
			try {
				screenShotPath = ScreenShot.getScreenshot(Driver.driver, "LoginTest");
				LogStatus.fail("Login Test Failed");
	             LogStatus.fail( "Snapshot below: " + screenShotPath);
	      
			} catch (Exception e) {

				e.printStackTrace();
			}
                }

         
     }
      
     
     @AfterTest
     public void Quit()
     {
    	 	Driver.quit();
 

     }

     
     
	@DataProvider(name="getData")
    public Object[][] myDataProvider() {
    
    	
	Object[][] obj= new Object[8][2];
    	
    	obj[0][0]="standard_user";
    	obj[0][1]="secret_sauce";
    	
    	
    	obj[1][0]="standard_user";
    	obj[1][1]=" ";
    	
    	
    	obj[2][0]="standard_user";
    	obj[2][1]=" abd";
    	
    	
    	obj[3][0]="locked_out_user";
    	obj[3][1]="secret_sauce";
    	
    	
    	obj[4][0]="problem_user";
    	obj[4][1]="secret_sauce";
    	
    	
    	obj[5][0]="performance_glitch_user";
    	obj[5][1]="secret_sauce";
    	
    	
    	obj[6][0]=" ";
    	obj[6][1]="secret_sauce";
    	
    	
    	obj[7][0]=" ";
    	obj[7][1]=" ";
    	
    	return obj;
    	
    	
    	   	
    }
	
	/* Read Data From Excel and convert in object[][] 
	 * It is giving error so need more time to clear the bug.  
	@DataProvider(name="getData")
    public static Object[][] GetLoginData() throws IOException
    {
    FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                XSSFRow row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }
 
        return Data;
    } */

    
    
	
}
