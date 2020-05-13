package test;

import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.List;

import base.BaseTest;
import models.Article;
import pages.ArticlePage;
import pages.LoginPage;
import pages.MainPage;
import pages.RubricsPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tiko on 5/13/2020.
 */

public class RubricsTest extends BaseTest
{
    public final String USERNAME = "testingthis";
    public final String PASS = "system.setproperty";

    private MainPage login()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword(PASS);
        MainPage mainPage = loginPage.clickBtnCorrect();
        assertEquals(mainPage.getUsername(), USERNAME);
        return mainPage;
    }

    @Test
    public void testRubrics()
    {
        MainPage login = login();
        ArticlePage articlePage = login.clickBtnArticles();
        String url = articlePage.getUrl();
        assertEquals("http://www.quizful.net/posts", url);

        RubricsPage rubricsPage = articlePage.rubricsClick();
        List<Article> articles = rubricsPage.getArticles();
        articles.forEach(article -> {
            assertEquals("Java", article.getCategory());
            System.out.println(article.toString());
        });
    }
}
