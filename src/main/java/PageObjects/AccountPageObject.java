package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPageObject {
	
	//Variables and Locators
	private WebDriver driver;
	By registerconfirmationMessage = By.cssSelector("#rightPanel p");
	
	//Constructor
	public AccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//feature behavior
	public String getConfirmationMessage() {
		return driver.findElement(registerconfirmationMessage).getText();
	}

}
