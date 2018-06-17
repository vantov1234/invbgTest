package UI.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

public class PageAction {

    private static final String logInUrl = "https://testvalio.inv.bg/login";
    private static final String chromeBrowserKey = "webdriver.chrome.driver";
    private static final String chromeBrowserPath = "D:/Selenuim_drivers/chromedriver.exe";
    private static final String firefoxBrowserKey = "webdriver.gecko.driver";
    private static final String firefoxBrowserPath = "D:/Selenuim_drivers/geckodriver-v0.18.0-win64/geckodriver.exe";
    private static final String ieBrowserKey = "webdriver.ie.driver";
    private static final String ieBrowserPath = "D:/Selenuim_drivers/MicrosoftWebDriver.exe";
    public static WebDriver driver;

    private static void configureBrowser() {
        driver.get(PageAction.logInUrl);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    public static void startBrowser(String chooseBrowser) {
        if (chooseBrowser.equalsIgnoreCase("firefox")) {
            System.setProperty(PageAction.firefoxBrowserKey, PageAction.firefoxBrowserPath);
            driver = new FirefoxDriver();
            configureBrowser();
        }
        if (chooseBrowser.equalsIgnoreCase("chrome")) {
            System.setProperty(PageAction.chromeBrowserKey, PageAction.chromeBrowserPath);
            driver = new ChromeDriver();
            configureBrowser();
        }
        if (chooseBrowser.equalsIgnoreCase("ie")) {
            System.setProperty(PageAction.ieBrowserKey, PageAction.ieBrowserPath);
            driver = new InternetExplorerDriver();
            configureBrowser();
        }
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
            System.out.println("Provided locator is a css");
        } catch (Exception e1) {
            try {
                e = driver.findElement(By.linkText(element));
                System.out.println("Provided locator is a link");
            } catch (Exception e2) {
                try {
                    e = driver.findElement(By.id(element));
                    System.out.println("Provided locator is an id");
                } catch (Exception e3) {
                    try {
                        e = driver.findElement(By.xpath(element));
                        System.out.println("Provided locator is a xpath");
                    } catch (Exception e4) {
                        System.out.println("No such element");
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

    public void fillInputField(String locatorInputField, String data) {
        PageAction.recogniseElement(locatorInputField).sendKeys(data);
    }

    public void buttonClick(String button) {
        PageAction.recogniseElement(button).click();
    }
}