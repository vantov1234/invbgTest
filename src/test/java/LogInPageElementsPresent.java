
import UI.LoginPage;
import org.junit.*;
import UI.utils.Do;

public class LogInPageElementsPresent {

    @BeforeClass
    public static void openBrowser() {
        Do.startBrowser("chrome");
    }

    @AfterClass
    public static void quit() {
        Do.closeBrowser();
    }

    @Test
    public void ContactWithOperator() {
        Do.assertWebElementText(LoginPage.logInLinkContactWithOperator, "Връзка с оператор");
    }

    @Test
    public void checkWorkTimePresent() {
        Do.assertWebElementText(LoginPage.logInWorkTime, "Понеделник-Петък 09:00-18:00");
    }

    @Test
    public void checkContactPhonePresent() {
        Do.assertWebElementText(LoginPage.logInContactPhone, "0700 44 111");
    }

    @Test
    public void checkSiteLogoPresent() {
        Do.recogniseElement(LoginPage.logInSiteLogo).isDisplayed();
    }
}