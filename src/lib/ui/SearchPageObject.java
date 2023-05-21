package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
    SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            CLOSE_SEARCH_BTN = "org.wikipedia:id/search_close_btn",
LOCATOR = "//*[@resource-id='org.wikipedia:id/search_results_list']",
    NO_RESULTS_LABEL = "//*[@text='No results found']",
    SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

public void waitForCancelButtonToAppear()
{
    this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
}
    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }
    public void clickCancelButtun()
    {
        this.waitAndClick(By.id(SEARCH_CANCEL_BUTTON),"Cannot find search cancel button", 5);
    }
    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }
public static String getResultSearchElement(String substring)
{
    return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
}
    public void initSearchInput() {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element",5);
        this.waitAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into searchline", 5);
    }
    public void waitForSearchResult(String substring)
    {   String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring , 5);

    }
    public void clickByArticleWithSubstring(String substring)
    {   String search_result_xpath = getResultSearchElement(substring);
        this.waitAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring , 5);

    }
    public  int getAmountOfFoundArticles()
    {

        this.waitForElementPresent(
                By.xpath(LOCATOR),
                "Не удалось найти результаты по запросу: ",
                15
        );
        return this.getElementsCount(By.xpath(LOCATOR));

    }
    public void waitForEmptyResultListLabel()
    {
        this.waitForElementPresent(By.xpath(NO_RESULTS_LABEL), "Cannot find empty result label", 5);
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "Wa suppossed not find any results");
    }
    public void closeSearchWindow()
    {
        this.waitAndClick(
                By.id(CLOSE_SEARCH_BTN),
                "Cannot find 'Close Btn'",
                5
        );
    }
    public void assertSearchInputIsNull()
    {
    this.waitForElementPresent(By.xpath(SEARCH_INPUT), "Search input is not null",2);
    }
}
