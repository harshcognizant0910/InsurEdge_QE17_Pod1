package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import insurEdgeCustomerAuthorizePage.AuthorizePage;
import insurEdgeHomepage.HomePage;
import projectConfig.BrowserConfig;

public class CustomerRowFLow2 {
	WebDriver driver=null;
	WebDriverWait wait=null;
	HomePage page1=null;
	AuthorizePage page2=null;
	BrowserConfig config=null;
	
	@Test
	  public void validationOfAuthorizeCustomerRowFlow2()
	  {
		  page2.actionsOnAuthorizeCustomerRowFLow2();
	  }
	
	 @BeforeMethod
	  @Parameters({"browser","url"})
	  public void browserType(@Optional("chrome")String browser,@Optional("null")String url) {
		  config.setBrowser(browser);
		  driver=config.getBrowser();
		  config.navigateToWebsite(url);
		  config.setWait();
		  wait=config.getWait();
		  page1=new HomePage(driver,wait);
		  page1.login();
		  page2=new AuthorizePage(driver,wait);
	  }

	  @BeforeClass
	  public void browserSetup() {
		  
		 config=new BrowserConfig();
	  }

	  @AfterClass
	  public void closeBrowser() {
		  driver.quit();
	  }
}

