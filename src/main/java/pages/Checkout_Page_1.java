package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page_1 extends TestBase
{
    ///object repository
    @FindBy(xpath="//span[@class='title']")private WebElement Titleofcheckoutpage;
    @FindBy(xpath="//input[@id='first-name']")private WebElement Firstnametxtbox;
    @FindBy(xpath="//input[@id='last-name']")private WebElement lastnametxtbox;
    @FindBy(xpath="//input[@id='postal-code']")private WebElement Ziptxtbox;
    @FindBy(xpath="//input[@id='continue']")private WebElement continuebtn;
    //constructor
    public Checkout_Page_1()
    {
    	PageFactory.initElements(driver, this);
    }
    //methods
    public String verifyTitleofcheckoutpage()
    {
		return Titleofcheckoutpage.getText();
    }
    public String UrlOfofcheckoutpage()
    {
    	return driver.getCurrentUrl();
    }
    public String Inputinformation()
    {
    	Firstnametxtbox.sendKeys("Yash");
    	lastnametxtbox.sendKeys("Todankar");
    	Ziptxtbox.sendKeys("415612");
    	continuebtn.click();
    	return driver.getCurrentUrl();
    }
    
    
}

