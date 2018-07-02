package UI;

import UI.utils.PageAction;

public class PhisicalClient extends PageAction {
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
    public static final String personNameField = "person_name";
    public static final String personEgnField = "person_egn";
    public static final String personAddressField = "person_address";
    public static final String personPostCodeField = "client_postcode";
    public static final String personCityField = "person_city";
    public static final String clientIsAddedMessage = "okmsg";

    //public static final String firmNameField = "//div[@id='hdr2']/div[4]/div";
    //public static final String firmTownField = "firm_town";
    //public static final String firmAddrField = "firm_addr";

    private String person_name;
    private String person_city;
    private String person_address;
    private String person_egn;
    private String client_postcode;

    public String getPersonEgn() {
        return person_egn;
    }

    public String getPersonPostCode() {
        return client_postcode;
    }

    public String getPersonName() {
        return person_name;
    }

    public String getPersonAddress() {
        return person_address;
    }

    public String getPersonCity() {
        return person_city;
    }

    public PhisicalClient(String person_name, String person_address, String person_city) {
        this.person_name = person_name;
        this.person_address = person_address;
        this.person_city = person_city;
    }

    public PhisicalClient(String person_name, String person_egn, String person_address, String person_city, String client_postcode) {
        this(person_name, person_address, person_city);
        this.person_egn = person_egn;
        this.client_postcode = client_postcode;
    }

}
