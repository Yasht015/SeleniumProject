package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginPage_Test extends TestBase 
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
        login=new LoginPage();
		
	}
	
	@Test (priority = 1,enabled=true,groups="Sanity")
	public void VerifyTitleOfApplication() throws EncryptedDocumentException, IOException
	{
		
		String ExpTitle=ReadData.readexcel(0, 0);//Swag Labs(0,0)
		String ActTitle=login.VerifyTitleOfApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Title of application = "+ActTitle);
	}
	@Test(priority=3,enabled=true,groups = {"Sanity","Retesting"} )
	public void VerifyURLofApplication() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.readexcel(0, 1);//https://www.saucedemo.com/(0,1)
		String ActURL=login.VerifyURLofApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("The URL of application ="+ActURL);
	}
	@Test(priority = 2,enabled=true,groups="Regression")
	public void logintoApplication() throws IOException
	{
		String ExpURL=ReadData.readexcel(0, 2);//https://www.saucedemo.com/inventory.html(0,2)
		String ActURL=login.logintoApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("Login into application"+ActURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException//Global Object created
	{
		if (it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
			
		}
		driver.close();
	}///This code should be used in the after method of each and every testcase to capture the screenshot
	
	
	
	
	
}
