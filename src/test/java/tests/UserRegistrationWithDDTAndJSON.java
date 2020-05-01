package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationWithDDTAndJSON extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() throws InterruptedException, FileNotFoundException, IOException, ParseException {

		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.jsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		Thread.sleep(1000);
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration(jsonReader.firstName,jsonReader.lastName,jsonReader.email,jsonReader.password);
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
		registrObject.userLogout();
		Thread.sleep(1000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(1000);
		loginObject.userLogin(jsonReader.email,jsonReader.password);
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
		registrObject.userLogout();
	}
	
}
