

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GridParallel_ThreadLocal_Factory extends BaseTest {

	@Test
	public void test1() throws MalformedURLException {
		WebDriver driver = getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hello");
	}

	@Test
	public void test2() throws MalformedURLException {
		WebDriver driver = getDriver("firefox");
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hi");
	}

	@Test
	public void test3() throws MalformedURLException {
		WebDriver driver = getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Bye");
	}
}
