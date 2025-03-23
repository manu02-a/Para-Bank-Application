package StepDefinitionUtils;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverClass;

public class StepDefinitionUtils {
	
	
	public WebDriver driver;
	
	public StepDefinitionUtils() {
		DriverClass driverManager = new DriverClass();
		this.driver = driverManager.getDriver();
	}

}
