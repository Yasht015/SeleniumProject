package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
    public static String ReadPropertyFile(String value) throws IOException
    {
    	Properties prop=new Properties();
    	FileInputStream file=new FileInputStream("C:\\Users\\Sachin Todankar\\eclipse-workspace\\Selenium_28th_Batch\\TestData\\config.properties");
		prop.load(file);  
    	return prop.getProperty(value);
    }
    
	public static String readexcel(int rownum,int colnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Sachin Todankar\\eclipse-workspace\\Selenium_28th_Batch\\Testdata\\Book1.xlsx");
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet2");
		String value = es.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
		
	}
	
}
