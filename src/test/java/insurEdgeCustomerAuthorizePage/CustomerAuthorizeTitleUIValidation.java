
package insurEdgeCustomerAuthorizePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class CustomerAuthorizeTitleUIValidation {
	
		// TODO Auto-generated method stub
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
			String titleExpected="Authorize Customer";
			try
			{
				WebElement customerMenu=driver.findElement(By.cssSelector("[class='bi bi-menu-button-wide']"));
				customerMenu.click();
				WebElement customerAuthorizeLink=driver.findElement(By.xpath("//*[text()='Authorize']"));
				customerAuthorizeLink.click();
				WebElement pageTitle=driver.findElement(By.xpath("//*[text()='"+titleExpected+"']"));
				String colourInRGB=pageTitle.getCssValue("color");
				String colourInHex=Color.fromString(colourInRGB).asHex();
				if(colourInHex.equals("#012970"))
				{
					System.out.println("font Colour of title is correct");
				}
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Actual title Different from Expected title-Test Failed");
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

}
