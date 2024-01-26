package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page_3;
import pages.Checkout_Page_1;
import pages.Checkout_Page_2;
import pages.Inventory_Page_2;
import pages.LoginPage;

public class Checkout_Page2_test extends TestBase
{
	LoginPage Login;//global object created
Inventory_Page_2 invent;
Cart_Page_3 cartp;
Checkout_Page_1 checkpage;
Checkout_Page_2 checkpage2;
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
	checkpage2=new Checkout_Page_2();
	cartp.VerifyclickCheckoutbtn();
	checkpage.Inputinformation();	
}
@Test
public void VerifyCheckoutpage2label()
{
	String Explabel="Checkout: Overview";
	String Actlabel=checkpage2.VerifyCheckoutpage2label();
	Assert.assertEquals(Explabel, Actlabel);
	Reporter.log("The label of checkoutpage 2"+Actlabel);			
}
@Test
public void VerifyUrlofCheckoutpage2()
{
	String ExpUrl="https://www.saucedemo.com/checkout-step-two.html";
	String ActUrl=checkpage2.VerifyUrlofCheckoutpage2();
	Assert.assertEquals(ExpUrl, ActUrl);
	Reporter.log("The Url of Checkout page2 ="+ActUrl);
}
@Test
public void Verifybuttons()
{
	String ExpUrl="https://www.saucedemo.com/checkout-complete.html";
	String ActUrl=checkpage2.Verifybuttons();
	Assert.assertEquals(ExpUrl, ActUrl);
	Reporter.log("The url of complete checkout page"+ActUrl);
}

@AfterMethod(alwaysRun = true)
public void closeBrowser()
{
	driver.close();
}
}

	
	
	

