package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.Cart_Page_3;
import pages.Inventory_Page_2;
import pages.LoginPage;
import utility.ReadData;

public class Cart_Page_Test extends TestBase
{
	LoginPage Login;//global object created
	Inventory_Page_2 invent;
	Cart_Page_3 cartp;
	
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
	}
	
	@Test
	public void VerifyYourcarttext() throws EncryptedDocumentException, IOException
	{
		String Exptext= ReadData.readexcel(0, 7);//Your Cart
		String Acttext=cartp.VerifyYourcarttext();
		Assert.assertEquals(Exptext, Acttext);	
		Reporter.log("Title of cart page ="+Acttext);
	}
	
	
	
	@Test
	public void VerifygetcartpageUrl() throws EncryptedDocumentException, IOException
	{
		String ExpURL= ReadData.readexcel(0, 6);//https://www.saucedemo.com/cart.html
		String ActURL=cartp.VerifygetcartpageUrl();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("The Url of cart page="+ActURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closebrowser()
	{
		
	}
	
		
	
	
	
}
