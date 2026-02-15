package insurEdgeHomepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FooterSectionCredits {
	
	private static final String USERNAME="admin_user";
	private static final String PASSWORD="testadmin";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://qeaskillhub.cognizant.com/LoginPage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
		driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);
		driver.findElement(By.id("BtnLogin")).click();
		WebElement footerSection=driver.findElement(By.cssSelector("div[class='credits']"));
		try {
		if(footerSection.getText().equals("Designed by QEA Skill Enable Function"))
			{
				System.out.println("Footer Present");
				Assert.assertTrue(true);
			}
		else
			{
					System.out.println("Footer not matched as per requirement");
					Assert.fail("footer mismatch");
			}
		}
		catch(NoSuchElementException e)
			{
				System.out.println("Footer Absent"+e.getAdditionalInformation());
				Assert.fail("footer mismatch");
			}
	}

}
