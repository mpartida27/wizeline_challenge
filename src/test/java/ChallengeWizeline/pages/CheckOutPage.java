package ChallengeWizeline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ChallengeWizeline.utilities.CommonMethods;

public class CheckOutPage extends CommonMethods {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#first-name")
	WebElement firstNameTextField;
	
	@FindBy(css="#last-name")
	WebElement lastNameTextField;
	
	@FindBy(css="#postal-code")
	WebElement postalCodeTextField;
	
	@FindBy(css="#checkout_info_container  div  form  h3")
	WebElement errorMessage;
	
	@FindBy(css=".btn_primary")
	WebElement  continueButton;
	
	public void isCheckOutLabelPresent() 
	{
		Assert.assertTrue(isElementPresent(firstNameTextField), "Check out Label its not present");
	}
	
	public void enterFirstName(String firstName) 
	{
		enterText(firstNameTextField, firstName);
	}
	
	public void enterLastName(String lastName) 
	{
		enterText(lastNameTextField, lastName);
	}
	
	public void enterPostalCode(String postalCode) 
	{
		enterText(postalCodeTextField, postalCode);
	}
	
	public void clickContinueButton() 
	{
		clickElement(continueButton);
	}
	
	public void checkErrorMessage(String expectedErrorMessage) 
	{
		System.out.println(">>>>>>" + errorMessage.getText());
		Assert.assertEquals(errorMessage.getText(),expectedErrorMessage, "Error Message its not matching to expected");
	}
	
	
	

}
