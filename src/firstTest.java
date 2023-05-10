import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class firstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/alexandremelyanov/Desktop/javaAppium/JavaApppium/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search input",
                5

        );

        waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic seraching by Java",
                15
        );

    }

    @Test
    public void testCancelSearch() {
        waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                10
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );
        waitForElementAndCkear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );
        waitAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find 'Close Btn'",
                5
        );
        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Close btn still present'",
                5
        );
    }

    @Test
    public void testCompareArticle() {
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );
        waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования'",
                5
        );
        WebElement title = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article titile",
                15
        );
        String article_title = title.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)1",
                article_title
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");

        return wait.until(

                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitAndClick(By by, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.click();
        return element;
    }

    private WebElement waitAndSendKeys(By by, String value, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndCkear(By by, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.clear();
        return element;
    }


}
