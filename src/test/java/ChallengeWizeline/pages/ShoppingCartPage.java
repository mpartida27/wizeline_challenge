package ChallengeWizeline.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ChallengeWizeline.utilities.CommonMethods;

public class ShoppingCartPage extends CommonMethods {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="div.inventory_item_name")
	List<WebElement> productNames;
	
	public void checkCorrectNamesAreAdded(List<String> expectedProductNames) 
	{
		List<WebElement> actuaProductlNames = productNames;
		List<String> actualProductNamesToString = new ArrayList<>();
		
		for (int i = 0; i < actuaProductlNames.size(); i++) {
			actualProductNamesToString.add(actuaProductlNames.get(i).getText());
		}
		assertEquals(actualProductNamesToString, expectedProductNames, "Product it's not matching");
	}
	
}
