package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class ArticlePageObject extends MainPageObject
{
    private static final String
    TITLE = "org.wikipedia:id/view_page_title_text",
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_READING_LIST = "//*[@text='Add to reading list']",
    ADD_TO_MY_READING_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_NAME_OK = "//*[@text='OK']",
    CLOSE_ARTICLE_BTN = "//android.widget.ImageButton[@content-desc='Navigate up']",
    FOOTER_ELEMENT = "//*[@text='View page in browser']";
    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void assertTittlePresent()
    {
        assertTrue(
               "Tittle is not displayed",
                driver.findElement(By.id(TITLE)).isDisplayed()
        );

    }
    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article tittle on page", 10);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return  title_element.getAttribute("text");
    }
    public void swipeToFooter()
    {
this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT), "Cannot find the end of article",20);
    }
    public void addArticleToMyList(String nameOfFolder)
    {
        this.waitAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Где три точки ссаные?",
                5
        );
this.waitForElementPresent(
        By.xpath(OPTIONS_ADD_TO_MY_READING_LIST), "Нету добавить в реадинг лист",5

);
        driver.findElement(By.xpath(OPTIONS_ADD_TO_MY_READING_LIST)).click();
        this.waitAndClick(
                By.id(ADD_TO_MY_READING_LIST_OVERLAY),
                "Нет кнопки Гот Ит",
                5
        );
        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Нет инпута",
                5
        );
        this.waitAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                nameOfFolder,
                "не удалось ввести название листа",
                5
        );
        this.waitAndClick(
                By.xpath(MY_LIST_NAME_OK),
                "Не удалось нажать ОКей",
                5
        );
    }
    public void closeArticle()
    {
        this.waitAndClick(
                By.xpath(CLOSE_ARTICLE_BTN),
                "Не удалось закрыть, нет кнопки выход",
                5
        );
    }
    public void addNotFirstArticleToMyList(String nameOfFolder)
    {
        this.waitAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Где три точки ссаные?",
                5
        );
        this.waitForElementPresent(
                By.xpath(OPTIONS_ADD_TO_MY_READING_LIST), "Нету добавить в реадинг лист",5

        );
        driver.findElement(By.xpath(OPTIONS_ADD_TO_MY_READING_LIST)).click();

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Нет инпута",
                5
        );
        this.waitAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                nameOfFolder,
                "не удалось ввести название листа",
                5
        );
        this.waitAndClick(
                By.xpath(MY_LIST_NAME_OK),
                "Не удалось нажать ОКей",
                5
        );
    }

}
