package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationCore.BaseClass;
import utilities.FakerUtility;
import utilities.RetryAnalyzer;

public class QALegendInvoiceTest extends BaseClass{
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void addInvoice() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();                                                      //doubt
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));            
		dashboard.clickOnInvoiceOptionButton(); 
		invoicePage.createInvoice();
		dashboard.clickOnInvoiceOptionButton();
	//	String invoiceName=invoicePage.getInvoiceStatus();
	//	invoicePage.searchInvoice(invoiceName);
		boolean actualStatus = invoicePage.invoiceFinder(); 
		AssertJUnit.assertEquals(actualStatus, true);
		softAssert.assertAll(); 
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void addPayment() {
		loginPage.loginToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnInvoiceOptionButton();
		int value= FakerUtility.getRandomNumber();
		invoicePage.addingPayment(value);
	    String exp=prop.getProperty("payment");
		AssertJUnit.assertEquals(value,exp);
	}

}
