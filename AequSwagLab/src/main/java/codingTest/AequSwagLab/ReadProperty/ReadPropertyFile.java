package codingTest.AequSwagLab.ReadProperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	// This class is executed to read data from properties file
	public static String get(String PropertyName)
	{
		String returnProperty="";
		Properties property = new Properties();
		try {
			FileInputStream file =
					new FileInputStream(System.getProperty("user.dir")+"\\resources//TestRunDetails.properties");
			property.load(file);
			returnProperty=property.getProperty(PropertyName);
			if(returnProperty==null)
			{
				throw new Exception("Property with name : "+PropertyName+" not found in "+System.getProperty("user.dir")+"\\src//main//resources//TestRunDetails.properties Please check again");
			}
		
		} catch (FileNotFoundException e) {
			//throw an exception instead of displaying in the console
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//you should only catch specific exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
		return returnProperty;
	}
	
	

}
