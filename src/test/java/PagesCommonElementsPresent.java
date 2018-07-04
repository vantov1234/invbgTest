
import UI.Home;
import UI.LoginPage;
import UI.utils.PagesCommonElements;
import org.junit.*;
import UI.utils.Do;

public class PagesCommonElementsPresent {
    @BeforeClass
    public static void openBrowser() {
        Do.startBrowser("chrome");
        LoginPage.successfulLogin();
    }

    @AfterClass
    public static void closeBrowser() {
        Do.closeBrowser();
    }

    @Test
    public void checkHomePageTitlePresent() {
        Do.assertWebElementText(Home.title,"Система за фактуриране");
    }
    @Test
    public void checkHeaderUnusedPresent(){
        Do.assertWebElementPresent(PagesCommonElements.headerUnused);
    }
    @Test
    public void checkSystemMessagesPresent() {
        Do.assertWebElementPresent(PagesCommonElements.systemMessages);
    }
    @Test
    public void checkConfigurePresent() {
        Do.assertWebElementPresent(PagesCommonElements.configure);
    }
    @Test
    public void checkSubscriptionPresent() {
        Do.assertWebElementPresent(PagesCommonElements.subscription);
    }
    @Test
    public void checkHelpPresent() {
        Do.assertWebElementPresent(PagesCommonElements.help);
    }
    @Test
    public void checkUserPanelPresent() {
        Do.assertWebElementPresent(PagesCommonElements.userPanel);
    }
    @Test
    public void checkUniversalSearchInputFieldPresent() {
        Do.assertWebElementPresent(PagesCommonElements.universalSearchInputField);
    }
    @Test
    public void checkSearchButtonPresent() {
        Do.assertWebElementPresent(PagesCommonElements.universalSearchButton);
    }
    @Test
    public void checkCancelSearchPresent() {
        Do.inputText(PagesCommonElements.universalSearchInputField,"search");
        Do.assertWebElementPresent(PagesCommonElements.cancelSearch);
    }
}
