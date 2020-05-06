package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Tiko on 4/27/2020.
 */

public class MainPage
{
	private WebDriver driver;

	private By nicknameText = By.xpath(".//a[@href='/user/testingthis'][@rel='nofollow']");

	public MainPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public String getUsername()
	{
		return getElement().getText();
	}

	public UserProfilePage clickUsername(){
		getElement().click();
		return new UserProfilePage(driver);
	}

	private WebElement getElement()
	{
		return driver.findElement(nicknameText);
	}
}
