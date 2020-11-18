package ChallengeWizeline.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ChallengeWizeline.utilities.CommonMethods;

public class OverviewPage extends CommonMethods
{

	public OverviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".summary_total_label")
	WebElement summaryTotalLabel;
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> productsNameLabels;
	
	@FindBy(css=".btn_action")
	WebElement finishButton;
	
	@FindBy(css=".complete-header")
	WebElement successOrderLabel;
	
	
	public void checkOverviewPageLoad() 
	{
		Assert.assertTrue(isElementPresent(summaryTotalLabel), "Overview Page its not loading correctly");
	}
	
	public void checkProdutsOnOverViewPage(List<String> expectedProductNames) 
	{
		compareTwoLists(expectedProductNames, productsNameLabels);
	}
	
	public void checkOrderIsCompleted() 
	{
		Assert.assertTrue(isElementPresent(successOrderLabel), "The order its not getting complete successfully");
	}
	
	public void clickFinishButton() 
	{
		clickElement(finishButton);
	}
	
}
