package ChallengeWizeline.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ChallengeWizeline.utilities.CommonMethods;

public class ShoppingCartPage extends CommonMethods {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="div.inventory_item_name")
	WebElement productName;
	
	public void checkCorrectNameIsAdded(String expectedProductName) 
	{
		assertEquals(productName.getText(), expectedProductName, "Product it's not matching");
	}
	
}
