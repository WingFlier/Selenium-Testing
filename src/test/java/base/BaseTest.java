package base;

import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import pages.HomePage;

/**
 * Created by Tiko on 4/27/2020.
 */

public class BaseTest
{
    protected WebDriver driver;

    protected HomePage homePage;
    protected URL url;
    protected String website;

    protected LoginTest loginTest;

    @BeforeClass
    public void setUp() throws MalformedURLException
    {
		/*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
		driver.register(new EventReporter());*/

        url = new URL("http://localhost:4444/wd/hub");
        website = "http://www.quizful.net/test";

    }


    @AfterMethod
    public void off(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try
			{
				Files.move(screenshot, new File("src/main/resources/screenshots" + result.getName() + ".png"));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
        driver.quit();
    }
}
