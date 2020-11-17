package ChallengeWizeline.tests;

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
	}

}
