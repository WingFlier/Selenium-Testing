package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage clickLoginButton()
    {
        driver.findElement(By.xpath(".//a[@href='/LoginAction.loginForm']")).click();
        return new LoginPage(driver);
    }
}
