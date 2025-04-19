package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilsLib.ElementUtils;

public class AccountPageObject extends ElementUtils{
	
	//Variables and Locators
	private WebDriver driver;
	private By registerconfirmationMessage = By.cssSelector("#rightPanel p");
	private By accountServicesdriverLocator = By.xpath("//div[@id='leftPanel']/ul"); 
	private By accountServicesTagsLocator = By.tagName("a");
	private By accountServicesElementwaitingLocator = By.xpath("//div[@id='leftPanel']/h2");
	
	
	//Constructor
	public AccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//feature behavior
	public String getConfirmationMessage() {
		return driver.findElement(registerconfirmationMessage).getText();
	}
	
	//Number of Account services
	public int getCountOfAccountSevices() {
		super.waitForElement(accountServicesElementwaitingLocator);
		WebElement accountServicesdriver = driver.findElement(accountServicesdriverLocator);
		int numberOfServices = accountServicesdriver.findElements(accountServicesTagsLocator).size();
		return numberOfServices;
	}
	
	//Take the Actual service names in the page
	public List<String> getActuslServiceNames() {
		super.waitForElement(accountServicesElementwaitingLocator);
		WebElement accountServicesdriver = driver.findElement(accountServicesdriverLocator);
		List<WebElement> serviceNamesElements = accountServicesdriver.findElements(accountServicesTagsLocator);
		List<String> actualServiceNames = new ArrayList<String>();
		
		for(int i=0; i<serviceNamesElements.size(); i++) {
			actualServiceNames.add(serviceNamesElements.get(i).getText());
		}
		return actualServiceNames;
	}
	
	
	
	

}
