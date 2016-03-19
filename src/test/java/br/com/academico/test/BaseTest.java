package br.com.academico.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import br.com.academico.config.WebDriverFactory;

public class BaseTest {

	protected static WebDriver driver;
	protected Wait<WebDriver> wait;

	@BeforeClass
	public static void setUp() {
		driver = WebDriverFactory.createChromeDriver();
		driver.get("http://localhost:8080/sistema-academico");
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
