package base;

import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tiko on 4/27/2020.
 */

public class LoginTest
{
	public final String USERNAME = "testingthis";
	public final String PASS = "system.setproperty";


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
}
