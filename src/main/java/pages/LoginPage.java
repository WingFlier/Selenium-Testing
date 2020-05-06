package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tiko on 4/27/2020.
 */

public class LoginPage
{
	private WebDriver driver;

	private By usernameField = By.id("login");
	private By passwordField = By.xpath(".//input[@type='password']");
	private By loginButton = By.xpath(".//input[@type='submit'][@name='ok']");

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}


	public void setUsername(String username)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
		driver.findElement(usernameField).sendKeys(username);
	}

	public void setPassword(String password)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		driver.findElement(passwordField).sendKeys(password);
	}

	public MainPage clickBtnCorrect()
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		driver.findElement(loginButton).click();
		return new MainPage(driver);
	}

	public void clickBtnInCorrect()
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		driver.findElement(loginButton).click();
	}


	public String getIncorrectText()
	{
		By xpath = By.xpath("//div[@class='errors']");
		driver.findElements(xpath).forEach(webElement -> {
			System.out.println(webElement.getText());
		});
		return driver.findElement(xpath).getText();
	}
}
