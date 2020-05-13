package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import models.Article;

/**
 * Created by Tiko on 5/13/2020.
 */

public class RubricsPage
{
    WebDriver driver;
    private By articles = By.className("article");

    private By title = By.className("title");
    private By categoryUrl = By.tagName("a");
    private By articleUrl = By.className("name");

    public RubricsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public List<Article> getArticles()
    {
        List<WebElement> elements = driver.findElements(articles);
        ArrayList<Article> articles = new ArrayList<>();
        elements.forEach(e -> {
            Article article = new Article();
            article.setTitle(e.findElement(title).getText());
            //I'm intentionally not checking java here to check it later
            article.setCategory(e.findElements(categoryUrl).get(0).getText());
            article.setUrl(e.findElement(articleUrl).getAttribute("href"));
            articles.add(article);
        });

        return articles;
    }
}
