package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tiko on 4/27/2020.
 */

public class MainPage
{
    WebDriver driver;

    private By nicknameText = By.xpath(".//a[@href='/user/testingthis'][@rel='nofollow']");

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUsername(){
        return driver.findElement(nicknameText).getText();
    }
}
