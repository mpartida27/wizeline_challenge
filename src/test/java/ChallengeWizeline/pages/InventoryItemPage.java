package ChallengeWizeline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ChallengeWizeline.utilities.CommonMethods;

public class InventoryItemPage extends CommonMethods {
	
	public InventoryItemPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="div.inventory_details_name")
	WebElement productNameLabel;
	
	@FindBy(css="button.btn_primary")
	WebElement  addToCartButton;
	
	@FindBy(css="div.shopping_cart_container")
	WebElement shoppingCartButton;
	
	public String getProductName() 
	{
		return getElementText(productNameLabel);
	}
	
	public void clickShoppingCartLink() 
	{
		clickElement(shoppingCartButton);
	}
	
	public void clickAddToCartButton() 
	{
		clickElement(addToCartButton);
	}

}
