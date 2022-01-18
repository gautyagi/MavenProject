package Nagarro.E2EPrject;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.baseClass;
import junit.framework.Assert;
import pageObject.LandingPage;
import pageObject.LoginPage;

import org.openqa.selenium.WebDriver;

public class HomePage extends baseClass {

	@BeforeMethod
	public void initilise() throws IOException {
		driver = initilizedriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData",priority = 1) // lecture 206
	public void basePage(String Username, String Password) throws IOException {

		LandingPage lp = new LandingPage(driver);// create constructor in landing page to pass the scope of driver
		lp.getLogin().click();
		// System.out.println(lp.Text().getText());
		// lp.getRegister().click();
		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(Username);
		l.getPassword().sendKeys(Password);
		l.getLoginClick().click();
		System.out.println(l.getEror().getText());

	}

	@Test(priority = 2)
	public void Register() {
		LandingPage laPage = new LandingPage(driver);
		laPage.getRegister().click();

	}

	@AfterMethod
	public void Closer() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];// first [] is for number of data to send & second[] number of values or each
											// test
		data[0][0] = "abc";
		data[0][1] = "abcd";

		data[1][0] = "abcde";
		data[1][1] = "abcdef";

		return data;

	}

}
