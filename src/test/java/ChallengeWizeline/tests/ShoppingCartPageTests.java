package ChallengeWizeline.tests;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;
import ChallengeWizeline.utilities.Data;

public class ShoppingCartPageTests extends BaseTest {
	
	@Test(dataProvider="login-user-credentials", dataProviderClass = Data.class)
	public void navigateToShoppingCartAndValidateProduct(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickOnAnyProduct();
		List<String> expectedProductName = inventoryItemPage().getProductName();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		shoppingCartPage().checkCorrectNamesAreAdded(expectedProductName);
	}
	
	@Test(dataProvider="login-user-credentials", dataProviderClass = Data.class)
	public void navigateToShoppingCartAndValidateProducts(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		List<String> expectedNames = productsPage().clickOnProductsAndAddThemToCart(3);
		inventoryItemPage().clickShoppingCartLink();
		shoppingCartPage().checkCorrectNamesAreAdded(expectedNames);
	}

}
