
import UI.LoginPage;
import UI.utils.PagesCommonElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import UI.utils.Do;

public class SuccessfulLogin {

    @Before
    public void startBrowser() {
        Do.startBrowser("chrome");
    }

    @After
    public void quit() {
        Do.closeBrowser();
    }

    @Test
    public void logIn() {
        LoginPage.successfulLogin();
        Do.assertWebElementPresent(PagesCommonElements.userPanel);{
            System.out.println("Successful login!");
        }
    }
}
