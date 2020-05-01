package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationWithDDTAndDataFaker extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		Thread.sleep(1000);
		registrObject.userRegistration(firstName,lastName,email,password);
		System.out.println("User Data is: "+ " "+firstName+" "+lastName+" "+email+" "+password);
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSucssfully"})
	public void userRegisteredCanLogout(){
		registrObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"userRegisteredCanLogout"})
	public void userRegisteredCanLogin() throws InterruptedException {
		
		homeObject.openLoginPage();
		Thread.sleep(1000);
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
	}
}
