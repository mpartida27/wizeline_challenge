package ChallengeWizeline.tests;

import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;

public class ShoppingCartPageTests extends BaseTest {
	
	@Test
	public void navigateToShoppingCartAndValidateProduct() 
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickOnProduct();
		String expectedProductName = inventoryItemPage().getProductName();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		shoppingCartPage().checkCorrectNameIsAdded(expectedProductName);
	}

}
