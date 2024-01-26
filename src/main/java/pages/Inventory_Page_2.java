package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.Handle_Dropdown_List;

public class Inventory_Page_2 extends TestBase
{
    ////object repository
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement addtocart;
	 @FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartcount;
	 @FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropdownlist;
	 @FindBy(xpath="//div[@class='app_logo']") private WebElement applogo;
	 @FindBy(xpath="//span[@class='title']") private WebElement productslabel;
	 @FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menubox;
	 //products added to cart
	 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement bagpackproduct;
	 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement bikelightproduct;
	 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement tshirtproduct;
	 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement jacketproduct;
	 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement whiteproduct;
	 @FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement redproduct;
	 //products removed
	 @FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removebagpackproduct;
	 @FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement removebikelightproduct;
	 @FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removetshirt;
	 @FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removejacketproduct;
	 @FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement removewhiteproduct;
	 @FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removeredproduct;
	 @FindBy(xpath="//a[text()='Twitter']") private WebElement twitterlogo;
	 @FindBy(xpath="//a[text()='Facebook']") private WebElement facebooklogo;
	 @FindBy(xpath="//a[text()='LinkedIn']")private WebElement LinkedInlogo;
	 //constructor
	 public Inventory_Page_2 ()
	 {
		 PageFactory.initElements(driver, this); 
	 }
	 //methods
	 public String Verifyproductslabel()
	 {
		return productslabel.getText();
	 }
	 public boolean Verifytwitterlogo()
	 {
		return twitterlogo.isDisplayed();		 
	 }
	 public boolean Verifyfacebooklogo()
	 {
		 return facebooklogo.isDisplayed();
	 }
	 public boolean VerifyLinkedInlogo()
	 {
		 return LinkedInlogo.isDisplayed();
	 }
	public String Add6products()
	{
		Handle_Dropdown_List.handleselectclass(dropdownlist, "Price (low to high)");
		bikelightproduct.click();
		bagpackproduct.click();
		jacketproduct.click();
		tshirtproduct.click();
        redproduct.click();
        whiteproduct.click();
		
		return cartcount.getText();     
	}
	public String Remove2products()
	{
		 Add6products();
		 removebagpackproduct.click();
		 removebikelightproduct.click();
		 return cartcount.getText();
		 
	}
	public void Verifyaddtocart()
	{
		addtocart.click();
		
	}
	
	 
	 
}
