package ChallengeWizeline.tests;


import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;

public class LoginPageTests extends BaseTest 
{
	@Test
	public void validLoginTest() 
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
	}
	
	@Test
	public void LoginInvalidUser() 
	{
		loginPage().enterUserName("invalid_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		loginPage().checkErrorLoginMessage();
	}
	
	@Test
	public void LoginAndLogOut() 
	{
		loginPage().enterUserName("standard_user");
		loginPage().enterUserPassword("secret_sauce");
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickburgerMenuButton();
		productsPage().clickLogoutLink();
		loginPage().checkUserNameFieldIsPresent();
	}	
}
