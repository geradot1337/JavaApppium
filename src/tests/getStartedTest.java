package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class getStartedTest extends CoreTestCase
{
    @Test
    public void testPassThroughWelcome()
    {
        if (Platform.getInstance().isAndroid()) return;
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForFindLanguageTitle();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForHelpToDoTitle();
        WelcomePageObject.clickGetStarted();
    }

}
