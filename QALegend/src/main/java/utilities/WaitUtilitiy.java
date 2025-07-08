package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;

public class WaitUtilitiy {
	public static void waitForElementToBeClickable(WebDriver driver,WebElement target) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
		
	public static void waitForElementToBePresent(WebDriver driver,WebElement target, String value) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.textToBePresentInElement(target,value));
	}
	public static void waitForElementToBeVisible(WebDriver driver,WebElement target, String value) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForElementToBeInvisible(WebDriver driver,WebElement target) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(target));
	}
	public static void waitForAnAlert(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

}