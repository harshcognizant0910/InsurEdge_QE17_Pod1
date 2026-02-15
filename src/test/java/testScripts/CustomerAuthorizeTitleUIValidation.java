package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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

public class CustomerAuthorizeTitleUIValidation {
	BrowserConfig config=null;
	WebDriver driver=null;
	WebDriverWait wait=null;
	HomePage page1=null;
	AuthorizePage page2=null;
  @Test
  public void customerAuthorizetitleValidation() {
	  try
		{
			String msg=page2.actionsonTitle();
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Actual title Different from Expected title-Test Failed");
			Assert.fail();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			driver.quit();
		}
  }
  @BeforeMethod
  @Parameters("browser")
  public void browserType(@Optional("chrome") String browser) {
	  config.setBrowser(browser);
	  driver=config.getBrowser();
	  config.navigateToWebsite("https://qeaskillhub.cognizant.com/LoginPage");
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
  public void afterClass() {
	  driver.quit();
  }

}
