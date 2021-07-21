
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	// Singleton Pattern
	private static final DriverFactory instance = new DriverFactory();

	private DriverFactory() {
		// TODO Auto-generated constructor stub
	}

	public static DriverFactory getInstance() {
		return instance;
	}

	// Factory Pattern
	ThreadLocal<RemoteWebDriver> threadLocal = new ThreadLocal<RemoteWebDriver>();

	public WebDriver getDriver(String browser) throws MalformedURLException {
		if (threadLocal.get() == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName("chrome");
				dc.setPlatform(Platform.WINDOWS);
				threadLocal.set(new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), dc));
			} else if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName("firefox");
				dc.setPlatform(Platform.ANY);

				threadLocal.set(new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), dc));
			} else {
				System.err.println("Browser not supported");
			}
		}
		return threadLocal.get();
	}

}
