package ChallengeWizeline.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseTest 
{
	protected WebDriver driver;
	WebDriverWait wait;
	
	public CommonMethods (WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,10);
		PageFactory.initElements(driver, this);
	}
	
	public void clickElement(WebElement element) 
	{
		waitForElementToBeVisible(element);
		element.click();
	}
	
	public void enterText(WebElement element, String text) 
	{
		clickElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	public void waitForElementToBeVisible(WebElement element) 
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean isElementPresent(WebElement element) 
	{
		WebElement elementPresent = wait.until(ExpectedConditions.visibilityOf(element));
		if (elementPresent != null) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int randomBumber(int size) 
	{
		 Random rand = new Random();
		 int randomNumber = rand.nextInt(size);
		 return randomNumber; 
	}
	
	public void clickRandomElementFromAList(List <WebElement> elements) 
	{
		int randomNumber = randomBumber(elements.size()); 
		elements.get(randomNumber).click();	
	}
	
	public void clickElementsFromAList(List <WebElement> elements, int number) 
	{
		List<WebElement> elementsList = elements;
		if(number <= elementsList.size()) 
		{
			elementsList.get(number).click();
		}
	}
	
	public String getElementText(WebElement element) 
	{
		return element.getText();
	}
	
	public List<String> getElementsText(List<WebElement> elements)
	{
		List<WebElement> elementsList = elements;
		List<String> listToString=new ArrayList<String>();
		for (int i = 0; i < elementsList.size(); i++) {
			listToString.add(elementsList.get(i).getText());
		}
		
		return listToString;
	}
	
	public void goBack() 
	{
		driver.navigate().back();
	}
}
