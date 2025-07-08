package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class QALegendUserTest extends BaseClass{
	@Test
	public void addClient() throws IOException {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName=ExcelUtility.getStringData(1,0, Constant.CLIENTDATAEXCELFILEPATH,"ClientData")+FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(),ExcelUtility.getIntegerData(1, 1, Constant.CLIENTDATAEXCELFILEPATH,"ClientData"));
		clientPage.searchClient(companyName);
		Assert.assertEquals(clientPage.getCompanyCellValue(), companyName);
	}
	@Test
	public void editClient() {                                                                  //failure
		SoftAssert softAssert=new SoftAssert();
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String com=prop.getProperty("companyName");//+FakerUtility.getRandomNumber();
		clientPage.createClient(com, FakerUtility.getFakerAddress(), "6789552147");
		clientPage.searchClient(com);
		int newPhoneNumber=FakerUtility.getRandomNumber();
		clientPage.clickOnEditButton(newPhoneNumber);
		String name=clientPage.getCompanyCellValue();
		softAssert.assertEquals(name,prop.getProperty("companyName"));
		System.out.println(name);
		softAssert.assertAll();
	}
	@Test
	public void deleteClient() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName="Stride"+FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), "6789552147");
		clientPage.searchClient(companyName);
		clientPage.clickOnDeleteButton();
		Assert.assertEquals(clientPage.getCompanyCellValue(), companyName, "Deleted client still appears in the table.");
	}
	
	@Test
	public void addInvoice() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnInvoiceOptionButton(); 
		invoicePage.createInvoice();
		String actualStatus = invoicePage.getInvoiceStatus(); // You need to implement this method
		softAssert.assertEquals(actualStatus, "Not Paid", "Invoice status doesn't match expected value.");
		softAssert.assertAll(); 
	}
	@Test
	public void addPayment() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnInvoiceOptionButton();
		int value= FakerUtility.getRandomNumber();
		invoicePage.addingPayment(value);
	    String exp=prop.getProperty("payment");
		Assert.assertEquals(value,exp);
	}
	@Test
	public void deleteInvoice() throws InterruptedException { 
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnInvoiceOptionButton();
		invoicePage.createInvoice();
		invoicePage.deletingInvoice();
		
	}
	@Test
	public void deletePayment() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnInvoiceOptionButton();
		int value= FakerUtility.getRandomNumber();
		invoicePage.addingPayment(value);
		
	}

}
