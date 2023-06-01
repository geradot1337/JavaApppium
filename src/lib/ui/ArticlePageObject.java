package lib.ui;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;



public class ArticlePageObject extends MainPageObject
{
    private static final String
    TITLE = "id:org.wikipedia:id/view_page_title_text",
    OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_READING_LIST = "xpath://*[@text='Add to reading list']",
    ADD_TO_MY_READING_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_NAME_OK = "xpath://*[@text='OK']",
    CLOSE_ARTICLE_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
    FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }



    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article tittle on page", 10);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return  title_element.getAttribute("text");
    }
    public void swipeToFooter()
    {
this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article",20);
    }
    public void addArticleToMyList(String nameOfFolder)
    {
        this.waitAndClick(
            OPTIONS_BUTTON,
                "Где три точки ссаные?",
                5
        );
this.waitForElementPresent(
        OPTIONS_ADD_TO_MY_READING_LIST, "Нету добавить в реадинг лист",5

);

        this.waitAndClick(
                ADD_TO_MY_READING_LIST_OVERLAY,
                "Нет кнопки Гот Ит",
                5
        );
        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Нет инпута",
                5
        );
        this.waitAndSendKeys(
               MY_LIST_NAME_INPUT,
                nameOfFolder,
                "не удалось ввести название листа",
                5
        );
        this.waitAndClick(
                MY_LIST_NAME_OK,
                "Не удалось нажать ОКей",
                5
        );
    }
    public void closeArticle()
    {
        this.waitAndClick(
                CLOSE_ARTICLE_BTN,
                "Не удалось закрыть, нет кнопки выход",
                5
        );
    }
    public void addNotFirstArticleToMyList(String nameOfFolder)
    {
        this.waitAndClick(
                OPTIONS_BUTTON,
                "Где три точки ссаные?",
                5
        );
        this.waitForElementPresent(
             OPTIONS_ADD_TO_MY_READING_LIST, "Нету добавить в реадинг лист",5

        );


        this.waitForElementAndClear(
               MY_LIST_NAME_INPUT,
                "Нет инпута",
                5
        );
        this.waitAndSendKeys(
                MY_LIST_NAME_INPUT,
                nameOfFolder,
                "не удалось ввести название листа",
                5
        );
        this.waitAndClick(
            MY_LIST_NAME_OK,
                "Не удалось нажать ОКей",
                5
        );
    }

}
