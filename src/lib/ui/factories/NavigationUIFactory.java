package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidNavugationUI;
import lib.ui.NavigationUI;
import lib.ui.iOS.iOSNavigationUI;

public class NavigationUIFactory
{
    public static NavigationUI get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavugationUI(driver);

        } else return new iOSNavigationUI(driver);
    }
}
