package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavugationUI extends NavigationUI
{
    static
    {
        MY_LIST_LINK = "xpath://*[@class='android.widget.FrameLayout' and @content-desc='My lists']";
    }
    public AndroidNavugationUI(AppiumDriver driver)
    {
        super(driver);
    }
}
