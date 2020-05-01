package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends HomePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchBtn;
	@FindBy(id = "ui-id-2")
	List<WebElement> productList;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productTitle;
	
	public void productSearch(String productName) {
		setTextElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}
	public void openProductDetailesPage() {
		clickButton(productTitle);
	}
	public void searchProductUsingAutoSuggest(String searchTxt) {
		setTextElementText(searchTextBox, searchTxt);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}

}
