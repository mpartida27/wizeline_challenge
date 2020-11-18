package ChallengeWizeline.tests;


import java.util.HashMap;

import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;
import ChallengeWizeline.utilities.Data;

public class LoginPageTests extends BaseTest 
{
	@Test(dataProvider="login-user-credentials", dataProviderClass = Data.class)
	public void validLoginTest(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
	}
	
	@Test(dataProvider="login-user-credentials", dataProviderClass = Data.class)
	public void LoginInvalidUser(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("invalidUser"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		loginPage().checkErrorLoginMessage();
	}
	
	@Test(dataProvider="login-user-credentials", dataProviderClass = Data.class)
	public void LoginAndLogOut(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
		productsPage().clickburgerMenuButton();
		productsPage().clickLogoutLink();
		loginPage().checkUserNameFieldIsPresent();
	}	
}
