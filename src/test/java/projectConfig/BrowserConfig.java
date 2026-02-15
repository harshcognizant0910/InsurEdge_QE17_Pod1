package projectConfig;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserConfig {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown Browser: " + browser);
        }
    }

    public WebDriver getBrowser() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToWebsite(String url) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
}
