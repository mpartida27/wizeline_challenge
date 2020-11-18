package ChallengeWizeline.pages;

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
		compareTwoLists(expectedProductNames, productNames);
	}
	
}
