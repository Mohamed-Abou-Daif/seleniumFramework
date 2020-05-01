package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailesPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
	public void userCanSearchAboutProducts() {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailesPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailesPage();
		Assert.assertTrue(productDetailsObject.productNameBreadCurmb.getText().equalsIgnoreCase(productName));
	}
}
