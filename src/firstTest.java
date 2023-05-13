import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

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
    driver.rotate(ScreenOrientation.PORTRAIT);
    }

    //@After
    //public void tearDown() {

   // }

    @Test
    public void Test() {
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
        waitForElementAndClear(
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
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Automation for Apps']"),
                "Cannot find 'язык программирования'",
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
                "Java (programming language)1",
                article_title
        );
    }
    @Test
    public void testSwipeArticle() {
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
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Cannot find 'язык программирования'",
                5
        );
swipeUpToFindElement(
        By.xpath("//*[@text='View page in browser']"),
        "Не удалось найти конец стать",
        20
        );

 }
@Test
public void saveArticleToMyReadList()
    {
        String listName = "Learning";
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
                "Cannot find 'язык программирования'",
                5
        );
        waitAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
          "Где три точки ссаные?",
                5
        );

        driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @index='3']")).click();
        waitAndClick(
          By.id("org.wikipedia:id/onboarding_button"),
          "Нет кнопки Гот Ит",
                5
        );
        waitForElementAndClear(
          By.id("org.wikipedia:id/text_input"),
          "Нет инпута",
                5
        );
        waitAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                listName,
                "не удалось ввести название листа",
                5
        );
        waitAndClick(
                By.xpath("//*[@text='OK']"),
                "Не удалось нажать ОКей",
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
                By.xpath("//*[@text='"+listName+"']"),
                "Нет созданного списка",
                10
        );
        swipeToLeft(
                By.xpath("//*[text='Appium']"),
                "нет нужной статьи"
        );
waitForElementNotPresent(
  By.xpath("//*[text='Appium']") ,
  "Статья еще тут",
  5
);



    }
    @Test
    public void testOfNotEmptySearch()
    {
        String search = "Linkin Park Discography";
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5
        );
        String locator = "//*[@resource-id='org.wikipedia:id/search_results_list']";
        waitForElementPresent(
                By.xpath(locator),
                "Не удалось найти результаты по запросу: " + search,
                15
        );
int amount = getElementsCount(By.xpath(locator));
Assert.assertTrue(
        "Нет результатов поиска",
        amount > 0
);
    }
    @Test
    public void testAmountOfEmptySearch()
    {
        String search = "Java";
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5
        );
        String locator = "//*[@resource-id='org.wikipedia:id/search_results_list']";
        String empty_serach = "//*[@text='No results found']";
        waitForElementPresent(
                By.xpath(empty_serach),
"Нет текста нет результатов",
                        15
        );
        assertElementNotPresent(
                By.xpath(locator),
                "Элементы все же нашлись "

        );
    }
    private WebElement waitForElementPresent(By by, String error_message, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");

        return wait.until(

                ExpectedConditions.presenceOfElementLocated(by)
        );

    }
    @Test
    public void changeScreenOrientation()
    {
        String search = "Java";
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5

        );

        waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования'",
                8
        );
String title_before_rotation = waitForElementAndGetAttribute(
By.id("org.wikipedia:id/view_page_title_text"),
        "text",
        "Cannot find title of article",
        15

);
driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );
        Assert.assertEquals(
                "Article tittle have been change after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
        driver.rotate(ScreenOrientation.PORTRAIT);
        String title_after_second_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );
        Assert.assertEquals(
                "Article tittle have been change after screen rotation",
                title_before_rotation,
                title_after_second_rotation
                );
    }
@Test
public void appToBackground()
    {
        String search = "Java";
        waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5

        );

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования'",
                8
        );
        driver.runAppInBackground(2);
        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования' после выхода из бэкграунда",
                8
        );

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

    private WebElement waitForElementAndClear(By by, String error_message, long timeout) {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.clear();
        return element;
    }
protected void swipeUp(int timeOfSwipe)
{
    TouchAction action = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();
    int x = size.width/2;
    int start_y = (int) (size.height * 0.8);
    int end_y = (int) (size.height * 0.2);
    action
            .press(x, start_y)
            .waitAction(timeOfSwipe)
            .moveTo(x, end_y)
            .release()
            .perform();
}
protected void swipeUpQuick()
    {
        swipeUp(200);
    }
    protected void swipeUpToFindElement(By by, String error_message, int max_swipes)
    {
int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {
        if (already_swipe > max_swipes){
            waitForElementPresent(by, "Не удалось найти эелемент " + by + "\n" + error_message, 0);
        }
            swipeUpQuick();
        ++already_swipe;
        }
        }
       protected void swipeToLeft(By by, String error_message)
       {
        WebElement element =   waitForElementPresent(by,
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
       private int getElementsCount(By by)
       {
           List elements = driver.findElements(by);
           return elements.size();
       }
       private void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_elements = getElementsCount(by);
        if (amount_of_elements > 0 )
        {
            String message = "An element "+ by.toString()+ " supposed to be not present";
            throw new AssertionError(message + " " + error_message);
        }
    }
    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeout)
    {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        return element.getAttribute(attribute);
    }
    }

