package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrtionPage;

public class UserRegistrationWithDDTAndCSV extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;
	
	CSVReader reader;

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() throws CsvValidationException, IOException, InterruptedException {

		// Get Path Of CSV File
		String csv_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(csv_file));
		String[] csvCell;
		// While Loop till the Last Value in CSV File
		while ((csvCell = reader.readNext()) != null) {
			
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegistertionPage();
			Thread.sleep(1000);
			registrObject = new UserRegistrtionPage(driver);
			registrObject.userRegistration(firstName,lastName,email,password);
			Thread.sleep(1000);
			Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
			registrObject.userLogout();
			homeObject.openLoginPage();
			Thread.sleep(1000);
			loginObject = new LoginPage(driver);
			loginObject.userLogin(email,password);
			Assert.assertTrue(registrObject.logoutLink.isDisplayed());
			registrObject.userLogout();
		}
	}
}
