package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";

                OPTIONS_ADD_TO_MY_READING_LIST = "id:Save for later";
                ADD_TO_MY_READING_LIST_OVERLAY = "id:Save for later";
                CLOSE_ARTICLE_BTN = "id:Back";
                FOOTER_ELEMENT = "id:View article in browser";
    }
    public IOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
