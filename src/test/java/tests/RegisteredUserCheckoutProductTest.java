package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailesPage;
import pages.ProductDetailesPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrtionPage;

public class RegisteredUserCheckoutProductTest extends TestBase{

	HomePage homeObject;
	UserRegistrtionPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;
	CheckoutPage checkoutObject;
	OrderDetailesPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";
	//1- Register User
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSucssfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		registerObject = new UserRegistrtionPage(driver);
		registerObject.userRegistration("Eslam", "Gamal", "text1@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successmsg.getText().contains("registration completed"));
	}
	//2- Search product
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
	//3- Add To Cart
	@Test(priority = 3)
	public void userCanAddProductToShoppingCart() throws InterruptedException {
		productDetailsObject = new ProductDetailesPage(driver);
		productDetailsObject.addProductToShoppingCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		shoppingCartObject =new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartObject.totalLbl.getText().contains("3,600"));
	}
	//4- Checkout Product
	@Test(priority = 4)
	public void userCanCheckoutProduct() throws InterruptedException {

		checkoutObject = new CheckoutPage(driver);
		shoppingCartObject.openCheckoutPage();
		Thread.sleep(1000);
		checkoutObject.registeredUserCheckoutProduct
		("Egypt", "test address", "12542", "123547852", "giza", productName);
		Thread.sleep(1000);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		Thread.sleep(1000);
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.thankYouLbl.isDisplayed());
		checkoutObject.viewOrderDetailes();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailesPage(driver);
		orderObject.DownloadPdfInvoive();
		orderObject.printOrderDetailes();

	}
	//5- Logout
	@Test(priority = 5)
	public void userRegisteredCanLogout() {
		registerObject.userLogout();
	}

}
