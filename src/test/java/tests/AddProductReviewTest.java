package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailesPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrtionPage;

public class AddProductReviewTest extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registrObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	ProductReviewPage reviewObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	//1-User Registration 
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registrObject = new UserRegistrtionPage(driver);
		registrObject.userRegistration("eslam", "gamal", "tedcsazxtm1@gmail.com", "123456789");
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
	
	//3-Product Review
		@Test(priority = 3)
		public void registeredUserCanAddReview() {
			productDetailsObject.openAddReviewPage();
			reviewObject = new ProductReviewPage(driver);
			reviewObject.AddProductReview("new review", "the Product is very good");
			Assert.assertTrue(reviewObject.reviewNotification.getText().contains(" review is successfully added."));
			
		}
		
	//4-User Logout
	@Test(priority = 4)
	public void userRegisteredCanLogout() {
		registrObject.userLogout();
	}
	

}
