package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import event.EventReporter;
import pages.HomePage;

/**
 * Created by Tiko on 4/27/2020.
 */

public class BaseTest
{
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
    }

    @BeforeMethod
    private void goHome()
    {
        driver.get("http://www.quizful.net/test");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void off()
    {
        driver.quit();
    }

    private ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
}
