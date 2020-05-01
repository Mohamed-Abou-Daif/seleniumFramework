package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailesPage;
import pages.SearchPage;
import pages.UserRegistrtionPage;

public class EmailFriendTest extends TestBase{
	
	
	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	EmailFriendPage emailFriendObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	//1-User Registration 
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration("eslam", "gamal", "tedcsazxt1@gmail.com", "123456789");
		Assert.assertTrue(registrObject.successmsg.getText().contains("registration completed"));
	}
	
	//2-Search For Product
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.searchProductUsingAutoSuggest("Macb");
			productDetailsObject = new ProductDetailesPage(driver);
			Assert.assertTrue(productDetailsObject.productNameBreadCurmb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("Error Ocured "+ e.getMessage());
		}
	}
	
	//3-Send Message to Friend
		@Test(priority = 3)
		public void registeredUserCanSendEmailToFriend() {
			productDetailsObject.openSendEmail();
			emailFriendObject = new EmailFriendPage(driver);
			emailFriendObject.sendEmailToFriend("bsa@dsd.com", "JSMNBD");
			Assert.assertTrue(emailFriendObject.msgNotification.getText().contains("Your message has been sent"));
		}
		
	//4-User Logout
	@Test(priority = 4)
	public void userRegisteredCanLogout() {
		registrObject.userLogout();
	}
	

}
