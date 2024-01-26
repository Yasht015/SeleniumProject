package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Complete_Checkout_Page extends TestBase
{
//object repository
	@FindBy(xpath="//span[text()='Checkout: Complete!']")private WebElement Completecheckoutlabel;
	@FindBy(xpath="//img[@class='pony_express']")private WebElement Imagetick;
	@FindBy(xpath="//button[@id='back-to-products']")private WebElement backhomebutton;
///Constructor
	public Complete_Checkout_Page ()
	{
		PageFactory.initElements(driver, this);
	}
////Methods
	public String VerifyCompletecheckoutlabel()
	{
		return Completecheckoutlabel.getText();
	}
	public boolean VerifyImagetick()
	{
		return Imagetick.isDisplayed();
		
	}
	public String Verifybackhomebutton()
	{
		backhomebutton.click();
        return driver.getCurrentUrl();
	}
	
}
