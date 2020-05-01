package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement productReviewTitle;
	@FindBy(id="AddProductReview_ReviewText")
	WebElement productReviewMsg;
	@FindBy(id="addproductrating_4")
	WebElement rating4Btns;
	@FindBy(css = "input.button-1.write-product-review-button")
	WebElement submitBtn;
	@FindBy(css = "div.result")
	public WebElement reviewNotification;
	
	public void AddProductReview(String reviewTitle, String reviewMsg) {
		
		setTextElementText(productReviewTitle, reviewTitle);
		setTextElementText(productReviewMsg, reviewMsg);
		clickButton(rating4Btns);
		clickButton(submitBtn);
	}

}
