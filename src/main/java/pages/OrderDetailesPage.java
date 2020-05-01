package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailesPage extends PageBase{

	public OrderDetailesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement pdfInvoiceLink;
	
	@FindBy(css = "a.button-2.print-order-button")
	WebElement printInvoiceLink;
	
	public void printOrderDetailes() {
		clickButton(printInvoiceLink);
	}
	public void DownloadPdfInvoive() throws InterruptedException {
		clickButton(pdfInvoiceLink);
		Thread.sleep(2000);
	}

}
