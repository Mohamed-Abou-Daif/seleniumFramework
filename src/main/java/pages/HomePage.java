package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	@FindBy(linkText = "Contact us")
	WebElement conactUsLink;
	@FindBy(id="customerCurrency")
	WebElement currencyDropDownList;
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	@FindBy(linkText = "Notebooks")
	WebElement notebooksMenu;

	public void openRegistertionPage() {

		clickButton(registerLink);
	}
	public void openLoginPage() {

		clickButton(loginLink);
	}
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(conactUsLink);
	}
	public void changeCurrency() {
		select = new Select(currencyDropDownList);
		select.selectByVisibleText("Euro");
	}
	public void selectNotebooksMenu() {
		action
		.moveToElement(computerMenu)
		.moveToElement(notebooksMenu)
		.click().build().perform();
	}
}
