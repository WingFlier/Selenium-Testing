package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tiko on 4/27/2020.
 */

public class HomePage
{
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage clickLoginButton()
    {
        driver.findElement(By.xpath(".//a[@href='/LoginAction.loginForm']")).click();
        return new LoginPage(driver);
    }
}
