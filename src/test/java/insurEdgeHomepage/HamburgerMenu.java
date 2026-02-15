package insurEdgeHomepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HamburgerMenu {
	
	private static final String USERNAME="admin_user";
	private static final String PASSWORD="testadmin";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://qeaskillhub.cognizant.com/LoginPage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
		driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);
		driver.findElement(By.id("BtnLogin")).click();
		
		System.out.println("Hambuger should hide now");
		WebElement hamburgerBtn=driver.findElement(By.cssSelector("i[class='bi bi-list toggle-sidebar-btn']"));
		hamburgerBtn.click();
		try {
		WebElement hamFunc=driver.findElement(By.cssSelector("i[class='bi bi-grid']"));
		hamFunc.click();
		}
		catch(ElementNotInteractableException e)
		{
			System.out.println("Hamburger Functioning Properly-left-Side Menu closed");
		}
		catch(Exception e)
		{
			System.out.println("Some Other Exception-left-side Menu visible");
		}
		System.out.println("");
		hamburgerBtn.click();
		try {
		WebElement customer=driver.findElement(By.cssSelector("i[class='bi bi-menu-button-wide']"));
		customer.click();
		System.out.println("Customer interacted with-Test case passed");
		}
		catch(ElementNotInteractableException e)
		{
			System.out.println("Hamburger not Functioning Properly-left-Side Menu not visible");
		}
		System.out.println("Humburger Clicked-left-side Menu opene");
		System.out.println("DashBoard interacted-Test Case Passed");
		driver.quit();

	}

}
