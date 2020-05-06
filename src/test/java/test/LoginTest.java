package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

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
        MainPage mainPage = loginPage.clickBtnCorrect();
        assertEquals(mainPage.getUsername(), USERNAME);
    }

    @Test
    public void testFailLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword("randomString");
        loginPage.clickBtnInCorrect();

        assertEquals(loginPage.getIncorrectText(), "Некорректное имя пользователя или пароль");

    }
}
