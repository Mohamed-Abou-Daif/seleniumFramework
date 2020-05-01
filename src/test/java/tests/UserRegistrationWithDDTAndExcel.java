package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationWithDDTAndExcel extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException{
		// Get Data From Excel Reader Class
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
	}

	@Test(priority = 1,alwaysRun = true, dataProvider = "ExcelData")
	public void userCanRegisterSucssfully(String firstName, String lastName, String email, String password) throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration(firstName,lastName,email,password);
		Thread.sleep(1000);
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
		registrObject.userLogout();
		Thread.sleep(1000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
		registrObject.userLogout();
	}

}
