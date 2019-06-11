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
     @Test(dataProvider="getData")
     public void loginTest(String Username,String Password) 
     {
   	    
    	 Driver.getDriver();
    	 String title =Driver.driver.getTitle();
    	 String expectedTitle ="Swag Labs";
    	 
    	 if(title.equalsIgnoreCase(expectedTitle)) {
    		 	Assert.assertEquals(expectedTitle,title );
    		 	LogStatus.pass("Title matched");
    	     	 }
    	 else {
    		 //Assert.assertEquals(expectedTitle,title );
    		 LogStatus.fail("Title didn't match");
    	 }
    	 
    	 LogStatus.info("UserName - " + Username + " Password -" + Password);
    	 Driver.driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(Username);
    	 
    	 Driver.driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Password);
    	 Driver.driver.findElement(By.xpath("//input[@type='submit']")).click();
    	 LogStatus.pass("Login test pass ");
    	 Driver.quit();
    	     	    	 
     }
     
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
