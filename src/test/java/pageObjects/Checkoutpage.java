package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutpage extends BasePage {
	public Checkoutpage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//span[@id='cart-total']")
WebElement ChkoutBtn;

@FindBy(xpath="//strong[normalize-space()='Checkout']")
WebElement Totalchkout;

@FindBy(xpath="//input[@id='button-payment-address']")
WebElement Paymentcontinue;

@FindBy(xpath="//input[@id='button-shipping-address']")
WebElement Shippingcontinue;


@FindBy(xpath="//input[@id='button-shipping-method']")
WebElement ShippingMethodcontinue;

@FindBy(xpath="//input[@name='agree']")
WebElement termsconditions;

@FindBy(xpath="//input[@id='button-payment-method']")
WebElement paymentmethod;


@FindBy(xpath="//input[@id='button-confirm']")
WebElement ConfirmOrder;

@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
WebElement  OrderPlacedConfirmation;

@FindBy(xpath="//h4[normalize-space()='Step 1: Checkout Options']")
WebElement checkoutoptions;

public void clickchkoutbtn()
{
	ChkoutBtn.click();
}

public void clicktotalchkout()
{
	Totalchkout.click();
}
public void checkoutopt()
{
	checkoutoptions.click();
}
public void payment()
{
	Paymentcontinue.click();
}
	
public void shipment()
{
	Shippingcontinue.click();
}
public void Shipmethodcont()
{
	ShippingMethodcontinue.click();
}

public void termsconditions()
{
	termsconditions.click();
}
public void ConfirmOrder()
{
	ConfirmOrder.click();
}

public void paymentmthd()
{
	paymentmethod.click();
}

public String getOrderPlacedMsg()
{
	try
	{
		return(OrderPlacedConfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}


}

}
