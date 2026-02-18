package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import insurEdgeCustomerAuthorizePage.AuthorizePage;
import insurEdgeHomepage.HomePage;
import projectConfig.BrowserConfig;

public class CustomerInfoTableColumnSpellingValidation {
	BrowserConfig config=null;
	WebDriver driver=null;
	WebDriverWait wait=null;
	HomePage page1=null;
	AuthorizePage page2=null;
	
	@BeforeClass
	public void browserSetUp()
	{
		config=new BrowserConfig();
	}
	@BeforeMethod
	@Parameters({"browser","url"})
	public void browserType(@Optional("chrome")String browser,@Optional("null")String url)
	{
		config.setBrowser(browser);
		driver=config.getBrowser();
		config.navigateToWebsite(url);
		config.setWait();
		wait=config.getWait();
		page1=new HomePage(driver,wait);
		page2=new AuthorizePage(driver,wait);
		page1.login();
	}
	@Test
	public void performValidationOnColumnSpellings()throws InterruptedException
	{
		String msg=page2.actionsOnCustomerInfoTableColumnSpelling();
		if(msg.equalsIgnoreCase("mismatch"))
			Assert.fail();
		else
		{
			Assert.assertTrue(true);
			System.out.println("Table Column Correct");
		}
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
