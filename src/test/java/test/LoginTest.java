package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Tiko on 4/27/2020.
 */

public class LoginTest extends BaseTest
{
    public final String USERNAME = "testingthis";
    public final String PASS = "system.setproperty";

    @Test
    public void testSuccessfulLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword(PASS);
        MainPage mainPage = loginPage.clickBtn();
        assertEquals(mainPage.getUsername(), USERNAME);
    }

    @Test
    public void testFailLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword("randomString");
        loginPage.clickBtn();

        assertEquals(loginPage.getIncorrectText(), "Некорректное имя пользователя или пароль");

    }
}