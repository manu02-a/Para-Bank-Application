package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import UtilsLib.ElementUtils;

public class LoginFeaturePageObject {
	
	WebDriver driver;
	private By usernameLocator = By.cssSelector("input[name='username']");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.cssSelector("input[value='Log In']");
	private By registerLinkLOcator = By.xpath("//a[text()='Register']");
	private By forgotLoginInfoLocator = By.xpath("//a[text()='Forgot login info?']");
	
	public LoginFeaturePageObject(WebDriver driver) {
		//super(driver);
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButtonLocator).click();
	}
	
	public String getpageTitle() {
		return driver.getTitle();
	}
	
	public void clickRegisterLink() {
		driver.findElement(registerLinkLOcator).click();
	}
	
	public boolean isRegisterLinkisPresent() {
		return driver.findElement(registerLinkLOcator).isDisplayed();
	}
	
	public void clickForgotLoginInfoLink() {
		driver.findElement(forgotLoginInfoLocator).click();
	}
	
	public boolean isForgotLoginInfoLinkisPresent() {
		return driver.findElement(forgotLoginInfoLocator).isDisplayed();
	}
	
	
	
	
	
	
	

}
