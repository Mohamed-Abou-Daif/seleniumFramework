package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;

	@DataProvider(name = "testData")
	public static Object[][] userData(){
		
		return new Object[][] {
			{"eslam","gamal","testaaaa@ddd.com","123456"},
			{"Ali","Ahmed","eswda@ds.dsw","1234524"}
		};
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider = "testData")
	public void userCanRegisterSucssfully(String fName, String lName, String email, String password) throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration(fName,lName,email,password);
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
		registrObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(1000);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registrObject.logoutLink.isDisplayed());
		registrObject.userLogout();
	}
}
