package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import utilities.Helper;

public class TestBaseParallel {

	public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
	public static final String ACCESS_KEY = LoadProperties.sauceLabsData.getProperty("accesskey");
	public static final String sauceURL = "https://" + USERNAME + ":" + ACCESS_KEY 
			+ LoadProperties.sauceLabsData.getProperty("seleniumURL");
	
	
	public static String BaseUrl = "https://demo.nopcommerce.com/";

	protected ThreadLocal<RemoteWebDriver> driver = null;

	@BeforeClass
	@Parameters({"browser"})
	public void setup(@Optional("firefox") String browser) throws MalformedURLException {

		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		// Selenium Grid Local
		//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
		//Run On SuaceLab On Cloud
		driver.set(new RemoteWebDriver(new URL(sauceURL), caps));
		
		getDriver().navigate().to(BaseUrl);
	}

	public WebDriver getDriver() {
		return driver.get();
	}
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		driver.remove();
	}
	//take Screenshot when test case fail and add it to Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helper.captureScreenshot(getDriver(), result.getName());

		}
	}
}
