package StepDefinitionFiles;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverClass;
import StepDefinitionUtils.StepDefinitionUtils;
import io.cucumber.java.After;

public class Hooks {
	
	private WebDriver driver;
	
	public Hooks(StepDefinitionUtils utils) {
		this.driver = utils.driver;
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
