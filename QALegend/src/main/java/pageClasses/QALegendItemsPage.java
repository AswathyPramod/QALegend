package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtilitiy;

public class QALegendItemsPage {
	WebDriver driver;
	// add items
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addItemButton;
	@FindBy(id = "title")
	WebElement titleField;
	@FindBy(id = "item_rate")
	WebElement rateField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	@FindBy(xpath = "//td[text()='title74806']")
	WebElement itemCell;

	@FindBy(xpath = "//div[@id='item-table_filter']/label/child::input")
	WebElement searchBox;
	@FindBy(xpath = "(//a[@title='Delete'])[1]")
	WebElement deleteButton;

	public QALegendItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void addingItems(String title, int rate) {
		PageUtilities.clickOnAnElement(addItemButton);
		PageUtilities.enterText(titleField, title);
		PageUtilities.enterNum(rateField, rate);
		PageUtilities.clickOnAnElement(saveButton);

	}

	public void searchTitle(String titleName) {
		WaitUtilitiy.waitForElementToBeInvisible(driver, saveButton);
		PageUtilities.enterText(searchBox, titleName);

	}

	public String getItemCellValue() {
		String title = PageUtilities.getTextFromAnElement(itemCell);
		return title;

	}

	public void deletingItems() { // not running
		PageUtilities.clickUsingJavaScript(driver, deleteButton);
	}

}
