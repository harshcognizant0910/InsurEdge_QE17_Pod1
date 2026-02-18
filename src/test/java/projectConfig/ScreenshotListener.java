package projectConfig;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener{
	
	WebDriver driver=null;
	WebElement ele=null;
	public ScreenshotListener(WebDriver driver,WebElement ele)
	{
		this.driver=driver;
		this.ele=ele;
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		//CustomScreenshots.captureElementScreenshot(driver, ele);
	}
	

}
