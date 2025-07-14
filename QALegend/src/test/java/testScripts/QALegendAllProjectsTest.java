package testScripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import utilities.FakerUtility;
import utilities.RetryAnalyzer;

public class QALegendAllProjectsTest extends BaseClass {
	@Test//(retryAnalyzer = RetryAnalyzer.class)
	public void addProject() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnAllProjectsOptionButton();
		dashboard.clickOnProjectsButton();
		String name="TitleUser"+FakerUtility.getRandomNumber();
		allProjectsPage.addingProject(name);
		allProjectsPage.searchProject(name);
		Assert.assertEquals(allProjectsPage.getAllProjectCellValue(), name);
		
		
	}
	@Test
	public void deleteProject() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnAllProjectsOptionButton();
		dashboard.clickOnProjectsButton();
		String name="TitleUser"+FakerUtility.getRandomNumber();
		allProjectsPage.addingProject(name);
		allProjectsPage.searchProject(name);
		allProjectsPage.deletingProject();
		Assert.assertEquals(allProjectsPage.getAllProjectCellValue(), name);
	}
	@Test
	public void editingProject() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnAllProjectsOptionButton();
		dashboard.clickOnProjectsButton();
		String name="TitleUser"+FakerUtility.getRandomNumber();
		allProjectsPage.addingProject(name);
		allProjectsPage.searchProject(name);
		String newTitle="TitleUser"+FakerUtility.getRandomNumber();
		allProjectsPage.editProject(newTitle);
		allProjectsPage.searchProject(newTitle);
		Assert.assertEquals(allProjectsPage.getAllProjectCellValue(), newTitle);
	}

}
