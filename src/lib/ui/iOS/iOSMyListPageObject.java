package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class iOSMyListPageObject extends MyListPageObject
{ static {
    ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{ARTICLE_NAME}')]";
    DELETE_ARTICLE = "id:swipe action delete";
}
    public iOSMyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
