package test;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import base.LoginTest;
import pages.HomePage;

public class FirefoxTests extends BaseTest
{
	private LoginTest loginTest;

	public FirefoxTests()
	{
		driver = new RemoteWebDriver(url, DesiredCapabilities.firefox());

		loginTest = new LoginTest();
	}

	@Test
	public void testSuccessfulLoginFirefox()
	{
		driver.get("http://www.quizful.net/test");
		homePage = new HomePage(driver);
		loginTest.testSuccessfulLogin(homePage);
	}

	@Test
	public void testFailFireFox()
	{
		driver.get("http://www.quizful.net/test");
		homePage = new HomePage(driver);
		loginTest.testFailLogin(homePage);
	}

}
