package utilities;

import java.awt.Desktop.Action;
import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public static void clickOnAnElement(WebElement element) {
		element.click();
	}
	public static void enterText(WebElement element,String username){
		element.sendKeys(username);
	} 
	public static void doubleClick(WebDriver driver, WebElement element)	{
		Actions action = new Actions(driver); 
		action.doubleClick(element).build().perform();
	}
	public static void selectByVisibleText(WebElement element,String value) {
		Select obj=new Select(element);
		obj.selectByVisibleText(value);
	}
	public static String getTextFromAnElement(WebElement element) {
		return(element.getText());
	}
	public static void selectByValue(WebElement element,String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	public static void selectByIndex(WebElement element,int index) {
		Select obj1 = new Select(element);
		obj1.selectByIndex(index);
	} 
	public static void dragAndDrop(WebDriver driver, WebElement source,WebElement destination) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	} 
	public static void clearText(WebElement element) {
		element.clear();
		
	}
	public static void scrollTillElementVisible(WebDriver driver,WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver; //to convert Java compiler to JavaScript compiler
		 js.executeScript("arguments[0].scrollIntoView(true);", element );
	}
	public static void isEnabled(WebElement element) {
		element.isEnabled();
	}
	public static void isDisplayed(WebElement element) {
		element.isDisplayed();
	}
	public static void getAttribute(WebElement element,String value) {
		element.getAttribute(value);
	}
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	 public static String getAlertText(WebDriver driver) {
		 return driver.switchTo().alert().getText();
	 }
	 public static void pressEscapeKey(WebDriver driver,WebElement element) {
		 Actions action=new Actions(driver);
		 action.sendKeys(Keys.ESCAPE).build().perform();
	 }
	 public static void pressCtrlKey(WebDriver driver) {
	        Actions actions = new Actions(driver);
	        actions.keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
	 }
	 public static void pressEnterKey(WebDriver driver) {
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ENTER).build().perform();
	 }
	 public static void pressAltKey(WebDriver driver) {
		    Actions actions = new Actions(driver);
		    actions.keyDown(Keys.ALT).keyUp(Keys.ALT).build().perform();
	 }
	 public static void rightClick(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.contextClick(element).build().perform();
	 }
	 public static void clickUsingJavaScript(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);
	 }
	 public static void pressDownArrowKey(WebDriver driver) {
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
	 }
	public static void arrowKeyDown(WebDriver driver) {
		// TODO Auto-generated method stub
		 Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
	}
	public static void enterKeyPress(WebDriver driver) {
		// TODO Auto-generated method stub
		 Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ENTER).build().perform();
	}
	public static void enterNum(WebElement element, int number) {
	    element.sendKeys(String.valueOf(number));
	} 


	
}
