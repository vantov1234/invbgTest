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
        //Do.closeBrowser();
    }

    @Test
    public void addNewObject1() {
        LoginPage.successfulLogin();
        Do.clickOn(PagesCommonElements.tabObjects);
        Do.clickOn(Objects.newObject);
        Objects.createObject("Минерална вода 1,5л.", "3", "2");
        Do.selectFromDropdown(Objects.priceCurrency, 0);
        Do.selectFromDropdown(Objects.priceQuantityUnit, 0);
        Do.clickOn(Objects.doSubmitNewObject);
        Do.assertWebElementPresent(Objects.successMessage);
        {
            System.out.println(Do.recogniseElement(Objects.successMessage).getText());
        }
        Objects.deleteObject("Минерална вода 1,5л.");
    }

    @Test
    public void addNewObject2() {
        LoginPage.successfulLogin();
        Do.clickOn(PagesCommonElements.tabObjects);
        Do.clickOn(Objects.newObject);
        Objects.createObject("Ябълки", "5", "2");
        Do.selectFromDropdown(Objects.priceCurrency, 3);
        Do.selectFromDropdown(Objects.priceQuantityUnit, 2);
        Do.clickOn(Objects.doSubmitNewObject);
        Do.assertWebElementPresent(Objects.successMessage);
        {
            System.out.println(Do.recogniseElement(Objects.successMessage).getText());
        }
        Objects.deleteObject("Ябълки");
    }

    @Test
    public void addNewObject3() {
        LoginPage.successfulLogin();
        Do.clickOn(PagesCommonElements.tabObjects);
        Do.clickOn(Objects.newObject);
        Objects.createObject("Абонамент", "60", "1");
        Do.selectFromDropdown(Objects.priceCurrency, 12);
        Do.selectFromDropdown(Objects.priceQuantityUnit, 3);
        Do.clickOn(Objects.doSubmitNewObject);
        Do.assertWebElementPresent(Objects.successMessage);
        {
            System.out.println(Do.recogniseElement(Objects.successMessage).getText());
        }
        Objects.deleteObject("Абонамент");
    }
}
