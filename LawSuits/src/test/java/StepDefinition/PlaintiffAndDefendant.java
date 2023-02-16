package StepDefinition;



import Configuration.BaseTest;
import LawSuitsPage.HomePage;
import LawSuitsPage.LaunchApplication;
import LawSuitsPage.Summary;
import io.cucumber.java.en.*;

public class PlaintiffAndDefendant extends BaseTest{
	//	WebDriver webDriver;
	private String step;
	HomePage hp=new HomePage(webdriver,TestData);;
	Summary s=new Summary(webdriver,TestData);
	@Given("Launch LawSuit Application")
	public void launch_law_suit_application() {
		step=new Throwable().getStackTrace()[0].getMethodName();
		setCurrentStep(step);
		LaunchApplication lp=new LaunchApplication(webdriver,TestData);
		lp.launch_law_suit_application();

	}

	@When("Verify Recent LawSuits	available")
	public void verify_recent_law_suits_available() {
		step=new Throwable().getStackTrace()[0].getMethodName();
		setCurrentStep(step);
		hp = new HomePage(webdriver, TestData);
		hp.RecentLawSuit_Validation();

	}
	@Then("Get Recent LawSuit Details and Validate Summary")
	public void get_recent_law_suit_details_and_validate_summary() throws InterruptedException {
		step=new Throwable().getStackTrace()[0].getMethodName();
		setCurrentStep(step);
		hp.Plaintiffs_Validation();
	}



}
