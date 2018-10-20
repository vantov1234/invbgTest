package UI;

import UI.utils.Do;
import UI.utils.PagesCommonElements;

public class Objects {
    public static final String newObject = "Нов Артикул";
    public static final String pageTitle = "//div[@id='headline2']/h2";
    public static final String searchButton = "searchbtn";
    private static final String nameField = "name";
    public static final String nameEngField = "name_en";
    private static final String price = "price";
    public static final String priceCurrency = "price_currency";
    private static final String pricePerQuantity = "price_quantity";
    public static final String priceQuantityUnit = "price_quantity_unit";
    public static final String doSubmitNewObject = "do_submit";
    public static final String goBack = "е върни в списъка с артикули";
    public static final String successMessage = "okmsg";
    public static final String errorMessage = "error";
    public static final String deleteObject = "Изтрий";

    public static void createObject(String objectName,String prise, String quantity){
        Do.inputText(Objects.nameField,objectName);
        System.out.println("Set Name: " + objectName);
        Do.inputText(Objects.price,prise);
        System.out.println("Set Prise: " + prise);
        Do.clearField(Objects.pricePerQuantity);
        Do.inputText(Objects.pricePerQuantity,quantity);
        System.out.println("Set Quantity: " + quantity);
        Do.clickOn(Objects.priceCurrency);
    }

    public static void deleteObject(String object){
        Do.clickOn(PagesCommonElements.tabObjects);
        Do.clickOn(object);
        Do.clickOn(Objects.deleteObject);
        Do.allertWindow("accept");
        Do.assertWebElementPresent(Objects.successMessage);{
            System.out.println(Do.recogniseElement(Objects.successMessage).getText());
        }
    }
}
