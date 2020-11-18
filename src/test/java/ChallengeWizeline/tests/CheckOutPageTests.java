package ChallengeWizeline.tests;

import java.util.List;

import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;

public class CheckOutPageTests extends BaseTest {
	
	@Test
	public void validateMissingInformation() 
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickOnAnyProduct();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName("");
		checkOutPage().clickContinueButton();
		checkOutPage().checkErrorMessage("Error: First Name is required");
		checkOutPage().enterFirstName("Juanito");
		checkOutPage().clickContinueButton();
		checkOutPage().checkErrorMessage("Error: Last Name is required");
		checkOutPage().enterLastName("Bond");
		checkOutPage().clickContinueButton();
		checkOutPage().checkErrorMessage("Error: Postal Code is required");
	}
	
	@Test
	public void validateCorrectInformation() 
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickOnAnyProduct();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName("Juanito");
		checkOutPage().enterLastName("Bond");
		checkOutPage().enterPostalCode("11111");
		checkOutPage().clickContinueButton();
		overviewPage().checkOverviewPageLoad();
	}
	
	@Test
	public void validateItemsOverviewInformation()
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		List<String> expectedNames = productsPage().clickOnProductsAndAddThemToCart(3);
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName("Juanito");
		checkOutPage().enterLastName("Bond");
		checkOutPage().enterPostalCode("11111");
		checkOutPage().clickContinueButton();
		overviewPage().checkOverviewPageLoad();
		overviewPage().checkProdutsOnOverViewPage(expectedNames);
	}
	
	@Test
	public void finishPurchase()
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		List<String> expectedNames = productsPage().clickOnProductsAndAddThemToCart(3);
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName("Juanito");
		checkOutPage().enterLastName("Bond");
		checkOutPage().enterPostalCode("11111");
		checkOutPage().clickContinueButton();
		overviewPage().checkOverviewPageLoad();
		overviewPage().checkProdutsOnOverViewPage(expectedNames);
		overviewPage().clickFinishButton();
		overviewPage().checkOrderIsCompleted();
	}

}
