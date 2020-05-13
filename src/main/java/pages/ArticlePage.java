package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tiko on 5/13/2020.
 */

public class ArticlePage
{
    WebDriver driver;

    private By javaUrl = By.xpath(".//a[@title='Java']");

    public ArticlePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    public RubricsPage rubricsClick()
    {
        driver.findElement(javaUrl).click();
        return new RubricsPage(driver);
    }
}