package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

public class CoreTestCase  extends TestCase {
private static final String PLATFORM_IOS = "iOS";
    private static final String PLATFORM_ANDROID = "ANDROID";
    protected AppiumDriver driver;
    
private static String AppiumUrl = "http://127.0.0.1:4723/";
@Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        driver = new AndroidDriver(new URL(AppiumUrl), capabilities);

    }

@Override
    protected void tearDown() throws Exception
    {
        driver.quit();
super.tearDown();
    }
    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }
    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception
    {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(platform.equals(PLATFORM_ANDROID)){

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "9");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/alexandremelyanov/Desktop/javaAppium/JavaApppium/apks/org.wikipedia.apk");
            capabilities.setCapability("orientation", "PORTRAIT");
        }
        else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 14");
            capabilities.setCapability("platformVersion", "16.4");
            capabilities.setCapability("app", "/Users/alexandremelyanov/Desktop/javaAppium/JavaApppium/ipa/Wikipedia.app");
            capabilities.setCapability("orientation", "PORTRAIT");
            capabilities.setCapability("appium:automationName", "XCUITest");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform Value" + platform );
        }
        return capabilities;
    }
}
