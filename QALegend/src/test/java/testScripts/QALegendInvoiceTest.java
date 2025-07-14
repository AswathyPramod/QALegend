package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationCore.BaseClass;
import utilities.FakerUtility;

public class QALegendInvoiceTest extends BaseClass{
	@Test
	public void addInvoice() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));            
		dashboard.clickOnInvoiceOptionButton(); 
		invoicePage.createInvoice();
		String invoiceName=invoicePage.getInvoiceStatus();
		invoicePage.searchInvoice(invoiceName);
		boolean actualStatus = invoicePage.invoiceFinder(); 
		softAssert.assertEquals(actualStatus, true);
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

}
