import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;


public class firstTest  extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }
    @Test
    public void testSearch() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForSearchResult("Automation for Apps");

    }

    @Test
    public void testCancelSearch() {
        MainPageObject.waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                10
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );
        MainPageObject.waitAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find 'Close Btn'",
                5
        );
        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Close btn still present'",
                5
        );
    }

    @Test
    public void testCompareArticle() {
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Appium",
                "Cannot find search input",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Automation for Apps']"),
                "Cannot find 'язык программирования'",
                5
        );
        WebElement title = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        String article_title = title.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected title",
                "Appium",
                article_title
        );
    }
    @Test
    public void testSwipeArticle() {
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Appium",
                "Cannot find search input",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Cannot find 'язык программирования'",
                5
        );
        MainPageObject.swipeUpToFindElement(
        By.xpath("//*[@text='View page in browser']"),
        "Не удалось найти конец стать",
        20
        );

 }
@Test
public void testSaveArticleToMyReadList()
    {
        String listName = "Learning";
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Appium",
                "Cannot find search input",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Automation for Apps']"),
                "Cannot find 'язык программирования'",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
          "Где три точки ссаные?",
                5
        );

        driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @index='3']")).click();
        MainPageObject.waitAndClick(
          By.id("org.wikipedia:id/onboarding_button"),
          "Нет кнопки Гот Ит",
                5
        );
        MainPageObject.waitForElementAndClear(
          By.id("org.wikipedia:id/text_input"),
          "Нет инпута",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                listName,
                "не удалось ввести название листа",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//*[@text='OK']"),
                "Не удалось нажать ОКей",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Не удалось закрыть, нет кнопки выход",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//*[@class='android.widget.FrameLayout' and @content-desc='My lists']"),
                "Нет кнопки мой список",
                5
        );
        MainPageObject.waitAndClick(
                By.xpath("//*[@text='"+listName+"']"),
                "Нет созданного списка",
                10
        );
        MainPageObject.swipeToLeft(
                By.xpath("//*[text='Appium']"),
                "нет нужной статьи"
        );
        MainPageObject.waitForElementNotPresent(
  By.xpath("//*[text='Appium']") ,
  "Статья еще тут",
  5
);



    }
    @Test
    public void testOfNotEmptySearch()
    {
        String search = "Linkin Park Discography";
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5
        );
        String locator = "//*[@resource-id='org.wikipedia:id/search_results_list']";
        MainPageObject.waitForElementPresent(
                By.xpath(locator),
                "Не удалось найти результаты по запросу: " + search,
                15
        );
int amount = MainPageObject.getElementsCount(By.xpath(locator));
Assert.assertTrue(
        "Нет результатов поиска",
        amount > 0
);
    }
    @Test
    public void testAmountOfEmptySearch()
    {
        String search = "qwqewewqsdfd";
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5
        );
        String locator = "//*[@resource-id='org.wikipedia:id/search_results_list']";
        String empty_serach = "//*[@text='No results found']";
        MainPageObject.waitForElementPresent(
                By.xpath(empty_serach),
"Нет текста нет результатов",
                        15
        );
        MainPageObject.assertElementNotPresent(
                By.xpath(locator),
                "Элементы все же нашлись "

        );
    }

    @Test
    public void changeScreenOrientation()
    {
        String search = "Java";
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5

        );

        MainPageObject.waitAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования'",
                8
        );
String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
By.id("org.wikipedia:id/view_page_title_text"),
        "text",
        "Cannot find title of article",
        15

);
driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
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
        String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
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
        MainPageObject.waitAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search,
                "Cannot find search input",
                5

        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования'",
                8
        );
        driver.runAppInBackground(2);
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'язык программирования' после выхода из бэкграунда",
                8
        );

    }

    }

