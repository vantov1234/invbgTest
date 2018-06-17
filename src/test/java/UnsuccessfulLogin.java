import UI.LoginPage;
import UI.utils.PageAction;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnsuccessfulLogin {

    String email;
    String password;

    @Parameterized.Parameters
    public static String[][] testLogInData() {
        String[][] testLogInData = {
                {"valentinantov@yahoo.com", "valio1"},
                {"valentinantov@yahoo.com", ""},
                {"valentinantov yahoo.com", "valio123"},
                {"valentinantov@yahoo.co", "valio123"},
                {"", "valio123"}
        };
        return testLogInData;
    }

    public UnsuccessfulLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Before
    public void openBrowser() {
        PageAction.startBrowser("chrome");
    }

    @After
    public void closeBrowser() {
        PageAction.closeBrowser();
    }

    @Test
    public void UnsuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.fillInputField(LoginPage.logInUserField, this.email);
        PageAction.assertWebElementPresent(LoginPage.logInUserField);
        loginPage.fillInputField(LoginPage.logInPasswordField, this.password);
        PageAction.assertWebElementPresent(LoginPage.logInPasswordField);
        loginPage.buttonClick(LoginPage.logInSubmitButton);
        PageAction.assertWebElementPresent(LoginPage.LogInErrorMessage);
    }
}