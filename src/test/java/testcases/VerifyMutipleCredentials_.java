package testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class VerifyMutipleCredentials_ extends TestBase
{
LoginPage login;
@BeforeMethod(alwaysRun = true)
public void setup() throws InterruptedException, IOException
{
	initialization();
    login=new LoginPage();
	
}
@DataProvider(name="Credentials")
public Object[][] getdata()
{
	return new Object[][]
   {
		{"standard_user","secret_sauce"},
		{"locked_out_user","secret_sauce"},
		{"problem_user","secret_sauce"},
		{"performance_glitch_user","secret_sauce"},
		{"error_user","secret_sauce"},
		{"visual_user","secret_sauce"},
		
   };
}
@Test(dataProvider ="Credentials")
public void loginwithmulticredentials(String un, String pass)
{
	SoftAssert s=new SoftAssert();
	String ExpUrl="https://www.saucedemo.com/inventory.html";
	String ActUrl=login.loginwithmulticredentials(un, pass);
	s.assertEquals(ExpUrl, ActUrl);
	s.assertAll();
}

@AfterMethod
public void closeBrowser(ITestResult it) throws IOException//Global Object created
{
	if (it.FAILURE==it.getStatus())
	{
		CaptureScreenshot.screenshot(it.getName());
		
	}
	driver.close();
}
}
