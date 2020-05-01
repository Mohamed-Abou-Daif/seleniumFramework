package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailesPage extends PageBase{

	public ProductDetailesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCurmb;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailAFriendBtn;
	
	@FindBy(css = "span.price-value-4")
	public WebElement productPriceLable;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToShoppingCartBtn;
	
	public void openSendEmail() {
		clickButton(emailAFriendBtn);
	}
	public void openAddReviewPage() {
		clickButton(addReviewLink);
	}
	public void AddProductWishListPage() {
		clickButton(addToWishListBtn);
	}
	public void addProductToCompare() {
		clickButton(addToCompareBtn);
	}
	public void addProductToShoppingCart() {
		clickButton(addToShoppingCartBtn);
	}

}
