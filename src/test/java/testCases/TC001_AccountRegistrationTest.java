package testCases;
//for each project we have to add library in current project
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"master","sanity"})
public void verify_account_registration() throws InterruptedException
{
		try {
	logger.info("*****Starting TC001_AccountRegistrationTest ****");
	
		
HomePage hp=new HomePage(driver);
hp.clickMyAccount();
logger.info("Clicked on MyAccount Link");

hp.clickRegister();
logger.info("Clicked on Register Link");

AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
logger.info("Providing customer details");


regpage.setFirstname(randomString().toUpperCase());
regpage.setLastname(randomString().toUpperCase());
regpage.setEmail(randomString()+"@gmail.com");//randomly generated string
regpage.setTelephone(randomNumber());

String password=randomAlphaNumeric();
regpage.setPassword(password);
regpage.setConfirmPassword(password);

regpage.setPrivacyPolicy();
regpage.clickContinue();

logger.info("Validating expected message");

String confmsg=regpage.getConfirmationMsg();
Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}

	catch(Exception e)
	{
		logger.error("Test failed..");
		logger.debug("Debug logs..");
	
		Assert.fail();
	}
logger.info("***finished***");
}}
