package LawSuitsPage;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Configuration.BaseTest;

public class Summary extends BaseTest{
	public WebDriver webdriver;
	private static final int ElementWait=30;
	public WebDriverWait wait;
	public Map<String,String> TestData;
	public static final By Client = By.xpath("//h1[contains(@class,'header_titlebar')]/span");
	public static final By Plaintiff_details = By.xpath("//div[contains(@class,'plaintiff_content')]/ul");
	public static final By Defendant_details = By.xpath("//div[contains(@class,'defendant_content')]/ul");
	

	public Summary(WebDriver webdriver,Map<String,String> TestData) {
		this.webdriver=webdriver;
		this.TestData=TestData;
		wait=new WebDriverWait(webdriver,(60));
		PageFactory.initElements(webdriver, this);
	}
public String Client_Validation() {
	waitFor().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Client));
	String Name = webdriver.findElement(Client).getText().toUpperCase();
	return Name;
}
public void Get_PlaintiffDetails() {
	waitFor().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Plaintiff_details));
	String PlaintiffDeatils=webdriver.findElement(Plaintiff_details).getText();
	Print_Console(PlaintiffDeatils);
}
public void Get_DefendantDetails() {
	waitFor().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Defendant_details));
	String PlaintiffDeatils=webdriver.findElement(Defendant_details).getText();
	Print_Console(PlaintiffDeatils);
}
}
