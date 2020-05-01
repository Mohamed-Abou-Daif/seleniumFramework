package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailesPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homepageObject;
	ProductDetailesPage productDetailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void userCanChangeCurrency() {
		homepageObject = new HomePage(driver);
		homepageObject.changeCurrency();
		
	}
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.searchProductUsingAutoSuggest("Macb");
			productDetailsObject = new ProductDetailesPage(driver);
			Assert.assertTrue(productDetailsObject.productNameBreadCurmb.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(productDetailsObject.productPriceLable.getText().contains("Ђ"));
			System.out.println(productDetailsObject.productPriceLable.getText());
		} catch (Exception e) {
			System.out.println("Error Ocured "+ e.getMessage());
		}
		
	}
}
