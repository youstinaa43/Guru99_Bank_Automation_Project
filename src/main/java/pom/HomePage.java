package pom;

import actions.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    ElementActions elementActions;
    By logOut=By.linkText("Log out");
    public HomePage(WebDriver driver){
        this.driver=driver;
        this.elementActions=new ElementActions(driver);
    }
    public void clickLogout(){

        //elementActions.clickOnElement(logOut);
        //driver.findElement(logOut).click();
       // WebElement logoutButton = driver.findElement(logOut);
       // ((JavascriptExecutor)driver).executeScript("arguments[0].click();", logoutButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(logOut));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", logoutButton);
    }
    public  void clickOnPopUpLogout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }






}
