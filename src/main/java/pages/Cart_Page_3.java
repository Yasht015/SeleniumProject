package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page_3 extends TestBase
{
   //object repository
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement addtocart;
	@FindBy(xpath="//span[text()='Your Cart']")private WebElement Yourcarttext;
	@FindBy(xpath="//button[@name='checkout']")private WebElement Checkout;
	//Constructor
	public Cart_Page_3()
	{
		PageFactory.initElements(driver, this);
	}
	//methods
	
	public String VerifyYourcarttext()
	{
		return Yourcarttext.getText();
	}
	
	public String VerifygetcartpageUrl()
	{
		return driver.getCurrentUrl();
		
	}
	public void VerifyclickCheckoutbtn()
	{
		Checkout.click();
	}
	 
	
	
}
