package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"./src/test/resources/features"},
		glue= {"StepDefinition"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary"},
		dryRun=false,
		strict=true,
		monochrome=true
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
