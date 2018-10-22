package UI;

import UI.utils.Do;

public class LoginPage {
    public static final String logInSiteLogo = "//img[@src=\"/imgs/external/ex_logo_small.gif\" and @alt='inv.bg - ÑÐ¸ÑÑ‚ÐµÐ¼Ð° Ð·Ð° Ð¾Ð½Ð»Ð°Ð¹Ð½ Ñ„Ð°ÐºÑ‚ÑƒÑ€Ð¸Ñ€Ð°Ð½Ðµ']";
    public static final String logInWelcomeUser = "'wellcome']/h2";
    public static final String logInUserField = "loginusername";
    public static final String logInPasswordField = "loginpassword";
    public static final String logInSubmitButton = "loginsubmit";
    public static final String logInRememberPasswordCheckBox = "persistent";
    public static final String logInLinkContactWithOperator = "Ð’Ñ€ÑŠÐ·ÐºÐ° Ñ Ð¾Ð¿ÐµÑ€Ð°Ñ‚Ð¾Ñ€";
    public static final String logInContactPhone = "div.phone";
    public static final String logInWorkTime = "div.worktime";
    public static final String logInErrorMessage = "error";
    public static final String logInEmailData = "valentinantov@yahoo.com";
    public static final String logInPasswordData = "valio123";

    public static void successfulLogin(){
        Do.clearField(logInUserField);
        Do.inputText(logInUserField,logInEmailData);
        System.out.println("Login with email: " + logInEmailData);
        Do.clearField(logInPasswordField);
        Do.inputText(logInPasswordField,logInPasswordData);
        System.out.println("Entering password: " + logInPasswordData);
        Do.clickOn(logInSubmitButton);
    }

}
