package StepDefinitionFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverClass;
import PageObjects.ForgotInfoPage;
import PageObjects.LoginFeaturePageObject;
import StepDefinitionUtils.StepDefinitionUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotInfoStepDefinition {
	
	//variables
	private WebDriver driver;
	private LoginFeaturePageObject loginpageObject;
	private ForgotInfoPage forgotInfoPage;
	
	public ForgotInfoStepDefinition(StepDefinitionUtils utils) {
		this.driver = utils.driver;
		loginpageObject = new LoginFeaturePageObject(driver);
		forgotInfoPage = new ForgotInfoPage(driver);
	}
	
	@Given("user clicks on Forgot login Info link")
	public void user_clicks_on_forgot_login_info_link() {
		loginpageObject.clickForgotLoginInfoLink();
	}
	
	@When("user enters all the fields in the page Forgot Info Page")
	public void user_enters_all_the_fields_in_the_page_ForgotInfoPage(DataTable dataTable) {
		List<String> data = dataTable.asList();
		forgotInfoPage.enterFirstName(data.get(0));
		forgotInfoPage.enterLastName(data.get(1));
		forgotInfoPage.enterAddress(data.get(2));
		forgotInfoPage.enterCity(data.get(3));
		forgotInfoPage.enterState(data.get(4));
		forgotInfoPage.enterZipCode(data.get(5));
		forgotInfoPage.enterSSN(data.get(6));
		
	}
	@And("user clicks on Find My Login Info button")
	public void user_clicks_on_find_my_login_info_button() {
		forgotInfoPage.clickFineMyLoginInfoButton();
	}
	@Then("user gets successful message as {string}")
	public void user_gets_successful_message_as(String ActualMessage) {
		System.out.println(forgotInfoPage.getConfirmationMessage());
		Assert.assertEquals(forgotInfoPage.getConfirmationMessage(), ActualMessage);
	}
	@And("user gets username and password")
	public void user_gets_username_and_password() {
		System.out.println(forgotInfoPage.getUsernameAndPassword());
	}

	
}
