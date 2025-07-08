package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtilitiy;

public class QALegendClientPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addClientButton;
	@FindBy(id = "company_name")
	WebElement companyNameField;
	@FindBy(id = "address")
	WebElement addressField;
	@FindBy(id = "phone")
	WebElement phoneField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@id='client-table_filter']//descendant::input")
	WebElement searchBox;
	@FindBy(xpath = "(//tr[@class='odd' or@class='even']//descendant::a)[1]")
	WebElement clientCell;
	
	@FindBy(xpath = "(//a[@class='edit'])[1]")
	WebElement editButton;
	
	@FindBy(xpath = "(//i[@class='fa fa-times fa-fw'])[1]")
	WebElement deleteButton;
	@FindBy(id = "confirmDeleteButton")
	WebElement deleteFromPopUp;
	
	
	
	public QALegendClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}





	public QALegendClientPage createClient(String companyName,String address,String phone) {
		PageUtilities.clickOnAnElement(addClientButton);
		PageUtilities.enterText(companyNameField, companyName);
		PageUtilities.enterText(addressField, address);
		phoneField.sendKeys(phone);
		saveButton.click();
		return this;
		
	}
	
	
	 
	public void searchClient(String clientName) {
		WaitUtilitiy.waitForElementToBeInvisible(driver, saveButton);
		PageUtilities.enterText(searchBox, clientName);
		
	}
	public String getCompanyCellValue() {
		String companyValue=PageUtilities.getTextFromAnElement(clientCell);
		return companyValue;
		
	}
	public void clickOnEditButton(int newPhoneNumber) {
		PageUtilities.clickOnAnElement(editButton);
		PageUtilities.clearText(phoneField);
		PageUtilities.enterNum(phoneField,newPhoneNumber);
		PageUtilities.clickUsingJavaScript(driver, saveButton);
	}
	public void clickOnDeleteButton() {
		PageUtilities.clickOnAnElement(deleteButton);
		PageUtilities.clickOnAnElement(deleteFromPopUp);
	}





	

}
