package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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


	@AfterClass
	public void off()
	{
		driver.quit();
	}
}
