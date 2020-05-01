package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailesPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductTowishListTest extends TestBase{

	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	WishlistPage wishListObject;
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
	public void userCanAddProductToWishList() {
		productDetailsObject = new ProductDetailesPage(driver);
		productDetailsObject.AddProductWishListPage();
		driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
		wishListObject = new WishlistPage(driver);
		Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
	}
	@Test(priority = 3)
	public void userCanRemoveProductFromWishList() {
		wishListObject = new WishlistPage(driver);
		wishListObject.removeProductFromCart();
		Assert.assertTrue(wishListObject.emptyCartLbl.getText().contains("The wishlist is empty!"));
	}
}
