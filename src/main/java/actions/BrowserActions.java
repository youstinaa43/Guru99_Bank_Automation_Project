package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {
    private WebDriver driver;
    public enum Browser {
        FIREFOX,
        CHROME
    }
    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver setBrowserDriver(Browser browser){
        switch (browser){
            case CHROME:
                this.driver= new ChromeDriver();
                break;
            case FIREFOX:
                this.driver= new FirefoxDriver();
                break;
        }
        return this.driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
        return driver.getTitle();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
