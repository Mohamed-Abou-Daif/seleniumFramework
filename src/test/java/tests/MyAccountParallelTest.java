package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrtionPage;

public class MyAccountParallelTest extends TestBaseParallel{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	
	String oldPassword = "123456789";
	String newPassword = "123456";
	String firstName = "eslam";
	String lastName = "gamal";
	String email = "test12asaz1@gmail.com";

	@Test(priority = 1)
	public void userCanRegisterSucssfully() {

		homeObject = new HomePage(getDriver());
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(getDriver());
		registrObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
	}
	@Test(priority = 2)
	public void registeredUserCanChangePassword() {
		myAccountObject = new MyAccountPage(getDriver());
		registrObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultTxt.getText().contains("Password was changed"));
	}
	@Test(priority = 3)
	public void userRegisteredCanLogout() {
		registrObject.userLogout();
	}
	
	@Test(priority = 4)
	public void userRegisteredCanLogin() {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(getDriver());
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
	}
}
