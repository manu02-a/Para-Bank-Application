package StepDefinitionUtils;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverClass;

public class StepDefinitionUtils {
	
	
	public WebDriver driver;
	
	public StepDefinitionUtils() {
		DriverClass driverManager = new DriverClass();
		this.driver = driverManager.getDriver();
	}
	
	

}
