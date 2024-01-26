package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page_3;
import pages.Checkout_Page_1;
import pages.Inventory_Page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class Checkout_Page_Test extends TestBase
{
	LoginPage Login;//global object created
	Inventory_Page_2 invent;
	Cart_Page_3 cartp;
	Checkout_Page_1 checkpage;
   @BeforeMethod(alwaysRun = true)
   public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login=new LoginPage();
        Login.logintoApplication();		
		invent=new Inventory_Page_2();
		invent.Add6products();
		cartp=new Cart_Page_3();
		invent.Verifyaddtocart();
		checkpage=new Checkout_Page_1();
		cartp.VerifyclickCheckoutbtn();
	}
   @Test
   public void verifyTitleofcheckoutpage()
   {
	   String ExpTitle="Checkout: Your Information";
	   String ActTitle=checkpage.verifyTitleofcheckoutpage();
	   Assert.assertEquals(ExpTitle, ActTitle);
	   Reporter.log("The title of checkout page="+ActTitle);
   }
   @Test
   public void verifyUrlOfofcheckoutpage()
   {
	   String ExpUrl="https://www.saucedemo.com/checkout-step-one.html";
	   String ActUrl=checkpage.UrlOfofcheckoutpage();
	   Assert.assertEquals(ExpUrl, ActUrl);
	   Reporter.log("The current Url ="+ActUrl);
   }
   @Test
   public void Inputinformation()
   {
	   String ExpUrl="https://www.saucedemo.com/checkout-step-two.html";
	   String ActUrl=checkpage.Inputinformation();
	   Assert.assertEquals(ExpUrl, ActUrl);
	   Reporter.log("The url of next checkout page ="+ActUrl);
   }
   @AfterMethod(alwaysRun = true)
   public void closeBrowser(ITestResult it) throws IOException//Global Object created
	{
		if (it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
			
		}
		driver.close();
	}
   
}
