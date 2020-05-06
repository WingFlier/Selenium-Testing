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

public class ChromeTests extends BaseTest
{

	@BeforeMethod
	@Override
	public void setUp() throws MalformedURLException
	{
		super.setUp();
		Capabilities chromeCap = DesiredCapabilities.chrome();

		driver = new RemoteWebDriver(url, chromeCap);
		driver.manage().window().maximize();
		driver.get(website);
		homePage = new HomePage(driver);

		loginTest = new LoginTest();
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

	@Test
	public void testUserProfilePage()
	{
		loginTest.testUserData(homePage);
	}
}
