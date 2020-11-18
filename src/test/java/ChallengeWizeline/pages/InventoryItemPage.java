package ChallengeWizeline.pages;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(css="div.inventory_details_name")
	List<WebElement> productNameLabelList;
	
	@FindBy(css="button.btn_primary")
	WebElement  addToCartButton;
	
	@FindBy(css="div.shopping_cart_container")
	WebElement shoppingCartButton;
	
	@FindBy(css=".btn_action")
	WebElement checkOutButton;
	
	public List<String> getProductName() 
	{
		List<String> productNames = new ArrayList<String>();
		productNames.add(getElementText(productNameLabel));
		return productNames;
	}
	
	public void clickShoppingCartLink() 
	{
		clickElement(shoppingCartButton);
	}
	
	public void clickAddToCartButton() 
	{
		clickElement(addToCartButton);
	}
	
	public void clickCheckOutButton() 
	{
		clickElement(checkOutButton);
	}

	

}
