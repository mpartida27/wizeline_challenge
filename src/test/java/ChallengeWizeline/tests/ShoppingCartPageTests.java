package ChallengeWizeline.tests;

import java.util.List;

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
		productsPage().clickOnAnyProduct();
		List<String> expectedProductName = inventoryItemPage().getProductName();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		shoppingCartPage().checkCorrectNamesAreAdded(expectedProductName);
	}
	
	@Test
	public void navigateToShoppingCartAndValidateProducts() 
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		List<String> expectedNames = productsPage().clickOnProductsAndAddThemToCart(3);
		inventoryItemPage().clickShoppingCartLink();
		shoppingCartPage().checkCorrectNamesAreAdded(expectedNames);
	}

}
