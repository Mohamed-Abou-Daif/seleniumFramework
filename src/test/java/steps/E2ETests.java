package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.OrderDetailesPage;
import pages.ProductDetailesPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETests extends TestBase{

	SearchPage searchObject;
	ProductDetailesPage productObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailesPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("he search for {string}")
	public void he_search_for(String productName) {
	    searchObject = new SearchPage(driver);
	    searchObject.searchProductUsingAutoSuggest(productName);
	    productObject = new ProductDetailesPage(driver);
	    Assert.assertTrue(productObject.productNameBreadCurmb.getText().contains(productName));
	}

	@When("choose to buy two items")
	public void choose_to_buy_two_items() {
		cartObject = new ShoppingCartPage(driver);
		productObject.addProductToShoppingCart();
	    driver.navigate().to("https://demo.nopcommerce.com/"+"cart");
	}

	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(1000);
		cartObject.openCheckoutPageAsGuest();
	    checkoutObject.CheckoutProduct("eslam", "gamal", "sa@nb.lk", "Egypt",
	    		"cairo", "21452", "12547852", "zayed", productName);
	    Assert.assertTrue(checkoutObject.productName.isDisplayed());
	    Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
	    checkoutObject.confirmOrder();
	    Assert.assertTrue(checkoutObject.thankYouLbl.isDisplayed());
	}

	@Then("he can view the order and print the invoice")
	public void he_can_view_the_order_and_print_the_invoice() throws InterruptedException {
	    orderObject = new OrderDetailesPage(driver);
	    checkoutObject.viewOrderDetailes();
	    Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
	    orderObject.DownloadPdfInvoive();
	    orderObject.printOrderDetailes();
	}
}
