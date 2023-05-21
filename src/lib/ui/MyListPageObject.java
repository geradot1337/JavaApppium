package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject{
    public static final String
    FOLDER_BY_NAME_TPL ="//*[@text='{FOLDER_NAME}']",
    ARTICLE_BY_TITLE_TPL="//*[text='{ARTICLE_NAME}']";
    public MyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }
    private static String getSaveArticleByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_NAME}", article_title);
    }
    public void openFolderByName(String name_of_folder)
    { String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitAndClick(
                By.xpath(folder_name_xpath),
                "Нет созданного списка",
                10
        );
    }
    public void swipeArticleToDelete(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeToLeft(
                By.xpath(article_xpath),
                "нет нужной статьи"
        );
        this.waitForArticleToDisappearByTittle(article_title);
    }
    public void waitForArticleToDisappearByTittle(String article_title)
    { this.waitForArticleToAppearByTittle(article_title);
        String article_xpath = getFolderXpathByName(article_title);
       this.waitForElementNotPresent(
                By.xpath(article_xpath) ,
                "Saved article still present with title " + article_title,
                15
       );
    }
    public void waitForArticleToAppearByTittle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(
                By.xpath(article_xpath) ,
                "Cannot find saved article by title " + article_title,
                15
        );
    }

}
