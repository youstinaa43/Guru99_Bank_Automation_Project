
import actions.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom.LoginPage;


public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected BrowserActions browserActions;
    @BeforeClass
    public void setUp(){
        browserActions = new BrowserActions(null); // Temporary null
        driver = browserActions.setBrowserDriver(BrowserActions.Browser.CHROME);
        browserActions = new BrowserActions(driver);
        loginPage = new LoginPage(driver);
        browserActions.openUrl(Util.baseUrl);

    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            browserActions.closeBrowser();
        }

    }
}
