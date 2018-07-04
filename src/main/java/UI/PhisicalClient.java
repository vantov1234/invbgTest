package UI;

import UI.utils.Do;

public class PhisicalClient {
    public static final String addNewClient = "Нов клиент";
    public static final String pageTitle = "//div[@id='headline2']/h2";
    public static final String searchButton = "searchbtn";
    public static final String closeSearchButton = "searchbtn2";
    public static final String orCloseSearchButton = "orclose";
    public static final String searchByNameField = "fnm";
    public static final String searchByAddressField = "adr";
    public static final String searchByCorrespondentField = "unm";
    public static final String searchByBulstatField = "bst";
    public static final String searchByMolFild = "mol";
    public static final String searchByEmailField = "eml";
    public static final String searchByButton = "s";
    public static final String choosePhisicalClient = "//div[@id='tipfaktura']/label/span";
    public static final String doSubmitNewClient = "do_submit";
    public static final String clientIsAddedMessage = "okmsg";
    private static final String personNameField = "person_name";
    private static final String personEgnField = "person_egn";
    private static final String personAddressField = "person_address";
    private static final String personPostCodeField = "client_postcode";
    private static final String personCityField = "person_city";

    public static void createPhisClient (String person_name, String person_address, String person_city){
        Do.inputText(PhisicalClient.personNameField,person_name);
        System.out.println("Set Name: " + person_name);
        Do.inputText(PhisicalClient.personAddressField,person_address);
        System.out.println("Set Address: " + person_address);
        Do.inputText(PhisicalClient.personCityField,person_city);
        System.out.println("Set City: " + person_city);
    }

    public static void createPhisClientAll(String person_name, String person_egn, String person_address, String person_city, String client_postcode){
        createPhisClient(person_name, person_address, person_city);
        Do.inputText(PhisicalClient.personEgnField,person_egn);
        System.out.println("Set EGN: " + person_egn);
        Do.inputText(PhisicalClient.personPostCodeField,client_postcode);
        System.out.println("Set Post Code: " + client_postcode);
    }
}
