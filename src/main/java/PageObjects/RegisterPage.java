package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
	
	//Variables and By locators
	private WebDriver driver;
	By firstNameLocator = By.cssSelector("input[name='customer.firstName']");
	By lastNameLocator = By.cssSelector("input[name='customer.lastName']");
	By addressLocator = By.cssSelector("input[name='customer.address.street']");
	By cityLocator = By.cssSelector("input[name='customer.address.city']");
	By stateLocator = By.cssSelector("input[name='customer.address.state']");
	By zipcodeLocator = By.cssSelector("input[name='customer.address.zipCode']");
	By phoneLocator = By.cssSelector("input[name='customer.phoneNumber']");
	By ssnLocator = By.cssSelector("input[name='customer.ssn']");
	By userNameLocator = By.cssSelector("input[name='customer.username']");
	By passwordLocator = By.cssSelector("input[name='customer.password']");
	By confirmPasswordLocator = By.cssSelector("input[name='repeatedPassword']");
	By registerButtonLocator = By.cssSelector("input[value='Register']");
	
	
	//Constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Feature behavior
	public void fillFirstName(String firstName) {
		driver.findElement(firstNameLocator).sendKeys(firstName);
	}
	public void fillLastName(String lastName) {
		driver.findElement(lastNameLocator).sendKeys(lastName);
	}
	public void fillAddress(String address) {
		driver.findElement(addressLocator).sendKeys(address);
	}
	public void fillCity(String city) {
		driver.findElement(cityLocator).sendKeys(city);
	}
	public void fillState(String state) {
		driver.findElement(stateLocator).sendKeys(state);
	}
	public void fillZipCode(String zipcode) {
		driver.findElement(zipcodeLocator).sendKeys(zipcode);
	}
	public void fillPhone(String phone) {
		driver.findElement(phoneLocator).sendKeys(phone);
	}

	public void fillSsn(String ssn) {
		driver.findElement(ssnLocator).sendKeys(ssn);
	}
	public void fillUserName(String username) {
		driver.findElement(userNameLocator).sendKeys(username);
	}
	public void fillPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}
	public void fillConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
	}
	public void clickRegister() {
		driver.findElement(registerButtonLocator).click();
	}
}
