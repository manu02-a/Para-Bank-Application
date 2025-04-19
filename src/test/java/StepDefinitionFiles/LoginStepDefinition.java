package StepDefinitionFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverClass;
import PageObjects.AccountPageObject;
import PageObjects.ForgotInfoPage;
import PageObjects.LoginFeaturePageObject;
import PageObjects.RegisterPage;
import StepDefinitionUtils.StepDefinitionUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	//public WebDriver driver;
	public LoginFeaturePageObject loginpageObject;
	public RegisterPage registerPage;
	public AccountPageObject accountPage;
	public ForgotInfoPage forgotInfoPage;
	public StepDefinitionUtils utils;
	public int countActualSolutions;
	private List<String> actualSolutionNames;
	private String loginErrorMessage;
	
	public LoginStepDefinition(StepDefinitionUtils utils) {
		this.utils = utils;
		loginpageObject = new LoginFeaturePageObject(utils.driver);
		registerPage = new RegisterPage(utils.driver);
		accountPage = new AccountPageObject(utils.driver);
		forgotInfoPage = new ForgotInfoPage(utils.driver);
	}
	
	@Given("User gets into login page URL")
	public void User_get_into_login_page_URL() {
		utils.driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}
	
	@Given("User enters valid username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		loginpageObject.enterUsername(username);
		loginpageObject.enterPassword(password); 
	}
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		loginpageObject.clickLoginButton();
	}
	@Then("User login is successful and user is in account home page")
	public void user_login_is_successful_and_user_is_in_account_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		String pageTitle = loginpageObject.getpageTitle();
		System.out.println(pageTitle);
	    Assert.assertEquals(pageTitle, "ParaBank | Accounts Overview");

	}
	
	@When("Count the number of solutions present in the Solutions section")
	public void count_the_number_of_solutiona() {
		countActualSolutions = loginpageObject.getCountOfSolutions();
	}
	
	@Then("Verify that the total number of solutions is {int}")
	public void verify_the_solutions(int expectedSolutions) {
		Assert.assertEquals(countActualSolutions, expectedSolutions);
	}
	
	// Verifying the names of solutions
	@When("List the solutions names present in the page")
	public void list_the_actual_solutions() {
		actualSolutionNames = loginpageObject.getNamesOfSolutions();
	}
		
	@Then("Verify that the listed solutions contains all the below expected solutions")
	public void verify_listed_solutions_with_expected_solutions(DataTable dataTable) {
		List<String> excectedSolutionNames = dataTable.asList();
		Assert.assertEquals(true, excectedSolutionNames.containsAll(actualSolutionNames));
	}
	
	// verify invalid credentials login
	@Given("^User enters username (.+) and password (.+)$")
	public void user_enters_usernames_passwords(String userName, String password) {
		loginpageObject.enterUsername(userName);
		loginpageObject.enterPassword(password);
	}
	
	@Then("verify user can see the error message as {string}")
	public void verify_error_message(String errorMessage) {
		loginErrorMessage = loginpageObject.getLoginErrorMessage();
		Assert.assertEquals(loginErrorMessage, errorMessage);
	}
	
	@And("User not in account home page")
	public void verify_user_not_in_account_page() {
		Assert.assertFalse(loginpageObject.getpageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"));
	}
	
	
}
