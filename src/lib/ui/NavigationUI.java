package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;


abstract public class NavigationUI  extends MainPageObject{
    protected static String
    MY_LIST_LINK,
    SYNC_CLOSE_BTN;


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
    public void clickMylist() {
        if (Platform.getInstance().isAndroid()) {
            this.waitAndClick(
                    MY_LIST_LINK,
                    "Нет кнопки мой список",
                    5
            );
        } else {
            this.waitAndClick(
                    MY_LIST_LINK,
                    "Нет кнопки мой список",
                    5
            );
            this.waitAndClick(SYNC_CLOSE_BTN, "Cannot find close sync btn", 5);
        }
    }

}
