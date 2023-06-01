package lib.ui;

import io.appium.java_client.AppiumDriver;


public class WelcomePageObject extends MainPageObject
{
    private static final String
    LEARN_MORE_XPATH = "xpath://XCUIElementTypeStaticText[@name=\"Узнать подробнее о Википедии\"]",
    NEW_WAYS = "xpath://XCUIElementTypeStaticText[@name=\"Новые способы изучения\"]",
    LEARN_MORE_ABOUT_DATA = "id:Помогите сделать это приложение лучше",
    NEXT_BTN ="xpath://XCUIElementTypeButton[@name='Далее']",
    FIND_LANGUAGE_BTN = "id:Искать на почти 300 языках",
    GET_STARTED_BTN = "xpath://XCUIElementTypeStaticText[@name='Начать']";
    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
public void waitForLearnMoreLink()
{
    this.waitForElementPresent(LEARN_MORE_XPATH,
            "Cannot find узнать подробнее о Википедии",5);
}
public void clickNextBtn()
{
    this.waitAndClick(NEXT_BTN,
            "Cannot find 'Далее' btn",5);
}
public void waitForNewWaysTitle()
{
    this.waitForElementPresent(NEW_WAYS,
            "Не удалось найти заголовок 'Новые способы изучения'",5);
}
public void waitForFindLanguageTitle()
{
    this.waitForElementPresent(FIND_LANGUAGE_BTN,
            "Не удалось найти заголовок 'Искать на почти 300 языках'",5);
}
public void waitForHelpToDoTitle()
{
    this.waitForElementPresent(LEARN_MORE_ABOUT_DATA,
            "Не удалось найти заголовок 'Помогите сделать это приложение лучше'",5);
}
public void clickGetStarted()
{
    this.waitAndClick(GET_STARTED_BTN
    ,"Нет удалось найти кнопку Начать", 5);
}
}
