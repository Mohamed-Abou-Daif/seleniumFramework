package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration("eslam", "gamal", "tedcsazx1t1@gmail.com", "123456789");
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSucssfully"})
	public void userRegisteredCanLogout() {
		registrObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"userRegisteredCanLogout"})
	public void userRegisteredCanLogin() {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("tedcsazx1t1@gmail.com", "123456789");
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
	}
}
