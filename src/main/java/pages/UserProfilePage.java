package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserProfilePage
{

	private WebDriver driver;
	private By user = By.className("user");
	private By login = By.className("login");

	private By general = By.id("personal-contacts");


	public UserProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public String getUsername()
	{
		return driver.findElement(user).findElement(login).getText();
	}

	public String getGeneralInfo()
	{
		WebElement element = driver.findElement(general);
		return element.getText();
	}
}
