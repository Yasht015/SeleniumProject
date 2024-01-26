package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page_2;
import pages.LoginPage;
import utility.ReadData;

public class Inventory_Page_Test extends TestBase
{
	LoginPage Login;//global object created
	Inventory_Page_2 invent;
    @BeforeMethod(alwaysRun = true)
    public void setup() throws InterruptedException, IOException
	{
		initialization();
        Login=new LoginPage();
        Login.logintoApplication();
        invent=new Inventory_Page_2();
		
	}
    @Test(enabled = true,groups = "Sanity")
    public void VerifyproductslabelTest() throws EncryptedDocumentException, IOException
    {
    	String Explabel="Products";//Products(0,3)
    	String Actlabel=invent.Verifyproductslabel();
    	Assert.assertEquals(Explabel, Actlabel);
    	Reporter.log("Label of Inventory page ="+Actlabel);
    }
    @Test(enabled = true,groups = {"Sanity","Retesting"})
    public void VerifytwitterlogoTest()
    {
    	boolean result=invent.Verifytwitterlogo();
    	boolean result1=invent.Verifyfacebooklogo();
    	boolean result2=invent.VerifyLinkedInlogo();
    	Assert.assertEquals(result, true);
    	Assert.assertEquals(result1, true);
    	Assert.assertEquals(result2, true);
    	Reporter.log("Visibility of twitter logo="+result);
    	Reporter.log("Visibility of facebook logo="+result);
    	Reporter.log("Visibility of LinkedInlogologo="+result); 			
    }
    @Test(enabled = true,groups="Regression")
    public void Add6products() throws EncryptedDocumentException, IOException
    {
    	String ExpCount=ReadData.readexcel(0, 4);//6//(0,4)
    	String ACtCount=invent.Add6products();
    	Assert.assertEquals(ExpCount, ACtCount);
    	Reporter.log("Total products added to cart=" + ACtCount);
    }
    @Test(enabled = true,groups = {"Regression","Retesting"})
    public void Remove2products() throws EncryptedDocumentException, IOException
    {
    	String ExpCount=ReadData.readexcel(0, 5);//4//(0,5)
    	String ActCount=invent.Remove2products();
    	Assert.assertEquals(ExpCount, ActCount);
    	Reporter.log("Products removed from count="+ActCount);
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
}
