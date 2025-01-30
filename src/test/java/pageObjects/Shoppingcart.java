package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class Shoppingcart extends BasePage {
	WebDriver driver;
	
	public Shoppingcart(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	WebElement  LaptopBtn;
	
	@FindBy(xpath="//a[normalize-space()='Show AllLaptops & Notebooks']")
	WebElement ShowAlllaptopBtn;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[1]/span")
	WebElement AddToCart;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement ConfirmAddToCart;
	
	
	public void clickMyDesktop()
	{
		LaptopBtn.click();
	}
	
	public void clickMyMac()
	{
		ShowAlllaptopBtn.click();
	}
	public void clickAddToCart()
	{
		AddToCart.click();
	}
	public void confirmAddToCart()
	{
		ConfirmAddToCart.click();
	}

}
