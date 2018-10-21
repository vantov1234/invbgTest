package UI.utils;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Do {

    private static final String logInUrl = "https://testvalio.inv.bg/login";
    private static final String chromeBrowserKey = "webdriver.chrome.driver";
    private static final String chromeBrowserPath = "D:/Selenuim_drivers/chromedriver.exe";
    private static final String firefoxBrowserKey = "webdriver.gecko.driver";
    private static final String firefoxBrowserPath = "D:/Selenuim_drivers/geckodriver-v0.18.0-win64/geckodriver.exe";
    private static final String ieBrowserKey = "webdriver.ie.driver";
    private static final String ieBrowserPath = "D:/Selenuim_drivers/MicrosoftWebDriver.exe";
    private static WebDriver driver;

    public static void startBrowser(String chooseBrowser) {
        if (chooseBrowser.equalsIgnoreCase("firefox")) {
            System.out.println("Opening Mozilla Firefox...");
            System.setProperty(Do.firefoxBrowserKey, Do.firefoxBrowserPath);
            driver = new FirefoxDriver();
            configureBrowser();
        }
        if (chooseBrowser.equalsIgnoreCase("chrome")) {
            System.out.println("Opening Google Chrome...");
            System.setProperty(Do.chromeBrowserKey, Do.chromeBrowserPath);
            driver = new ChromeDriver();
            configureBrowser();
        }
        if (chooseBrowser.equalsIgnoreCase("ie")) {
            System.out.println("Opening Microsoft Edge...");
            System.setProperty(Do.ieBrowserKey, Do.ieBrowserPath);
            driver = new InternetExplorerDriver();
            configureBrowser();
        }
    }

    private static void configureBrowser() {
        driver.get(Do.logInUrl);
        System.out.println("Going to " + logInUrl);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void assertWebElementText(String element, String expectedText) {
        WebElement e = recogniseElement(element);
        String actualText = e.getText();
        if (!actualText.equals(expectedText)) {
            System.out.println("Expects: " + expectedText + " but found: " + actualText);
            Assert.assertTrue(false);
        } else {
            System.out.print("Expected and actual results are equal");
        }
    }

    public static WebElement recogniseElement(String element) {
        WebElement e = null;
        try {
            e = driver.findElement(By.cssSelector(element));
            //System.out.println("Provided locator is a css");
        } catch (Exception e1) {
            try {
                e = driver.findElement(By.linkText(element));
                //System.out.println("Provided locator is a link");
            } catch (Exception e2) {
                try {
                    e = driver.findElement(By.id(element));
                    //System.out.println("Provided locator is an id");
                } catch (Exception e3) {
                    try {
                        e = driver.findElement(By.xpath(element));
                        //System.out.println("Provided locator is a xpath");
                    } catch (Exception e4) {
                        try {
                            e = driver.findElement(By.name(element));
                            //System.out.println("Provided locator is a name");
                        } catch (Exception e5) {
                            System.out.println("No such element");
                        }
                    }
                }
            }
        }
        return e;
    }

    public static void assertWebElementPresent(String element) {
        WebElement e = recogniseElement(element);
        Assert.assertTrue(e.isDisplayed());
    }

    public static void inputText(String locatorInputField, String data) {
        Do.recogniseElement(locatorInputField).sendKeys(data);
    }

    public static void clearField(String locatorInputField) {
        Do.recogniseElement(locatorInputField).clear();

    }

    public static void clickOn(String button) {
        Do.recogniseElement(button).click();
    }

    public static void selectFromDropdown(String element, int index) {
        Do.clickOn(element);
        Select drop = new Select(Do.recogniseElement(element));
        drop.selectByIndex(index);
        System.out.println(drop.toString());
    }

    public static void allertWindow(String action) {
        Alert alert = Do.driver.switchTo().alert();
        if (action == "accept") {
            alert.accept();
        }
        if (action == "dismiss") {
            alert.dismiss();
        }

    }
}
