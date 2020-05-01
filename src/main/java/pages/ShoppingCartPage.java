package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="removefromcart")
	WebElement removeCheck;

	@FindBy(name="updatecart")
	WebElement updateBtn;

	@FindBy(id="itemquantity23843")
	public WebElement quantityTxt;

	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;

	@FindBy(css = "div.no-data")
	public WebElement notivicationMsg;

	@FindBy(id="checkout")
	WebElement checkoutBtn;

	@FindBy(id="termsofservice")
	WebElement agreeCheckBox;
	

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement geustBtn;

	public void removeProductFromCart() {
		clickButton(removeCheck);
		clickButton(updateBtn);
	}
	public void updateProductQuantityInCart(String quantity) {
		//Clear TextBox
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateBtn);
	}
	public void openCheckoutPage() {

		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
	public void openCheckoutPageAsGuest() {
		
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
		clickButton(geustBtn);
	}

}
