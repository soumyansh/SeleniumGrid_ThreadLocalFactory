

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private static ArrayList<WebDriver> driverPool = new ArrayList<WebDriver>();

	@BeforeSuite
	public void beforeSuite() {

	}

	public WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver = DriverFactory.getInstance().getDriver(browser);
		driverPool.add(driver);
		return driver;
	}

	@AfterSuite
	public void AfterSuite() {
		for (WebDriver webDriver : driverPool) {
			webDriver.quit();
			
		}

	}
}
