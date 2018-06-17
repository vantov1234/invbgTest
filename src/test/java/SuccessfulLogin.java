
import UI.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import UI.utils.PageAction;

public class SuccessfulLogin {

    @Before
    public void startBrowser() throws Exception {
        PageAction.startBrowser("chrome");
    }

    @After
    public void quit() {
        PageAction.closeBrowser();
    }

    @Test
    public void logIn() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.fillInputField(LoginPage.logInUserField, LoginPage.logInEmailData);
        loginPage.fillInputField(LoginPage.logInPasswordField, LoginPage.logInPasswordData);
        loginPage.buttonClick(LoginPage.logInSubmitButton);
    }
}
