package ChallengeWizeline.tests;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;
import ChallengeWizeline.utilities.Data;

public class CheckOutPageTests extends BaseTest {
		
	@Test(dataProvider="login-and-checkout-information", dataProviderClass = Data.class)
	public void validateMissingInformation(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickOnAnyProduct();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName(data.get("emptyValue"));
		checkOutPage().clickContinueButton();
		checkOutPage().checkErrorMessage(data.get("firstNameError"));
		checkOutPage().enterFirstName(data.get("firstName"));
		checkOutPage().clickContinueButton();
		checkOutPage().checkErrorMessage(data.get("lastNameError"));
		checkOutPage().enterLastName(data.get("lastName"));
		checkOutPage().clickContinueButton();
		checkOutPage().checkErrorMessage(data.get("postalCodeError"));
	}
	
	@Test(dataProvider="login-and-checkout-information", dataProviderClass = Data.class)
	public void validateCorrectInformation(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickOnAnyProduct();
		inventoryItemPage().clickAddToCartButton();
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName(data.get("firstName"));
		checkOutPage().enterLastName(data.get("lastName"));
		checkOutPage().enterPostalCode(data.get("postalCode"));
		checkOutPage().clickContinueButton();
		overviewPage().checkOverviewPageLoad();
	}
	
	@Test(dataProvider="login-and-checkout-information", dataProviderClass = Data.class)
	public void validateItemsOverviewInformation(HashMap<String, String> data)
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		List<String> expectedNames = productsPage().clickOnProductsAndAddThemToCart(3);
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName(data.get("firstName"));
		checkOutPage().enterLastName(data.get("lastName"));
		checkOutPage().enterPostalCode(data.get("postalCode"));
		checkOutPage().clickContinueButton();
		overviewPage().checkOverviewPageLoad();
		overviewPage().checkProdutsOnOverViewPage(expectedNames);
	}
	
	@Test(dataProvider="login-and-checkout-information", dataProviderClass = Data.class)
	public void finishPurchase(HashMap<String, String> data)
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		List<String> expectedNames = productsPage().clickOnProductsAndAddThemToCart(3);
		inventoryItemPage().clickShoppingCartLink();
		inventoryItemPage().clickCheckOutButton();
		checkOutPage().enterFirstName(data.get("firstName"));
		checkOutPage().enterLastName(data.get("lastName"));
		checkOutPage().enterPostalCode(data.get("postalCode"));
		checkOutPage().clickContinueButton();
		overviewPage().checkOverviewPageLoad();
		overviewPage().checkProdutsOnOverViewPage(expectedNames);
		overviewPage().clickFinishButton();
		overviewPage().checkOrderIsCompleted();
	}

}
