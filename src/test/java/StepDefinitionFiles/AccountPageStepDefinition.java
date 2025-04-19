package StepDefinitionFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.AccountPageObject;
import PageObjects.LoginFeaturePageObject;
import StepDefinitionUtils.StepDefinitionUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPageStepDefinition {
	
	//Variables
	private WebDriver driver;
	private AccountPageObject accountPageObject;
	private LoginFeaturePageObject loginFeaturePageObject;
	private int countOfAcctualServices;
	//private StepDefinitionUtils utils;
	private List<String> actualServicesNames;
	
	public AccountPageStepDefinition(StepDefinitionUtils utils) {
		this.driver = utils.driver;
		accountPageObject = new AccountPageObject(driver);
		loginFeaturePageObject = new LoginFeaturePageObject(driver);
	}
	
	@Given("Login to the Application with username {string} and password {string}")
	public void login_to_application(String username, String password) {
		
		loginFeaturePageObject.enterUsername(username);
		loginFeaturePageObject.enterPassword(password);
		loginFeaturePageObject.clickLoginButton();
	}
	@When("Count the number of services present in the Account Services section")
	public void count_number_of_services() {
		countOfAcctualServices = accountPageObject.getCountOfAccountSevices();
	}
	
	@Then("Verify that the total number of services is {int}")
	public void verify_the_total_services(int expectedServiceCount) {
		Assert.assertEquals(countOfAcctualServices, expectedServiceCount);
	}
	
	// Verify the Service names
	@When("Take the Actual service names present in the page")
	public void take_actual_service_names() {
		actualServicesNames = accountPageObject.getActuslServiceNames();
	}
	
	@Then("Verify that the Expected service names matches with Actual service names of the page")
	public void verify_expectedServicesNames_with_actualServiceNames(DataTable dataTable) {
		List<String> expectedServiceNames = dataTable.asList();
		Assert.assertEquals(true, expectedServiceNames.containsAll(actualServicesNames));
	}
	

}
