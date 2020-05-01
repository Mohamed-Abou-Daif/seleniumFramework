package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage HomePageObject;

	@Test
	public void userCanSelectSubCategoryFromMainMenu() {
		HomePageObject = new HomePage(driver);
		HomePageObject.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
