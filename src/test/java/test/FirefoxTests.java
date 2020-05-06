package test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import base.BaseTest;
import base.LoginTest;
import pages.HomePage;

public class FirefoxTests extends BaseTest
{

	@BeforeMethod
	@Override
	public void setUp() throws MalformedURLException
	{
		super.setUp();
		Capabilities firefoxCap = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(url, firefoxCap);
		driver.get(website);
		homePage = new HomePage(driver);

		loginTest = new LoginTest();
	}

	@Test
	public void testSuccessfulLoginFirefox()
	{
		loginTest.testSuccessfulLogin(homePage);
	}

	@Test
	public void testFailFireFox()
	{
		loginTest.testFailLogin(homePage);
	}

	@Test
	public void testUserProfilePage()
	{
		loginTest.testUserData(homePage);
	}
}
