package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilsLib.ElementUtils;

public class LoginFeaturePageObject extends ElementUtils {
	
	private WebDriver driver;
	private By usernameLocator = By.cssSelector("input[name='username']");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.cssSelector("input[value='Log In']");
	private By registerLinkLOcator = By.xpath("//a[text()='Register']");
	private By forgotLoginInfoLocator = By.xpath("//a[text()='Forgot login info?']");
	private By solutionsDriverLocator = By.xpath("//ul[@class='leftmenu']");
	private By solutionTagsLocator = By.xpath("//ul[@class='leftmenu']/li/a");
	private By accountServicesElementwaitingLocator = By.xpath("//div[@id='leftPanel']/h2");
	private By loginErrorMessageLocator = By.cssSelector("#rightPanel p");
	
	public LoginFeaturePageObject(WebDriver driver) {
		super(driver);
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
	
	//Number of Solutions
	public int getCountOfSolutions() {
		super.waitForElement(accountServicesElementwaitingLocator);
		WebElement solutionsDriver = driver.findElement(solutionsDriverLocator);
		int numberOfSolutions = solutionsDriver.findElements(solutionTagsLocator).size();
		return numberOfSolutions;
		}
		
	//Get the names of the solutions
	public List<String> getNamesOfSolutions() {
		WebElement solutionsDriver = driver.findElement(solutionsDriverLocator);
		List<WebElement> actualSolutionsList = solutionsDriver.findElements(solutionTagsLocator);
		List<String> actualSolutionsNames = new ArrayList<String>();
		for(int i=0; i<actualSolutionsList.size(); i++) {
			actualSolutionsNames.add(actualSolutionsList.get(i).getText());
		}
		return actualSolutionsNames;
	}
	
	//get login error message
	public String getLoginErrorMessage() {
		super.waitForElement(loginErrorMessageLocator);
		String errorMessage = driver.findElement(loginErrorMessageLocator).getText();
		return errorMessage;
	}
	
	
	
	
	
	

}
