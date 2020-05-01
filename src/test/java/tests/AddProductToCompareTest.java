package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailesPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{

	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	//1-Search For Product # 1
	//2-Search For Product # 2
	//3-Compare 2 products
	//4-Clear List
	
	HomePage homePageObject;
	ProductDetailesPage productDetailsObject;
	SearchPage searchObject;
	ComparePage compareObject;
	
	@Test(priority = 1)
	public void userCanCompareProducts() throws InterruptedException {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailesPage(driver);
		compareObject = new ComparePage(driver);
		
		searchObject.searchProductUsingAutoSuggest("Mac");
		Assert.assertTrue(productDetailsObject.productNameBreadCurmb.getText().contains(firstProductName));
		productDetailsObject.addProductToCompare();
		
		searchObject.searchProductUsingAutoSuggest("Asus");
		Assert.assertTrue(productDetailsObject.productNameBreadCurmb.getText().contains(secondProductName));
		productDetailsObject.addProductToCompare();
		Thread.sleep(1000);
		
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals(secondProductName));
		Assert.assertTrue(compareObject.secondProductName.getText().equals(firstProductName));
		compareObject.compareProducts();
	}
	@Test(priority = 2)
	public void userCanClearCompareList() {
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
