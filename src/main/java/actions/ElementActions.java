package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementActions {
    private WebDriver driver;
    private WebDriverWait wait;
    public ElementActions(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickOnElement(By locator){
        try {
            WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
        catch (Exception e){
            throw new RuntimeException("Element not clickable "+locator,e);
        }
    }
    public void pressEnterOnElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new RuntimeException("Element not clickable: " + locator, e);
        }
    }
    public String getElementText(By locator){
        try {
            WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        }
        catch (Exception e){
            throw new RuntimeException("Text not visible "+locator,e);
        }
    }
    public String getElementText(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        }
        catch (Exception e){
            throw new RuntimeException("Text not visible ");
        }
    }
    public List<WebElement> getElements(By element){
        try {
            return  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        }
        catch (Exception e){
            throw new RuntimeException("Elements not visible "+element,e);
        }
    }
    public void sendKeys(By locator,String data){
        try {
            WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(data);
        }
        catch (Exception e){
            throw new RuntimeException("Element not visible "+locator,e);
        }
    }

}
