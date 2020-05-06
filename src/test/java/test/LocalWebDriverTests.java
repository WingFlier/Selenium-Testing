package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import base.LoginTest;
import event.EventReporter;
import pages.HomePage;

public class LocalWebDriverTests extends BaseTest
{


	@org.testng.annotations.BeforeClass
	@Override
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
		((EventFiringWebDriver) driver).register(new EventReporter());
		driver.get(website);
		homePage = new HomePage(driver);
		loginTest = new LoginTest();
	}

	private ChromeOptions getChromeOptions()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		return options;
	}

	@Test
	public void testSuccessfulLogin()
	{
		loginTest.testSuccessfulLogin(homePage);
	}

	@Test
	public void testFail()
	{
		loginTest.testFailLogin(homePage);
	}
}
