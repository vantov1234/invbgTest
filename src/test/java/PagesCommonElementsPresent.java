
import UI.Home;
import UI.LoginPage;
import UI.utils.PagesCommonElements;
import org.junit.*;
import UI.utils.PageAction;

public class PagesCommonElementsPresent {
    @BeforeClass
    public static void openBrowser() {
        PageAction.startBrowser("chrome");
        LoginPage loginPage = new LoginPage();
        loginPage.fillInputField(LoginPage.logInUserField, LoginPage.logInEmailData);
        loginPage.fillInputField(LoginPage.logInPasswordField,LoginPage.logInPasswordData);
        loginPage.buttonClick(LoginPage.logInSubmitButton);
    }

    @AfterClass
    public static void closeBrowser() {
        PageAction.closeBrowser();
    }

    @Test
    public void checkHomePageTitlePresent() {
        PageAction.assertWebElementText(Home.homePageTitle,"Система за фактуриране");
    }
    @Test
    public void checkHeaderUnusedPresent(){
        PageAction.assertWebElementPresent(PagesCommonElements.headerUnused);
    }
    @Test
    public void checkSystemMessagesPresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.systemMessages);
    }
    @Test
    public void checkConfigurePresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.configure);
    }
    @Test
    public void checkSubscriptionPresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.subscription);
    }
    @Test
    public void checkHelpPresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.help);
    }
    @Test
    public void checkUserPanelPresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.userPanel);
    }
    @Test
    public void checkUniversalSearchInputFieldPresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.universalSearchInputField);
    }
    @Test
    public void checkSearchButtonPresent() {
        PageAction.assertWebElementPresent(PagesCommonElements.universalSearchButton);
    }
    @Test
    public void checkCancelSearchPresent() {
        PagesCommonElements cancelSearch = new PagesCommonElements();
        cancelSearch.fillInputField(PagesCommonElements.universalSearchInputField,"search");
        PageAction.assertWebElementPresent(PagesCommonElements.cancelSearch);
    }
}
