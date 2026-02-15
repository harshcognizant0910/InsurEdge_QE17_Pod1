package insurEdgeCustomerAuthorizePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//US17_P1_12: User Details column UI validation
public class ValidateCustomerDetailsTable {
	private static final String USERNAME="admin_user";
	private static final String PASSWORD="testadmin";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pre-requisites
		WebDriver driver=new ChromeDriver();
		driver.get("https://qeaskillhub.cognizant.com/LoginPage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
		driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);
		driver.findElement(By.id("BtnLogin")).click();
		
		WebElement customerMenu=driver.findElement(By.cssSelector("[class='bi bi-menu-button-wide']"));
		customerMenu.click();
		WebElement customerAuthorizeLink=driver.findElement(By.xpath("//*[text()='Authorize']"));
		customerAuthorizeLink.click();
		
		System.out.println("Checking for Appearance ofCustomer's Details table");
		//Task 1: Validating the appearance of Table in Customer's Authorize Page.
		
		WebElement table=driver.findElement(By.tagName("table"));
		
		if(table.isDisplayed())
		{
			System.out.println("Table is Appearing on the Screen");
		}
		else
		{
			System.out.println("Table Not Present!!!-Test Failed...");
		}
		
		//Task 2: Validate that all the required column headers are clearly displayed.
		
		List<WebElement> columnHeaders=driver.findElements(By.xpath("//th"));
		if(columnHeaders.size()==17)
		{
			System.out.println("All columns are displayed correctly");
		}
		
		//Task 3: Validate that the order of the column header are correctly displayed.
		
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
		System.out.println("Done");
		driver.quit();
	}

}
