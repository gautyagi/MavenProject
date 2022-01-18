package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Email = By.id("user_email");
	By Password = By.id("user_password");
	By LoginClick = By.xpath("//input[@name='commit']");
	By Eror = By.xpath("//div[@class='alert alert-danger alert-show mb-5']");

	public WebElement getEmail() {
		return driver.findElement(Email);
	}

	public WebElement getPassword() {
		return driver.findElement(Password);
	}

	public WebElement getLoginClick() {
		return driver.findElement(LoginClick);
	}
	
	public WebElement getEror() {
		return driver.findElement(Eror);
	}

}
