package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homePageObject;
	ContactUsPage contactUsObject;
	String fullName = "eslam";
	String email = "kjb@kg.com";
	String enquiry = "a,sdbnasj,dbns,b";
	@Test
	public void userCanContactUsTest() {
		homePageObject = new HomePage(driver);
		homePageObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactUsObject.successMsg.getText().contains("been successfully "));
	}
}
