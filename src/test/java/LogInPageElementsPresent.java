
import UI.LoginPage;
import org.junit.*;
import UI.utils.PageAction;

public class LogInPageElementsPresent {

    @BeforeClass
    public static void openBrowser() {
        PageAction.startBrowser("chrome");
    }

    @AfterClass
    public static void quit() {
        PageAction.closeBrowser();
    }

    @Test
    public void ContactWithOperator() {
        PageAction.assertWebElementText(LoginPage.logInLinkContactWithOperator, "Връзка с оператор");
    }

    @Test
    public void checkWorkTimePresent() {
        PageAction.assertWebElementText(LoginPage.logInWorkTime, "Понеделник-Петък 09:00-18:00");
    }

    @Test
    public void checkContactPhonePresent() {
        PageAction.assertWebElementText(LoginPage.logInContactPhone, "0700 44 111");
    }

    @Test
    public void checkSiteLogoPresent() {
        PageAction.recogniseElement(LoginPage.logInSiteLogo).isDisplayed();
    }
}