package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
	
	Select select;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstNameTxtBox;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastNameTxtBox;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxtBox;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxtBox;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressTxtbox;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postCodeTxtBox;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxtBox;
	
	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy(id="shippingoption_0")
	WebElement shippingRadioBtn;
	
	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;
	
	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;
	
	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement thankYouLbl;
	
	@FindBy(css = "div.title")
	public WebElement successMsg;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailesLink;
	
	public void registeredUserCheckoutProduct(String countryName, String address, String postCode,
			String phone, String city, String productName) throws InterruptedException {
		 select = new Select(countryList);
		 select.selectByVisibleText(countryName);
		 setTextElementText(cityTxtBox, city);
		 setTextElementText(addressTxtbox, address);
		 setTextElementText(postCodeTxtBox, postCode);
		 setTextElementText(phoneTxtBox, phone);
		 clickButton(continueBtn);
		 clickButton(shippingRadioBtn);
		 clickButton(continueShippingBtn);
		 Thread.sleep(1000);
		 clickButton(continuePaymentBtn);
		 Thread.sleep(1000);
		 clickButton(continueInfoBtn);
	}
	public void confirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}
	public void viewOrderDetailes() {
		clickButton(orderDetailesLink);
	}
	public void CheckoutProduct(String firstName, String lastName, String email, String countryName, String address, String postCode,
			String phone, String city, String productName) throws InterruptedException {
		 setTextElementText(firstNameTxtBox, firstName);
		 setTextElementText(lastNameTxtBox, lastName);
		 setTextElementText(emailTxtBox, email);
		 select = new Select(countryList);
		 select.selectByVisibleText(countryName);
		 setTextElementText(cityTxtBox, city);
		 setTextElementText(addressTxtbox, address);
		 setTextElementText(postCodeTxtBox, postCode);
		 setTextElementText(phoneTxtBox, phone);
		 clickButton(continueBtn);
		 clickButton(shippingRadioBtn);
		 clickButton(continueShippingBtn);
		 Thread.sleep(1000);
		 clickButton(continuePaymentBtn);
		 Thread.sleep(1000);
		 clickButton(continueInfoBtn);
	}
}

