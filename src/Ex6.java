import io.appium.java_client.AppiumDriver;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Ex6 {
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

    @Test
    public void assertElementPresent()
    {
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Appium",
                "Cannot find search input",
                5
        );
        waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Automation for Apps']"),
                "Cannot find article",
                5
        );

              waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                0
        );


    }
    private WebElement waitAndClick(By by, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.click();
        return element;
    }

    protected void swipeToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(by,
                error_message,
                10
        );
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y= upper_y+element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x,middle_y)
                .release()
                .perform();
    }
    private WebElement waitAndSendKeys(By by, String value, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.sendKeys(value);
        return element;
    }



    private WebElement waitForElementAndClear(By by, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.clear();
        return element;
    }


    private WebElement waitForElementPresent(By by, String error_message, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");

        return wait.until(

                ExpectedConditions.presenceOfElementLocated(by)
        );
    }



}
