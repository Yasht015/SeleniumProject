package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase 
{
	//object repository
	
	@FindBy(xpath="//input[@name='user-name']")private WebElement usertxtbox;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordbox;
	@FindBy(xpath="//input[@name='login-button']") private WebElement loginbtn;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String logintoApplication() throws IOException
	{
		usertxtbox.sendKeys("standard_user");
		passwordbox.sendKeys("secret_sauce");
		loginbtn.click();
        return driver.getCurrentUrl();
	}
	public String loginwithmulticredentials(String un, String pass)
	{
		usertxtbox.sendKeys (un);
		passwordbox.sendKeys(pass);
		loginbtn.click();
		return driver.getCurrentUrl();
		
	}
    public String VerifyTitleOfApplication()
    {
		return driver.getTitle();
    	
    }
	public String VerifyURLofApplication()
	{
		return driver.getCurrentUrl();
		
	}
}
