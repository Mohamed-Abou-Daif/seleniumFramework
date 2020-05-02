package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage HomePageObject;

	@Test
	public void userCanSelectSubCategoryFromMainMenu() throws InterruptedException{
		HomePageObject = new HomePage(driver);
		HomePageObject.selectNotebooksMenu();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
