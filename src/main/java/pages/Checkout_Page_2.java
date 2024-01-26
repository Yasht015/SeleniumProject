package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page_2 extends TestBase
{
///object repository
	@FindBy(xpath="//span[@class='title']")private WebElement Checkoutpage2label;
	@FindBy(xpath="//div[text()='Payment Information']")private WebElement PaymentInformationtxt;
    @FindBy(xpath="//div[text()='Shipping Information']")private WebElement ShippingInformationtxt;
	@FindBy(xpath="//div[text()='Price Total']")private WebElement Pricetotaltxt;
	@FindBy(xpath="//button[@id='cancel']")private WebElement Cancelbutton;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']")private WebElement Finishbutton;
///Constructor	
	public Checkout_Page_2()
	{
		PageFactory.initElements(driver, this);
	}
////methods
	public String VerifyUrlofCheckoutpage2()
	{
		return driver.getCurrentUrl();
	}
	public String VerifyCheckoutpage2label()
	{
		return Checkoutpage2label.getText();
	}
	public String VerifyPaymentInformationtxt()
	{
		return PaymentInformationtxt.getText();
	}
	public String VerifyShippingInformationtxt()
	{
		return ShippingInformationtxt.getText();
	}
	public String VerifyPricetotaltxt()
	{
		return Pricetotaltxt.getText();
	}
	public String Verifybuttons()
	{
        Finishbutton.click();
		return driver.getCurrentUrl();
	}
	
	
	
	
	
}
