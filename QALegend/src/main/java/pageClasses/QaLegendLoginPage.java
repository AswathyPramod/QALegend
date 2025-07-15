package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QaLegendLoginPage {
	WebDriver driver;
	@FindBy(id = "email")
	WebElement userNameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block mt15']")
	WebElement signInButton;

	public QaLegendLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void loginToQALegend(String username, String password) {
		PageUtilities.enterText(userNameField, username);
		PageUtilities.enterText(passwordField, password);
		PageUtilities.clickOnAnElement(signInButton);

	}

}
