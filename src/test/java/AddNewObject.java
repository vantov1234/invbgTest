import UI.LoginPage;
import UI.Objects;
import UI.utils.Do;
import UI.utils.PagesCommonElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddNewObject {
    @Before
    public void startBrowser() throws Exception {
        Do.startBrowser("chrome");
    }

    @After
    public void quit() {
        Do.closeBrowser();
    }

    @Test
    public void addNewObject() {
        LoginPage.successfulLogin();
        Do.clickOn(PagesCommonElements.tabObjects);
        Do.clickOn(Objects.newObject);
        Objects.createObject("Минерална вода 1,5л.", "3", "2");
        Do.clickOn(Objects.doSubmitNewObject);
        Do.assertWebElementPresent(Objects.successMessage);
        {
            System.out.println(Do.recogniseElement(Objects.successMessage).getText());
        }
    }
}
