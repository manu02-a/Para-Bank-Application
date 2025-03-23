package StepDefinitionFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverClass;
import PageObjects.AccountPageObject;
import PageObjects.LoginFeaturePageObject;
import PageObjects.RegisterPage;
import StepDefinitionUtils.StepDefinitionUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterAccountStepDefinition {
	
	//variables
	private WebDriver driver;
	private LoginFeaturePageObject loginpageObject;
	private RegisterPage registerPage;
	private AccountPageObject accountPage;
	
	public RegisterAccountStepDefinition(StepDefinitionUtils utils) {
		this.driver = utils.driver;
		loginpageObject = new LoginFeaturePageObject(driver);
		registerPage = new RegisterPage(driver);
		accountPage = new AccountPageObject(driver);
	}
	
	@Given("user clicks on register link")
	public void user_clicks_on_register_link() {
		loginpageObject.clickRegisterLink(); 
	}
	
	@When("user enters all the fields in the page")
	public void user_enters_all_the_fields_in_the_page(DataTable dataTable) {
		List<String> data = dataTable.asList();
		registerPage.fillFirstName(data.get(0));
		registerPage.fillLastName(data.get(1));
		registerPage.fillAddress(data.get(2));
		registerPage.fillCity(data.get(3));
		registerPage.fillState(data.get(4));
		registerPage.fillZipCode(data.get(5));
		registerPage.fillPhone(data.get(6));
		registerPage.fillSsn(data.get(7));
		registerPage.fillUserName(data.get(8));
		registerPage.fillPassword(data.get(9));
		registerPage.fillConfirmPassword(data.get(10));
		registerPage.clickRegister();
	}
	@Then("user gets successful message {string}")
	public void user_gets_successful_message(String ExpectedMessage) {
		String messageGot = accountPage.getConfirmationMessage();
		Assert.assertEquals(messageGot, ExpectedMessage);
	}
	

}
