package br.com.academico.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverFactory {

	public static WebDriver createChromeDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public Wait<WebDriver> createWebDriverWait(WebDriver driver) {
		return createWait(driver, 10, 100);
	}

	public Wait<WebDriver> createWait(WebDriver driver, long withTimeout, long pollingEvery) {
		return new FluentWait<WebDriver>(driver).withTimeout(withTimeout, TimeUnit.SECONDS)
				.pollingEvery(pollingEvery, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}
}
