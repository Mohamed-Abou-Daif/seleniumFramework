package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;
	String firstName = LoadProperties.userData.getProperty("firstName");
	String lastName = LoadProperties.userData.getProperty("lastName");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration(firstName,lastName,email,password);
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSucssfully"})
	public void userRegisteredCanLogout() {
		registrObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"userRegisteredCanLogout"})
	public void userRegisteredCanLogin() throws InterruptedException {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(1000);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
	}
}
