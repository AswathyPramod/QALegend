package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import utilities.FakerUtility;
import utilities.RetryAnalyzer;

public class QALegendItemsTest extends BaseClass {
	@Test(retryAnalyzer = RetryAnalyzer.class)

	public void addItems() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnItemsOptionButton();
		String title = "title" + FakerUtility.getRandomNumber();
		int rate = FakerUtility.getRandomNumber();
		itemsPage.addingItems(title, rate);
		itemsPage.searchTitle(title);
		AssertJUnit.assertEquals(itemsPage.getItemCellValue(), title);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void deleteItems() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnItemsOptionButton();
		String title = "title" + FakerUtility.getRandomNumber();
		int rate = FakerUtility.getRandomNumber();
		itemsPage.addingItems(title, rate);
		itemsPage.searchTitle(title);
		itemsPage.deletingItems();
		AssertJUnit.assertEquals(itemsPage.getItemCellValue(), title);
	}

}
