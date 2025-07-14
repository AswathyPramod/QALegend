package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QALegendHomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientOptionButton;
	
	@FindBy(xpath = "//span[text()='Invoices']")
	WebElement invoiceOptionButton;
	
	@FindBy(xpath = "//span[text()='Items']")
	WebElement itemsOptionButton;
	
	@FindBy(xpath = "//span[text()='Projects']")
	WebElement projectsButton;
	
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement allProjectsButton;
	
	
	
	public QALegendHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}


	public QALegendHomePage clickOnClientOptionButton() {
		PageUtilities.clickOnAnElement(clientOptionButton);
		return this;
	}
	public QALegendHomePage clickOnInvoiceOptionButton() {
		PageUtilities.clickOnAnElement(invoiceOptionButton);
		return this;
	}
	public QALegendHomePage clickOnItemsOptionButton() {
		PageUtilities.clickOnAnElement(itemsOptionButton);
		return this;
	}
	public QALegendHomePage clickOnAllProjectsOptionButton() {
		PageUtilities.clickOnAnElement(projectsButton);
		return this;
	}
	public QALegendHomePage clickOnProjectsButton() {
		PageUtilities.clickOnAnElement(allProjectsButton);
		return this;
	}
	

}
