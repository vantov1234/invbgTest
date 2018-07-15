import UI.LoginPage;
import UI.PhisicalClient;
import UI.utils.Do;
import UI.utils.PagesCommonElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddNewPhisClient {

    @Before
    public void startBrowser() {
        Do.startBrowser("chrome");
    }

    @After
    public void quit() {
        Do.closeBrowser();
    }

    @Test
    public void addNewPhisicalClient() {
        LoginPage.successfulLogin();
        Do.clickOn(PagesCommonElements.tabClients);
        Do.clickOn(PhisicalClient.addNewClient);
        Do.clickOn(PhisicalClient.choosePhisicalClient);
        PhisicalClient.createPhisClient("Ivan Ivanov", "bul.Vitosha", "Sofia");
        Do.clickOn(PhisicalClient.doSubmitNewClient);
        Do.assertWebElementPresent(PhisicalClient.clientIsAddedMessage);
        {
            System.out.println(Do.recogniseElement(PhisicalClient.clientIsAddedMessage).getText());
        }
        Do.clickOn(PagesCommonElements.tabClients);
        Do.clickOn("Ivan Ivanov");
        Do.clickOn(PhisicalClient.deleteClient);
        Do.allertWindow("accept");
        Do.assertWebElementPresent(PhisicalClient.successMessage);
        System.out.println(Do.recogniseElement(PhisicalClient.successMessage).getText());
    }

    @Test
    public void addNewPhisicalClientAll() {
        LoginPage.successfulLogin();
        Do.clickOn(PagesCommonElements.tabClients);
        Do.clickOn(PhisicalClient.addNewClient);
        Do.clickOn(PhisicalClient.choosePhisicalClient);
        PhisicalClient.createPhisClientAll("Ivan Ivanov", "123456789", "bul.Vitosha", "Sofia", "1000");
        Do.clickOn(PhisicalClient.doSubmitNewClient);
        Do.assertWebElementPresent(PhisicalClient.clientIsAddedMessage);
        {
            System.out.println(Do.recogniseElement(PhisicalClient.clientIsAddedMessage).getText());
        }
        Do.clickOn(PagesCommonElements.tabClients);
        Do.clickOn("Ivan Ivanov");
        Do.clickOn(PhisicalClient.deleteClient);
        Do.allertWindow("accept");
        Do.assertWebElementPresent(PhisicalClient.successMessage);
        System.out.println(Do.recogniseElement(PhisicalClient.successMessage).getText());

    }
}