package ChallengeWizeline.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ChallengeWizeline.utilities.CommonMethods;

public class ProductsPage extends CommonMethods 
{

	public ProductsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(css=".product_label")
	WebElement productsLabel;
	
	@FindBy(css=".bm-burger-button")
	WebElement burgerMenubutton;
	
	@FindBy(css="#logout_sidebar_link")
	WebElement logoutSidebarLink;
	
	@FindBy(css="#inventory_container  button")
	List <WebElement> addCartButtons;
	
	@FindBy(css="#shopping_cart_container a")
	WebElement shoppingCartButton;
	
	String productNames = ".inventory_item a div.inventory_item_name";
	
	String addToCartButton = "div.pricebar button";
	
	@FindBy(css=".inventory_item")
	List<WebElement> inventaryProduct;
	
	
	public void clickburgerMenuButton() 
	{
		clickElement(burgerMenubutton);
	}
	
	public void clickLogoutLink() 
	{
		clickElement(logoutSidebarLink);
	}
	
	public void isProductsLabelPresent() 
	{
		Assert.assertTrue(isElementPresent(productsLabel), "Products Label its not present");
	}
	
	public void addToCartAnyProduct(int numberOfProducts) 
	{
		clickRandomElementFromAList(inventaryProduct, numberOfProducts);
	}
	
	public void clickShoppingCartButton() 
	{
		clickElement(shoppingCartButton);
	}
	
	
}
