import UI.LoginPage;
import UI.utils.Do;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnsuccessfulLogin {

    private String email;
    private String password;

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
        Do.startBrowser("chrome");
    }

    @After
    public void closeBrowser() {
        Do.closeBrowser();
    }

    @Test
    public void UnsuccessfulLogIn(){
        Do.inputText(LoginPage.logInUserField, this.email);
        System.out.println("Login with email: " + this.email);
        Do.inputText(LoginPage.logInPasswordField, this.password);
        System.out.println("Entering password: " + this.password);
        Do.clickOn(LoginPage.logInSubmitButton);
        Do.assertWebElementPresent(LoginPage.logInErrorMessage);{
            System.out.println("Wrong user or password!");
        }
    }
}