package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtilitiy;

public class QALegendAllProjectsPage {
	
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Projects']")
	WebElement projectsButton;
	
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement allProjectsButton;
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addProjectButton;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@id='project-table_filter']//descendant::input[@type='search']")
	WebElement searchBox;
	//deleting
	@FindBy(xpath = "(//I[@class='fa fa-times fa-fw'])[1]")
	WebElement deleteIcon;
	@FindBy(id = "confirmDeleteButton")
	WebElement deleteButton;
	
	//edit
	@FindBy(xpath = "(//a[@class='edit'])[1]")
	WebElement editIcon;
	
	
	
	
	public QALegendAllProjectsPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void addingProject(String name) {
		PageUtilities.clickOnAnElement(projectsButton);
		PageUtilities.clickOnAnElement(allProjectsButton);
		PageUtilities.clickOnAnElement(addProjectButton);
		PageUtilities.enterText(titleField, name);
		PageUtilities.clickOnAnElement(saveButton);
		
	}
	public void searchProject(String projectName) {
		WaitUtilitiy.waitForElementToBeInvisible(driver, saveButton);
		PageUtilities.enterText(searchBox, projectName);
		
	}
	public void deletingProject() {
		PageUtilities.clickOnAnElement(deleteIcon);
		PageUtilities.clickOnAnElement(deleteButton);
	}
	public void editProject(String newTitle) {
		PageUtilities.clickOnAnElement(editIcon);
		PageUtilities.clearText(titleField);
		PageUtilities.enterText(titleField, newTitle);
		PageUtilities.clickOnAnElement(saveButton);// how to clear the search field
	//	PageUtilities.clickOnAnElement(searchBox);
		PageUtilities.clearText(searchBox);
	}
}
