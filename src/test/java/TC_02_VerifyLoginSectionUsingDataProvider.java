
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.HomePage;

import java.io.File;
import java.io.IOException;

public class TC_02_VerifyLoginSectionUsingDataProvider extends BaseTests{
 @DataProvider(name="LoginData")
 public Object[][] userLoginData() throws IOException {
     return new Object[][] {{"TC_01","mngr620764", "radyzyb", "Success", "Manger Id : mngr620764"},
             {"TC_02","mngr620734", "radyz123", "Failure", "User or Password is not valid"},
             {"TC_03","", "", "Failure", "User or Password is not valid"},
             {"TC_04","mngr123456", "", "Failure", "User or Password is not valid"},
             {"TC_05","", "qwerty123", "Failure", "User or Password is not valid"}};
 }
    @BeforeMethod
    public void testSetup() {
        // Clear cookies and cache before each test
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor)driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor)driver).executeScript("window.sessionStorage.clear();");
        //driver.get(Util.baseUrl);
    }
    @Test(dataProvider = "LoginData")
    public void verifyLogin(String testID,String username, String password, String expectedResultType, String expectedResultValue) throws IOException {
        loginPage.enterValidUserId(username);
        loginPage.enterValidPassword(password);
        HomePage homePage=loginPage.clickLogin();
        if(expectedResultType.equalsIgnoreCase("Success")){
            String response=loginPage.validateThatLoginSuccess();
            Assert.assertEquals(expectedResultValue,response);
            homePage.clickLogout();
            homePage.clickOnPopUpLogout();
        }
        else if(expectedResultType.equalsIgnoreCase("Failure")){
            String response=loginPage.validateThatLoginFailed();
            Assert.assertEquals(response,expectedResultValue);
            String pageTitle= browserActions.getPageTitle();
            Assert.assertEquals(pageTitle,"Guru99 Bank Home Page");
        }
    File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("target/screenshots/"+testID+".png"));

    }
}
