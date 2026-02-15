package testScripts;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import insurEdgeHomepage.HomePage;
import projectConfig.BrowserConfig;

public class HamburgerFuncValidation {
    WebDriver driver;
    WebDriverWait wait;
    HomePage page1;
    BrowserConfig getBrowser;

    @BeforeClass
    public void beforeClass() {
        getBrowser = new BrowserConfig();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(@Optional("chrome") String browser) {
        getBrowser.setBrowser(browser);
        driver = getBrowser.getBrowser();
        getBrowser.navigateToWebsite("https://qeaskillhub.cognizant.com/LoginPage");
        getBrowser.setWait();
        wait = getBrowser.getWait();
        page1 = new HomePage(driver, wait);
        page1.login();
    }

    @Test(priority = 1)
    public void performActionsOnHamburgerClose() {
        try {
            page1.performActionsOnHamburgerClose();
            System.out.println("Hamburger closed successfully");
        } catch (ElementNotInteractableException e) {
            System.out.println("Hamburger Functioning Properly-left-Side Menu closed");
            AssertJUnit.assertTrue(true);
        } catch (Exception e) {
            System.out.println("Some Other Exception-left-side Menu visible");
            AssertJUnit.fail();
        }
    }

    @Test(priority = 2)
    public void hamburgerFuncValidationTestOpen() {
        try {
        page1.performActionsOnHamburgerOpen();
         System.out.println("Customer interacted with-Test case passed");
            AssertJUnit.assertTrue(true);
        } catch (ElementNotInteractableException e) {
            System.out.println("Hamburger not Functioning Properly-left-Side Menu not visible");
            AssertJUnit.fail();
        }
    }
    @AfterMethod
    public void AfterMethod()
    {
    		driver.quit();
    }
}
