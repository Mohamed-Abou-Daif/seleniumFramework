package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailesPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{

	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	HomePage homePageObject;
	ShoppingCartPage shoppingCartObject;
	String productName = "Apple MacBook Pro 13-inch";
	
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
	
	@Test(priority = 2)
	public void userCanAddProductToShoppingCart() throws InterruptedException {
		productDetailsObject = new ProductDetailesPage(driver);
		productDetailsObject.addProductToShoppingCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		shoppingCartObject =new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartObject.totalLbl.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 3)
	public void userCanRemoveProductFromShoppingCart() {
		shoppingCartObject =new ShoppingCartPage(driver);
		shoppingCartObject.removeProductFromCart();
		Assert.assertTrue(shoppingCartObject.notivicationMsg.getText().contains("Your Shopping Cart is empty!"));
	}
}
