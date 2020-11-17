package ChallengeWizeline.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ChallengeWizeline.pages.LoginPage;
import ChallengeWizeline.pages.ProductsPage;
import ChallengeWizeline.pages.ShoppingCartPage;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUpTestCase() {
		System.setProperty("webdriver.chrome.driver", "/Users/drivers/chromedriver");
		driver = new ChromeDriver();
		goToLandingPage();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void quiteDriver() {
		driver.quit();
	}
	
	public void goToLandingPage() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public LoginPage loginPage() 
	{
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public ProductsPage productsPage() 
	{
		ProductsPage productsPage = new ProductsPage(driver);
		return productsPage;
	}
	
	public ShoppingCartPage shoppingCartPage() 
	{
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		return shoppingCartPage;
	}
	

}
