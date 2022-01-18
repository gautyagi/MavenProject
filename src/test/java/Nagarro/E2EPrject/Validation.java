package Nagarro.E2EPrject;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.baseClass;
import junit.framework.Assert;
import pageObject.LandingPage;

public class Validation extends baseClass {

	@BeforeMethod
	public void initilise() throws IOException {
		driver = initilizedriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(invocationCount = 2)
	public void Assertions() throws IOException {
		LandingPage lp = new LandingPage(driver);
		try {
			Assert.assertEquals(lp.Text().getText(), "An Academy to learn Everything about Testing");
			System.out.println("1");
		} catch (junit.framework.ComparisonFailure ex) {
			System.out.println("2");
		}

	}

	@AfterMethod
	public void Closer() {
		driver.close();
	}

}
