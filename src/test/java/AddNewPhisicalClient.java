import UI.LoginPage;
import UI.PhisicalClient;
import UI.utils.PageAction;
import UI.utils.PagesCommonElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddNewPhisicalClient {
    @Before
    public void startBrowser () throws Exception{
        PageAction.startBrowser("chrome");
    }

    @After
    public void quit(){
        PageAction.closeBrowser();
    }

    @Test
    public void addNewPhisicalClient(){
        LoginPage logIn = new LoginPage();
        logIn.fillInputField(LoginPage.logInUserField, LoginPage.logInEmailData);
        logIn.fillInputField(LoginPage.logInPasswordField, LoginPage.logInPasswordData);
        logIn.buttonClick(LoginPage.logInSubmitButton);
        PagesCommonElements pagesCommonElements = new PagesCommonElements();
        pagesCommonElements.buttonClick(PagesCommonElements.tabClients);
        PhisicalClient phisicalClient = new PhisicalClient("Ivan Ivanov","Sofia","'Solunska'str");
        phisicalClient.buttonClick(PhisicalClient.addNewClient);
        phisicalClient.buttonClick(PhisicalClient.choosePhisicalClient);
        phisicalClient.fillInputField(PhisicalClient.personNameField,phisicalClient.getPersonName());
        phisicalClient.fillInputField(PhisicalClient.personAddressField,phisicalClient.getPersonAddress());
        phisicalClient.fillInputField(PhisicalClient.personCityField,phisicalClient.getPersonCity());
        phisicalClient.buttonClick(PhisicalClient.doSubmitNewClient);
        phisicalClient.assertWebElementPresent(PhisicalClient.clientIsAddedMessage);
    }

    @Test
    public void addNewPhisicalClientAll(){
        LoginPage logIn = new LoginPage();
        logIn.fillInputField(LoginPage.logInUserField, LoginPage.logInEmailData);
        logIn.fillInputField(LoginPage.logInPasswordField, LoginPage.logInPasswordData);
        logIn.buttonClick(LoginPage.logInSubmitButton);
        PagesCommonElements pagesCommonElements = new PagesCommonElements();
        pagesCommonElements.buttonClick(PagesCommonElements.tabClients);
        PhisicalClient phisicalClientAll = new PhisicalClient("Georgi Georgiev","789456123","'Bulgaria'blvd","Sofia","1000");
        phisicalClientAll.buttonClick(PhisicalClient.addNewClient);
        phisicalClientAll.buttonClick(PhisicalClient.choosePhisicalClient);
        phisicalClientAll.fillInputField(PhisicalClient.personNameField,phisicalClientAll.getPersonName());
        phisicalClientAll.fillInputField(PhisicalClient.personAddressField,phisicalClientAll.getPersonAddress());
        phisicalClientAll.fillInputField(PhisicalClient.personCityField,phisicalClientAll.getPersonCity());
        phisicalClientAll.fillInputField(PhisicalClient.personEgnField,phisicalClientAll.getPersonEgn());
        phisicalClientAll.fillInputField(PhisicalClient.personPostCodeField,phisicalClientAll.getPersonPostCode());
        phisicalClientAll.buttonClick(PhisicalClient.doSubmitNewClient);
        phisicalClientAll.assertWebElementPresent(PhisicalClient.clientIsAddedMessage);
    }
}
