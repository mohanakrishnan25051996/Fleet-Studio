package LawSuitsPage;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Configuration.BaseTest;


public class LaunchApplication extends BaseTest{
	public WebDriver webdriver;
	private static final int ElementWait=30;
	public WebDriverWait wait;
	public Map<String,String> TestData;
	
	public LaunchApplication(WebDriver webdriver,Map<String,String> TestData) {
		this.webdriver=webdriver;
		this.TestData=TestData;
		wait=new WebDriverWait(webdriver, 50);
		PageFactory.initElements(webdriver, this);
	}
	
	public void launch_law_suit_application() {
		String URL=TestData.get("URL");
		webdriver.manage().window().maximize();
		ClearCookies();
		webdriver.get(URL);
		webdriver.manage().timeouts().pageLoadTimeout(80,TimeUnit.SECONDS);
	}
	
}
