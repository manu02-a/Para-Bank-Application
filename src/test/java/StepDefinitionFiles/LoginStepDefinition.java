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
	
	@Given("User enters username {string} and password {string}")
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
	
	
	
	
}
