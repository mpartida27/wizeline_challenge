package ChallengeWizeline.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import ChallengeWizeline.utilities.BaseTest;
import ChallengeWizeline.utilities.Data;

public class ProductsPageTests extends BaseTest  
{
	
	@Test(dataProvider="login-user-credentials", dataProviderClass = Data.class)
	public void navigateToShoppingCartAndValidateProduct(HashMap<String, String> data) 
	{
		loginPage().enterUserName(data.get("username"));
		loginPage().enterUserPassword(data.get("password"));
		loginPage().clickLoginButton();
		productsPage().isProductsLabelPresent();
	}

	
}
