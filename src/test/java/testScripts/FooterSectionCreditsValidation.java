package testScripts;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import insurEdgeHomepage.HomePage;
import projectConfig.BrowserConfig;

public class FooterSectionCreditsValidation {
	
	WebDriver driver;
    WebDriverWait wait;
    HomePage page1;
    BrowserConfig getBrowser;
    
	@BeforeClass
	public void setUpBrowser()
	{
		getBrowser = new BrowserConfig();
	}
	@BeforeMethod
	@Parameters({"browser"})
	public void performLogin(@Optional("chrome") String browser)
	{
		getBrowser.setBrowser(browser);
        driver = getBrowser.getBrowser();
        getBrowser.navigateToWebsite("https://qeaskillhub.cognizant.com/LoginPage");
        getBrowser.setWait();
        wait = getBrowser.getWait();
        page1 = new HomePage(driver, wait);
        page1.login();
	}
	@Test(priority=1)
	public void performValidationOnFooterSectionCredits()
	{
		try{
		String message=page1.performActionsOnFooterSectionCredits();
		if(message.equals("Footer Present"))
		{
			Assert.assertTrue(true,"Footer Credits Present");
			System.out.println("Footer Credits Present");
		}
		else
		  {
			System.out.println("footer credits absent");
			Assert.fail();
		  } 
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Footer Absent"+e.getAdditionalInformation());
			Assert.fail();
		}
	}
	@AfterMethod
	public void closeResources()
	{
		driver.quit();
	}
	
}
