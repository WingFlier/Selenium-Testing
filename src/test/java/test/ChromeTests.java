package test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import base.BaseTest;
import base.LoginTest;
import pages.HomePage;

public class ChromeTests extends BaseTest
{

	public ChromeTests()
	{
		driver = new RemoteWebDriver(url, DesiredCapabilities.firefox());
		loginTest = new LoginTest();
	}

	@BeforeClass
	@Override
	public void setUp() throws MalformedURLException
	{
		super.setUp();
		Capabilities chromeCap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(url, chromeCap);
		driver.get(website);
		homePage = new HomePage(driver);
	}

	@Test
	public void testSuccessfulLoginChrome()
	{
		loginTest.testSuccessfulLogin(homePage);
	}


	@Test
	public void testFailChrome()
	{
		loginTest.testFailLogin(homePage);
	}
}
