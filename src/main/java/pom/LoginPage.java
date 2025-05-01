package pom;

import actions.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private WebDriver driver;
    ElementActions elementActions;
    By userId=By.cssSelector("input[type=\"text\"]");
    By password=By.cssSelector("input[name=\"password\"]");
    By loginButton=By.cssSelector("input[name=\"btnLogin\"]");
    By textManagerId=By.cssSelector("td[style=\"color: green\"]");
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.elementActions=new ElementActions(driver);
    }
    public void enterValidUserId(String user){
        elementActions.sendKeys(userId,user);
    }
    public void enterValidPassword(String pass){
        elementActions.sendKeys(password,pass);
    }
    public HomePage clickLogin(){
        elementActions.clickOnElement(loginButton);
        return new HomePage(driver);
    }
    public  String validateThatLoginSuccess(){
        return elementActions.getElementText(textManagerId);
    }
    public  String validateThatLoginFailed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text= alert.getText();
        alert.accept();
        return text;
    }






}
