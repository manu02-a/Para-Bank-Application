package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotInfoPage {
	
	//Variables
	WebDriver driver;
	
	// Locators
	By firstNameLocator = By.id("firstName");
	By lastNameLocator = By.id("lastName");
	By addressLocator = By.cssSelector("input[id='address.street']");
	By cityLocator = By.cssSelector("input[id='address.city']");
	By stateLocator = By.xpath("//input[@id='address.state']");
	By zipCodeLocator = By.xpath("//input[@id='address.zipCode']");
	By ssnLocator = By.id("ssn");
	By findMyLoginInfoButtonLocator = By.xpath("//*[@value='Find My Login Info']");
	By successfullMessageLocator = By.xpath("//div[@id='rightPanel']/p[1]");
	By UserNameAndPasswordMessageLocator = By.xpath("//div[@id='rightPanel']/p[2]");
	
	
	
	// Constructor
	public ForgotInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page behaviors
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameLocator).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameLocator).sendKeys(lastName);
	}
	
	public void enterAddress(String address) {
		driver.findElement(addressLocator).sendKeys(address);
	}
	
	public void enterCity(String city) {
		driver.findElement(cityLocator).sendKeys(city);
	}
	
	public void enterState(String state) {
		driver.findElement(stateLocator).sendKeys(state);
	}
	
	public void enterZipCode(String zipCode) {
		driver.findElement(zipCodeLocator).sendKeys(zipCode);
	}
	
	public void enterSSN(String ssn) {
		driver.findElement(ssnLocator).sendKeys(ssn);
	}
	
	public void clickFineMyLoginInfoButton() {
		driver.findElement(findMyLoginInfoButtonLocator).click();
	}
	
	public String getConfirmationMessage() {
		return driver.findElement(successfullMessageLocator).getText();
	}
	
	public String getUsernameAndPassword() {
		return driver.findElement(UserNameAndPasswordMessageLocator).getText();
	}

}
