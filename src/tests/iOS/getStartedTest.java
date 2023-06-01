package tests.iOS;

import lib.iOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class getStartedTest extends iOSTestCase
{
    @Test
    public void testPassThroughWelcome()
    {
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
