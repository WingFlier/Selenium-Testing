package base;

import org.testng.Assert;

import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfilePage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tiko on 4/27/2020.
 */

public class LoginTest
{
	private final String USERNAME = "testingthis";
	private final String PASS = "system.setproperty";
	private final String EMAIL = "nonifa5982@oriwijn.com";


	public void testSuccessfulLogin(HomePage homePage)
	{
		LoginPage loginPage = homePage.clickLoginButton();
		loginPage.setUsername(USERNAME);
		loginPage.setPassword(PASS);
		MainPage mainPage = loginPage.clickBtnCorrect();
		assertEquals(mainPage.getUsername(), USERNAME);
	}

	public void testFailLogin(HomePage homePage)
	{
		LoginPage loginPage = homePage.clickLoginButton();
		loginPage.setUsername(USERNAME);
		loginPage.setPassword("randomString");
		loginPage.clickBtnInCorrect();

		assertEquals(loginPage.getIncorrectText(), "Некорректное имя пользователя или пароль");
	}

	public void testUserData(HomePage homePage)
	{
		//I thought about using function testSuccessfulLogin not to have duplicate code, but the I'd have to make it return mainPage, just like in the previous homework I'd have one method which you did not recommend to do, so had to have duplicate code
		LoginPage loginPage = homePage.clickLoginButton();
		loginPage.setUsername(USERNAME);
		loginPage.setPassword(PASS);

		MainPage mainPage = loginPage.clickBtnCorrect();
		assertEquals(mainPage.getUsername(), USERNAME);

		UserProfilePage userProfilePage = mainPage.clickUsername();


		Assert.assertTrue(userProfilePage.getUsername().contains(USERNAME));
		Assert.assertTrue(userProfilePage.getGeneralInfo().contains(EMAIL));
	}
}
