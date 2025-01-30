package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Checkoutpage;
import pageObjects.LoginPage;
import pageObjects.Shoppingcart;
import testBase.BaseClass;

public class Tc005_Checkout extends BaseClass{
	@Test
	
	public void checkout()
	{
		try
		{
			Shoppingcart sc=new Shoppingcart(driver);
			sc. clickMyDesktop();
			sc.clickMyMac();
			sc. clickAddToCart();
			sc.confirmAddToCart();
			
			
			LoginPage lp=new LoginPage(driver);
			Checkoutpage ch=new Checkoutpage(driver);
			ch.clickchkoutbtn();
			ch.clicktotalchkout();
			ch.checkoutopt();
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			ch.payment();
			ch.shipment();
			ch.Shipmethodcont();
			ch. termsconditions();
			ch.paymentmthd();
			Thread.sleep(6000);
			ch.ConfirmOrder();
			Thread.sleep(6000);
			String confmessage=ch.getOrderPlacedMsg();
		
			Assert.assertEquals(confmessage,"Your order has been placed!");
			Thread.sleep(6000);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
