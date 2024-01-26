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
import pages.Complete_Checkout_Page;
import pages.Inventory_Page_2;
import pages.LoginPage;

public class Complete_Checkout_test extends TestBase
{
	LoginPage Login;//global object created
	Inventory_Page_2 invent;
	Cart_Page_3 cartp;
	Checkout_Page_1 checkpage;
	Checkout_Page_2 checkpage2;
	Complete_Checkout_Page checkpagecomp;
@BeforeMethod
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
	checkpagecomp=new Complete_Checkout_Page();
	cartp.VerifyclickCheckoutbtn();
	checkpage.Inputinformation();	
	checkpage2.Verifybuttons();
}
@Test
public void VerifyCompletecheckoutlabel()
{
	String ExpLabel="Checkout: Complete!";
	String Actlabel=checkpagecomp.VerifyCompletecheckoutlabel();		
	Assert.assertEquals(ExpLabel, Actlabel);
	Reporter.log("The label of chekout page ="+Actlabel);
}
@Test
public void VerifyImagetick()
{
	boolean result=checkpagecomp.VerifyImagetick();
	Assert.assertEquals(result, true);
	Reporter.log("The tick image is displayed ="+result);
}
@Test
public void Verifybackhomebutton()
{
	String ExpUrl="https://www.saucedemo.com/inventory.html";
	String ActUrl=checkpagecomp.Verifybackhomebutton();
	Assert.assertEquals(ExpUrl, ActUrl);
	Reporter.log("The back home page url ="+ActUrl);
}
@AfterMethod
public void closeBrowser()
{
	driver.close();
}
}
