package Configuration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandling {

	public WebDriver webdriver;
	
	public WebDriver ChromeDriver() {
		WebDriverManager.chromedriver().setup();
		webdriver = new ChromeDriver();
		return webdriver;
	}
	public WebDriver EdgeDriver() {
		WebDriverManager.edgedriver().setup();
		webdriver = new EdgeDriver();
		return webdriver;
	}


}
