package insurEdgeCustomerAuthorizePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public String actionsOnCustomerInfoTableColumnSpelling()
	{
		WebElement customerMenu=driver.findElement(customerMenuLoc);
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(customerAuthorizeLinkLoc);
		customerAuthorizeLink.click();
		List<WebElement> columnHeaders=driver.findElements(columnHeadersLoc);
		List<String> columnList=new ArrayList<>();
		columnHeaders.forEach(ch ->columnList.add(ch.getText()));
		System.out.println(columnList);
		String data[]= {"Customer ID","First Name","Last Name","Gender","Date of Birth","Senior Citizen","Email","User Name","Password","Mobile","Address","City","State","Zip Code","Status","Created Date"};
		for(int i=0;i<data.length;i++)
		{
			if(data[i].equals(columnList.get(i+1)))
			{
				System.out.println("Column Matched-"+data[i]);
			}
			else
				System.out.println("Mismatch found-"+"Expected: "+data[i]+" Actual: "+columnList.get(i+1));
		}
		return "";
	}

}
