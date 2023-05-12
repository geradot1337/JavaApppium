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


public class Ex5 {
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
    public void twoArticleSaveTest()
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

        waitAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Не нажались три точки",
                10
        );

waitAndClick(
  By.xpath("//android.widget.LinearLayout[@index='3']"),
  "Нет кнопки add to reading list",
  10
);
waitAndClick(
        By.xpath("//*[@text='GOT IT']"),
        "Нет кнопки got it",
5
        );
waitForElementAndClear(
        By.id("org.wikipedia:id/text_input"),
        "Не удалось очистить поле ввода",
        5
);


waitAndSendKeys(
        By.id("org.wikipedia:id/text_input"),
        "",
        "Не удалось ввести текст названия коллекци",
        5
);

        waitAndClick(
                By.xpath("//*[@text='OK']"),
                "Нет кнопки got it",
                5
        );
        waitAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Не удалось закрыть, нет кнопки выход",
                5
        );
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
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Roman censor in 312 BC']"),
                "Cannot find  second article",
                5
        );
        waitAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Не нажались три точки",
                10
        );

        waitAndClick(
                By.xpath("//android.widget.LinearLayout[@index='3']"),
                "Нет кнопки add to reading list",
                10
        );
        waitAndClick(
                By.xpath("//*[@text='Learning']"),
                "Не найдена коллекция",
                5
        );
        waitAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Не удалось закрыть, нет кнопки выход",
                5
        );
        waitAndClick(
                By.xpath("//*[@class='android.widget.FrameLayout' and @content-desc='My lists']"),
                "Нет кнопки мой список",
                5
        );
        waitAndClick(
                By.xpath("//*[@text='Learning']"),
                "Нет созданного списка",
                10
        );
        swipeToLeft(
                By.xpath("//*[text='Appium']"),
                "нет нужной статьи"
        );
        waitForElementPresent(
                By.xpath("//*[@text='Appius Claudius Caecus']"),
                "Второй статьи нет",
                5
        );
        waitAndClick(
                By.xpath("//*[@text='Appius Claudius Caecus']"),
                "Второй статьи нет",
                5
        );
        WebElement title = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        String article_title = title.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected title",
                "Appius Claudius Caecus",
                article_title
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
