package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import utilities.FakerUtility;

public class QALegendItemsTest extends BaseClass {
	@Test

	public void addItems() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnItemsOptionButton();
		String title = "title" + FakerUtility.getRandomNumber();
		int rate = FakerUtility.getRandomNumber();
		itemsPage.addingItems(title, rate);
		itemsPage.searchTitle(title);
		Assert.assertEquals(itemsPage.getItemCellValue(), title);
	}

	@Test
	public void deleteItems() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnItemsOptionButton();
		String title = "title" + FakerUtility.getRandomNumber();
		int rate = FakerUtility.getRandomNumber();
		itemsPage.addingItems(title, rate);
		itemsPage.searchTitle(title);
		itemsPage.deletingItems();
		Assert.assertEquals(itemsPage.getItemCellValue(), title);
	}

}
