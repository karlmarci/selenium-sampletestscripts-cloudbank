package Core;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Config.AppConfig;
import Controller.ChromeDriverController;

public class BaseTest {

    private static BaseTest baseTest;

    public BaseTest(boolean launch) {
        if (launch) {
            System.out.println(ChromeDriverController.getWebDriver());
            ChromeDriverController.openApplication(AppConfig.Default_AppURL);
        }
    }

    public BaseTest()
    {
        this(false);
    }

    @BeforeClass
    public void openWindow()
    {
        ChromeDriverController.initialize();
        baseTest = new BaseTest(true);
    }

//    @AfterClass
//    public void closeWindow()
//    {
//    ChromeDriverController.closeApplication();
//     }

    public static String waitForElementNotVisible(WebElement loader) {
        if ((ChromeDriverController.getWebDriver() == null) || (loader == null))
        {
            return "Wrong usage of waitForElementNotVisible()";
        }
        try
        {
            WebDriverWait wait = new WebDriverWait(ChromeDriverController.getWebDriver(), 5000L);
            wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
            wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
            return null;
        }
        catch (TimeoutException e)
        {
            return "Timed out while waiting for element";
        }
    }

}
