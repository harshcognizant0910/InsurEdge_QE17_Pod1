package insurEdgeCustomerAuthorizePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectConfig.CustomScreenshots;
import projectConfig.ScreenshotListener;

public class AuthorizePage {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	public AuthorizePage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	
	By customerMenuLoc=By.cssSelector("[class='bi bi-menu-button-wide']");
	By customerAuthorizeLinkLoc=By.xpath("//*[text()='Authorize']");
	By pageTitleLoc=By.xpath("//*[text()='Authorize Customer']");
	By tableLoc=By.tagName("table");
	By columnHeadersLoc=By.xpath("//th");
	By pageTrail=By.xpath("//ol[@class='breadcrumb']");
	By menus=By.xpath("//li[@class='nav-item']");
	By subMenus=By.xpath("//i[@class='bi bi-circle']");
	By customerTableRow=By.xpath("//input[@id='ContentPlaceHolder_Admin_GridViewCustomers_chkSelect_0']");
	By okBtn=By.xpath("//button[text()='OK']");
	By approveBtn=By.xpath("//input[@id='ContentPlaceHolder_Admin_btnApprove']");
	public String actionsonTitle()
	{
		WebElement customerMenu=driver.findElement(customerMenuLoc);
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(customerAuthorizeLinkLoc);
		customerAuthorizeLink.click();
		WebElement pageTitle=driver.findElement(pageTitleLoc);
		String colourInRGB=pageTitle.getCssValue("color");
		String colourInHex=Color.fromString(colourInRGB).asHex();
		if(colourInHex.equals("#012970"))
		{
			System.out.println("font Colour of title is correct");
			return "font Colour of title is correct";
		}
		else
		{
			return "title not as expected";
		}
	}
	public String actionsOnCustomerInfoTableAppearance()
	{
		WebElement customerMenu=driver.findElement(customerMenuLoc);
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(customerAuthorizeLinkLoc);
		customerAuthorizeLink.click();
		System.out.println("Checking for Appearance of Customer's Details table");
		WebElement table=driver.findElement(tableLoc);
		if(table.isDisplayed())
		{
			System.out.println("Table is Appearing on the Screen");
			return "Table is Appearing on the Screen";
		}
		else
		{
			System.out.println("Table Not Present!!!-Test Failed...");
			return "Table Not Present!!!-Test Failed...";
		}
		
	}
	public String actionsOncustomerInfoTableColumnCount()
	{
		//Task 2: Validate that all the required column headers are clearly displayed.
		WebElement customerMenu=driver.findElement(customerMenuLoc);
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(customerAuthorizeLinkLoc);
		customerAuthorizeLink.click();
		List<WebElement> columnHeaders=driver.findElements(columnHeadersLoc);
		if(columnHeaders.size()==17)
			{
				System.out.println("All columns are displayed correctly");
				return "All columns are displayed correctly";
			}
		else return "Column Missing";
			
	}
	public String actionsOnCustomerInfoTableColumnSpelling() throws InterruptedException
	{
		WebElement customerMenu=driver.findElement(customerMenuLoc);
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(customerAuthorizeLinkLoc);
		customerAuthorizeLink.click();
		List<WebElement> columnHeaders=driver.findElements(columnHeadersLoc);
		List<String> columnList=new ArrayList<>();
		columnHeaders.forEach(ch ->columnList.add(ch.getText()));
		System.out.println(columnList);
		boolean flag=false;
		String data[]= {"Customer ID","First Name","Last Name","Gender","Date of Birth","Senior Citizen","Email","User Name","Password","Mobile","Address","City","State","Zip Code","Status","Created Date"};
		for(int i=0;i<data.length;i++)
		{
			if(data[i].equals(columnList.get(i+1)))
			{
				System.out.println("Column Matched-"+data[i]);
			}
			else
			{
				flag=true;
				System.out.println("Mismatch found-"+"Expected: "+data[i]+" Actual: "+columnList.get(i+1));
				for(WebElement ele:columnHeaders)
				{
					if(ele.getText().equalsIgnoreCase(columnList.get(i+1)))
					{
						CustomScreenshots.captureElementScreenshot(driver, ele,columnList.get(i+1));
						break;
					}
				}
			}
		}
		if(flag)
		return "mismatch";
		return "passed";
	}
	public String performActionsOnPageTrail()
	{
		WebElement fetchPageTrail=driver.findElement(pageTrail);
		String fetchTrailText=fetchPageTrail.getText();
		System.out.println("BreadCrumbs present");
		return fetchTrailText;
	}
	public void performActionsOnNavMenus() {
		    for (int i = 2; i <= 5; i++) {
		        performActionsOnNavMenu(i);
		    }
	}
	public void performActionsOnNavMenu(int menuIndex) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Click the parent menu
	    WebElement parentMenu = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//li[@class='nav-item'][" + menuIndex + "]")));
	    parentMenu.click();

	    // Count submenus dynamically
	    int subMenuCount = driver.findElements(
	        By.xpath("//li[@class='nav-item'][" + menuIndex + "]//li")).size();

	    // Iterate through submenus
	    for (int j = 1; j <= subMenuCount; j++) {
	        WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[@class='nav-item'][" + menuIndex + "]//li[" + j + "]")));
	        subMenuItem.click();

	        // Scroll down to bottom
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	        try {
	            // Wait for back-to-top button to become visible
	            WebElement scrollBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
	                .until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//a[contains(@class,'back-to-top')]")));

	            // Scroll the button into view and click
	            js.executeScript("arguments[0].scrollIntoView(true);", scrollBtn);
	            wait.until(ExpectedConditions.elementToBeClickable(scrollBtn)).click();

	        } catch (TimeoutException e) {
	            // Fallback if button never appears
	            System.out.println("Back-to-top button never appeared — scrolling manually.");
	            js.executeScript("window.scrollTo(0, 0);");
	        }

	        // Re‑click parent menu to reopen it for next submenu
	        parentMenu = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[@class='nav-item'][" + menuIndex + "]")));
	        parentMenu.click();
	    }
	}
  public void actionsOnAuthorizeCustomerRow()
  {
	  WebElement customerMenu=driver.findElement(customerMenuLoc);
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(customerAuthorizeLinkLoc);
		customerAuthorizeLink.click();
	  WebElement radioBtn=driver.findElement(customerTableRow);
	  radioBtn.click();
	  if(radioBtn.isSelected())
	  {
		  System.out.println("Customer Row is selected");
	  }
	  else
		  System.out.println("Customer Row is not selected");
  }
  public void actionsOnAuthorizeCustomerRowFLow2()
  {
	  
  }
  public void performActionsOnNavMenusForScrollBtnDisappearance() {
	    for (int i = 2; i <= 5; i++) {
	    	verifyBackToTopButtonBehaviorForAllMenus(i);
	    }
  }
  public void verifyBackToTopButtonBehaviorForAllMenus(int menuIndex) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Click the parent menu
	    WebElement parentMenu = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//li[@class='nav-item'][" + menuIndex + "]")));
	    parentMenu.click();

	    // Count submenus dynamically
	    int subMenuCount = driver.findElements(
	        By.xpath("//li[@class='nav-item'][" + menuIndex + "]//li")).size();

	    // Iterate through submenus
	    for (int j = 1; j <= subMenuCount; j++) {
	        WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[@class='nav-item'][" + menuIndex + "]//li[" + j + "]")));
	        subMenuItem.click();

	        // Scroll down to bottom
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	        try {
	            // Check if back-to-top button is present (visible)
	            WebElement scrollBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
	                .until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//a[contains(@class,'back-to-top')]")));
	            System.out.println("Back-to-top button appeared after scrolling down.");
	        } catch (TimeoutException e) {
	            System.out.println("Back-to-top button did not appear after scrolling down.");
	        }

	        // Scroll back up to top
	        js.executeScript("window.scrollTo(0, 0);");

	        // Validate button vanishes
	        boolean vanished = wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.xpath("//a[contains(@class,'back-to-top')]")));

	        if (vanished) {
	            System.out.println("Back-to-top button vanished after scrolling up.");
	        } else {
	            System.out.println("Back-to-top button is still visible after scrolling up.");
	        }

	        // Re‑click parent menu to reopen it for next submenu
	        parentMenu = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[@class='nav-item'][" + menuIndex + "]")));
	        parentMenu.click();
	    }
	}




}
