package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtilitiy;

public class QALegendInvoicePage {
	WebDriver driver;

	@FindBy(xpath = "(//a[@class='btn btn-default mb0'])[2]")
	WebElement addInvoiceButton;
	@FindBy(xpath = "//input[@id='invoice_bill_date']")
	WebElement billDateField;
	@FindBy(id = "invoice_due_date")
	WebElement dueDateField;
	@FindBy(id = "s2id_invoice_client_id")
	WebElement clientField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@id='monthly-invoice-table_filter']/descendant::input")
	WebElement paymentSearch;
	@FindBy(xpath = "//span[@class='invoice-info-title']")
	WebElement invoiceHeader;

	@FindBy(xpath = "(//a[@class='btn btn-default mb0'])[1]")
	WebElement addPaymentButton;
	@FindBy(id = "select2-chosen-7")
	WebElement invoiceField;
	@FindBy(id = "invoice_payment_date")
	WebElement paymentDateField;
	@FindBy(id = "invoice_payment_amount")
	WebElement amountField;
	@FindBy(xpath = "//td[@class='today active day']")
	WebElement currentDay;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement addPaymentSaveButton;

	@FindBy(id = "80")
	WebElement deleteButtonInPayment;
	@FindBy(xpath = "(//button[@class='btn btn-default dropdown-toggle  mt0 mb0'])[1]")
	WebElement settingsButton;
	@FindBy(xpath = "(//a[@class='delete'])[1]")
	WebElement deleteButton;
	@FindBy(xpath = "//div[contains(@class,'page-title clearfix')]//child::h1")
	WebElement invoiceNum;

	public QALegendInvoicePage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

	public boolean invoiceFinder() {
		return (invoiceHeader.isDisplayed());
	}

	public String getInvoiceNum() {
		return (invoiceNum.getText());
	}

	public QALegendInvoicePage createInvoice() throws InterruptedException {
		PageUtilities.clickOnAnElement(addInvoiceButton);
		PageUtilities.clickOnAnElement(dueDateField);
	 // PageUtilities.clickUsingJavaScript(driver,currentDay);
		PageUtilities.pressEnterKey(driver);
		PageUtilities.clickOnAnElement(clientField);
		PageUtilities.pressDownArrowKey(driver);
		PageUtilities.pressEnterKey(driver);
		PageUtilities.clickOnAnElement(saveButton);
		return this;

	}

	public void searchInvoice(String invoiceName) {
		WaitUtilitiy.waitForElementToBeInvisible(driver, saveButton);
		PageUtilities.enterText(paymentSearch, invoiceName);
	}

	public QALegendInvoicePage addingPayment(int value) {
		PageUtilities.clickOnAnElement(addPaymentButton);
		PageUtilities.clickOnAnElement(invoiceField);
		PageUtilities.pressDownArrowKey(driver);
		PageUtilities.pressEnterKey(driver);
		PageUtilities.clickOnAnElement(paymentDateField);
		PageUtilities.pressEnterKey(driver);
		PageUtilities.enterNum(amountField, value);
		PageUtilities.clickOnAnElement(addPaymentSaveButton);
		return this;
	}

	public String getInvoiceStatus() {
		String status = PageUtilities.getTextFromAnElement(invoiceField);
		return status;

	}

}
