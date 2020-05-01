package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailesPage;
import pages.SearchPage;

public class SearchProductUseingAutoSuggestTest extends TestBase{

	SearchPage searchObject;
	ProductDetailesPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
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
}
