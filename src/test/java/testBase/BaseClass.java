package testBase;

import java.io.File;
import java.io.FileReader;
import org.testng.annotations.Optional; 

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver; 

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
public class BaseClass {
public static WebDriver driver;
public Logger logger;  //log4j
public Properties p;
//master groups will execute all testcases
	@BeforeClass(groups= {"sanity","Regression","master","Datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("C://Users//rajav//eclipse-workspace//opencartV1.21//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());//log4j2
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
				
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");  break;
			case "firefox":  capabilities.setBrowserName("Firefox");  break;
			default: System.out.println("No matching browser");return;
			}	driver=new RemoteWebDriver(new URL("http://192.168.68.109:4444/wd/hub"), capabilities);
			
			}
			
			
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			
		
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name..");return;
		}}
	
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appurl"));//reading url from properties file
		
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}

	@AfterClass(groups= {"sanity","Regression","master","Datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	public String randomAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedString+"@"+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException, WebDriverException{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
	    File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
	    String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
	    		File targetFile=new File(targetFilePath);
	    sourceFile.renameTo(targetFile);
	    
		
		return targetFilePath;
		
	}
}
