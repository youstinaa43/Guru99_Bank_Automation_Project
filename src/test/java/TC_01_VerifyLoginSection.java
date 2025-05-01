
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.HomePage;

import java.io.IOException;

public class TC_01_VerifyLoginSection extends BaseTests{
 @DataProvider(name="ExcelLoginData")
 public Object[][] userLoginData() throws IOException {
     ExcelReader reader=new ExcelReader();
     return reader.getExcelData();
 }
    @BeforeMethod
    public void testSetup() {
        // Clear cookies and cache before each test
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor)driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor)driver).executeScript("window.sessionStorage.clear();");
        //driver.get(Util.baseUrl);
    }
    @Test(dataProvider = "ExcelLoginData")
    public void verifyLogin(String testCaseID, String username, String password, String expectedResultType, String expectedResultValue){
        loginPage.enterValidUserId(username);
        loginPage.enterValidPassword(password);
        HomePage homePage=loginPage.clickLogin();
        if(expectedResultType.equalsIgnoreCase("Success")){
            String response=loginPage.validateThatLoginSuccess();
            Assert.assertEquals(response,expectedResultValue);
            String pageTitle= browserActions.getPageTitle();
            Assert.assertEquals(pageTitle,"Guru99 Bank Manager HomePage");
            homePage.clickLogout();
            homePage.clickOnPopUpLogout();
        }
        else if(expectedResultType.equalsIgnoreCase("Failure")){
            String response=loginPage.validateThatLoginFailed();
            Assert.assertEquals(response,expectedResultValue);
            String pageTitle= browserActions.getPageTitle();
            Assert.assertEquals(pageTitle,"Guru99 Bank Home Page");
        }


    }
}
