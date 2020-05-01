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

public class GuestCheckoutProductFromCart extends TestBase{
	
	HomePage homeObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;
	CheckoutPage checkoutObject;
	OrderDetailesPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	//1- Search product
		@Test(priority = 1)
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
		//2- Add To Cart
		@Test(priority = 2)
		public void userCanAddProductToShoppingCart() throws InterruptedException {
			productDetailsObject = new ProductDetailesPage(driver);
			productDetailsObject.addProductToShoppingCart();
			Thread.sleep(1000);
			driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
			shoppingCartObject =new ShoppingCartPage(driver);
			Assert.assertTrue(shoppingCartObject.totalLbl.getText().contains("3,600"));
		}
		//3- Checkout Product
		@Test(priority = 3)
		public void userCanCheckoutProduct() throws InterruptedException {

			checkoutObject = new CheckoutPage(driver);
			shoppingCartObject.openCheckoutPageAsGuest();
			Thread.sleep(1000);
			checkoutObject.CheckoutProduct("eslam", "gamal", "es@gsh.com",
					"Egypt", "test address", "12542", "123547852", "giza", productName);
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
		//4- User Can View Order
		@Test(priority = 4)
		public void userCanViewOrder() throws InterruptedException {
			orderObject = new OrderDetailesPage(driver);
			checkoutObject.viewOrderDetailes();
			Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
			orderObject.DownloadPdfInvoive();
			Thread.sleep(2000);
			orderObject.printOrderDetailes();
		}

}
