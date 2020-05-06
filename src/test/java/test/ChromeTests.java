package test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import base.LoginTest;
import pages.HomePage;

public class ChromeTests extends BaseTest
{
	private LoginTest loginTest;

	public ChromeTests()
	{
		driver = new RemoteWebDriver(url, DesiredCapabilities.firefox());

		loginTest = new LoginTest();
	}

	@Test
	public void testSuccessfulLoginChrome()
	{
		Capabilities chromeCap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(url, chromeCap);

		driver.get("http://www.quizful.net/test");
		homePage = new HomePage(driver);
		loginTest.testSuccessfulLogin(homePage);
	}


	@Test
	public void testFailChrome()
	{
		driver.get("http://www.quizful.net/test");
		homePage = new HomePage(driver);
		loginTest.testFailLogin(homePage);
	}
}
