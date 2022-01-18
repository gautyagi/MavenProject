package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class baseClass {

	public WebDriver driver; // creating driver instance once and using in all browsers so access is able to
	public Properties prop;						// all test cases

	public WebDriver initilizedriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\E2EPrject\\src\\main\\java\\Resources\\base.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\gauravtyagi03\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "Path_of_Firefox_Driver"); // Setting system properties of
																					// FirefoxDriver
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\gauravtyagi03\\Downloads\\IEDriverServer_Win32_4.0.0\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();

			capability.setCapability("ignoreZoomSetting", true);
			capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");

			driver = new InternetExplorerDriver(capability);

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver; // to return driver to test cases
	}

}
