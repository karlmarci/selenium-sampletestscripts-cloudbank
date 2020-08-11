package Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverController {

    private WebDriver driver;
    public static ChromeDriverController chromeDriverController;

    public ChromeDriverController()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void initialize()
    {
        System.setProperty("webdriver.chrome.driver","/Users/FFUFM-Karl/AndroidStudioProjects/MyFirstAutomation/assets/chromedriver");
        chromeDriverController = new ChromeDriverController();
    }

    public static WebDriver getWebDriver()
    {
        return chromeDriverController.driver;
    }

    public static void openApplication(String url)
    {
        chromeDriverController.driver.get(url);
    }

    public static void closeApplication()
    {
        chromeDriverController.driver.close();
    }
}
