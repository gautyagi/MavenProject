package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By login = By.cssSelector("a[href*='sign_in']");
	By Register = By.xpath("//span[text()='Register']");
	By Text = By.xpath("//h3[text()='An Academy to learn Everything about Testing']");
    
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getRegister() {
		return driver.findElement(Register);
	}

	public WebElement Text() {
		return driver.findElement(Text);
	}

}
