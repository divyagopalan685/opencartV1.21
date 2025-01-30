package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Shoppingcart;
import testBase.BaseClass;

public class Tc004_Shoppingcart extends BaseClass{
	@Test
	
	public void verifyAddToCart()
	{
		try
		{
			Shoppingcart sc=new Shoppingcart(driver);
			sc.clickMyDesktop();
			sc.clickMyMac();
			sc.clickAddToCart();
			sc.confirmAddToCart();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
