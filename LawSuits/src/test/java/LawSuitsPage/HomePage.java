package LawSuitsPage;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Configuration.BaseTest;

public class HomePage extends BaseTest{
	public WebDriver webdriver;
	private static final int ElementWait=30;
	public WebDriverWait wait;
	public Map<String,String> TestData;
	public static final By RecentLawSuits = By.xpath("//h2[contains(text(),'Recent')]");
	public static final By PostDetails = By.xpath("//div[@class='postDetail']//following-sibling::h3");
	public static final By ClientName = By.xpath("");
	public static final By ValidClientName = By.xpath("");
	public static final By Plaintiff = By.xpath("");
	

	public HomePage(WebDriver webdriver,Map<String,String> TestData) {
		this.webdriver=webdriver;
		this.TestData=TestData;
		wait=new WebDriverWait(webdriver,(60));
		PageFactory.initElements(webdriver, this);
	}

	public void RecentLawSuit_Validation() {
		if(ElementVisibility(RecentLawSuits)) {		
			Print_Console("Launched Accessbility Application");
		}else {
			Print_Console("Unable to Launch Accessbility Apllication");
	}
		String Recent = GetText(RecentLawSuits);
		Assert.assertEquals(Recent, "Recent Lawsuits");
	}
	public void Plaintiffs_Validation() throws InterruptedException {
		int recentPlaintiffs_Count=webdriver.findElements(PostDetails).size();
//		for(int i=1;i<=recentPlaintiffs_Count;i++)
			for(int i=1;i<=2;i++)
		{
			
			String Xpath="(//div[@class='postDetail']//following-sibling::h3/a)["+i+"]";
			Thread.sleep(1000);
			waitFor().until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
			Highlight(By.xpath(Xpath));
			String Home_PlaintiffsName=webdriver.findElement(By.xpath(Xpath)).getText().toUpperCase();
			AddScreenshot_runtime();
			executeClick(By.xpath(Xpath));
			Summary s = new Summary(webdriver, TestData);
			String Plaintiff_Name = s.Client_Validation();
			if(Home_PlaintiffsName.equals(Plaintiff_Name)){
				Print_Console("Plaintiff Name matches");
				Print_Console("************ PLAINTIFF ************");
				s.Get_PlaintiffDetails();
				Print_Console("************ DEFENDANT ************");
				s.Get_DefendantDetails();
				Print_Console("**************************************");
				AddScreenshot_runtime();
				webdriver.navigate().back();
			}
			else {
				Print_Console("-->"+Home_PlaintiffsName+" doesn't Matches with "+Plaintiff_Name+"<--");
			}		
			
		}
	}
	
}


