package insurEdgeHomepage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	public HomePage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	By hamBtn=By.cssSelector("i[class='bi bi-list toggle-sidebar-btn']");
	By hamfunc=By.cssSelector("i[class='bi bi-grid']");
	By customerSubMenu=By.cssSelector("i[class='bi bi-menu-button-wide']");
	By footerHyperLinkTxt=By.linkText("QEA Skill Enable Function");
	By footerSectionCredits=By.cssSelector("div[class='credits']");
	By user=By.id("txtUsername");
	By pass=By.id("txtPassword");
	By loginBtn=By.id("BtnLogin");
	public void login()
	{
		driver.findElement(user).sendKeys("admin_user");
		driver.findElement(pass).sendKeys("testadmin");
		driver.findElement(loginBtn).click();
	}
	public void performActionsOnHamburgerClose()
	{
		WebElement hamburgerBtn=driver.findElement(hamBtn);
		hamburgerBtn.click();
		WebElement hamFunc=driver.findElement(hamfunc);
		hamFunc.click();
	}
	public void performActionsOnHamburgerOpen()
	{
		WebElement customer=driver.findElement(customerSubMenu);
		customer.click();
	}
	public String performActionsOnFooterSectionHyperLink()
	{
		WebElement footerHyperLink=driver.findElement(footerHyperLinkTxt);
		footerHyperLink.click();
		Set<String> winHandles=driver.getWindowHandles();
		for(String s:winHandles)
		{
			if(driver.switchTo().window(s).getTitle().equals("Download 160+ Free Bootstrap Templates & Themes | BootstrapMade"))
			{
				return "Hyperlink present";
			}
			else
			{
				return "Hyperlink absent";
			}
		}
		return "";
	}
	public String performActionsOnFooterSectionCredits()
	{
			WebElement footerSection=driver.findElement(footerSectionCredits);
			if(footerSection.getText().equals("Designed by QEA Skill Enable Function"))
			{
				return "Footer Present";
			}
			else
			{
				return "Footer absent";
			}
		
	}
}
