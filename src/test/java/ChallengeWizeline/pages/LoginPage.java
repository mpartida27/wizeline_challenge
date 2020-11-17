package ChallengeWizeline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ChallengeWizeline.utilities.CommonMethods;

public class LoginPage extends CommonMethods {

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(css="#user-name")
	WebElement userNameTextField;
	
	@FindBy(css="#password")
	WebElement userPasswordTextField;
	
	@FindBy(css="#login-button")
	WebElement loginButton;
	
	@FindBy(css="#login_button_container div form h3")
	WebElement errorLoginLabel;
	
	
	public void enterUserName(String text) 
	{
		enterText(userNameTextField, text);
	}
	
	public void enterUserPassword(String text) 
	{
		enterText(userPasswordTextField, text);
	}
	
	public void clickLoginButton() 
	{
		clickElement(loginButton);
	}
	
	public void checkErrorLoginMessage() 
	{
		Assert.assertTrue(isElementPresent(errorLoginLabel), "Error Login Message its not present");
	}
	
	public void checkUserNameFieldIsPresent() 
	{
		Assert.assertTrue(isElementPresent(userNameTextField), "Login Page its not loading correctly");
	}

}
