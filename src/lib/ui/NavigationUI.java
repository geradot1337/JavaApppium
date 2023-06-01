package lib.ui;

import io.appium.java_client.AppiumDriver;


public class NavigationUI  extends MainPageObject{
    private static final String
    MY_LIST_LINK = "//*[@class='android.widget.FrameLayout' and @content-desc='My lists']";


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
    public void clickMylist()
    {
        this.waitAndClick(
                MY_LIST_LINK,
                "Нет кнопки мой список",
                5
        );
    }

}
