package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrtionPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	
	HomePage homeObject;
	UserRegistrtionPage registerObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    homeObject = new HomePage(driver);
	    homeObject.openRegistertionPage();
	}

	@When("I click on registration link")
	public void i_click_on_registration_link() throws InterruptedException {
		Thread.sleep(1000);
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * registerObject = new UserRegistrtionPage(driver);
	 * registerObject.userRegistration("eslam", "gamal", "fdgf@vc.yff",
	 * "125478521"); }
	 */
	@When("I entered {string},{string},{string},{string}")
	public void i_entered(String firstName, String lastName, String email, String password) {
		registerObject = new UserRegistrtionPage(driver);
		registerObject.userRegistration(firstName,lastName,email,password);
	}

	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registerObject.userLogout();
	}

}
