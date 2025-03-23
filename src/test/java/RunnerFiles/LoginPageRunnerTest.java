package RunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\Features", glue = "StepDefinitionFiles", monochrome=true, dryRun = false)
public class LoginPageRunnerTest extends AbstractTestNGCucumberTests{

	
}
