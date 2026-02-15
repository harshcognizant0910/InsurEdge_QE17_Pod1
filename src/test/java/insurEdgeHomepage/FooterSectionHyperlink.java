package insurEdgeHomepage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterSectionHyperlink {
	
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
			WebElement footerHyperLink=driver.findElement(By.linkText("QEA Skill Enable Function"));
			footerHyperLink.click();
			Set<String> winHandles=driver.getWindowHandles();
			for(String s:winHandles)
			{
				if(driver.switchTo().window(s).getTitle().equals("Download 150+ Free Bootstrap Templates & Themes | BootstrapMade"))
				{
					System.out.println("Hyperlink present");
					break;
				}
				else
				{
					System.out.println("Hyperlink absent");
				}
			}
			driver.quit();
			
	}

}
