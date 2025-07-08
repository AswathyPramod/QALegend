package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageClasses.QALegendAllProjectsPage;
import pageClasses.QALegendClientPage;
import pageClasses.QALegendHomePage;
import pageClasses.QALegendInvoicePage;
import pageClasses.QALegendItemsPage;
import pageClasses.QaLegendLoginPage;
import utilities.ScreenshotUtility;


public class BaseClass {
	public WebDriver driver;
	public QaLegendLoginPage loginPage;
	public QALegendHomePage dashboard;
	public QALegendClientPage clientPage;
	public QALegendInvoicePage invoicePage;
	public QALegendItemsPage itemsPage;
	public QALegendAllProjectsPage allProjectsPage;
	public Properties prop;
	public FileInputStream fis;
		

		
	
	public WebDriver browserintialization(String browserName) throws Exception
{
	if( browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		
		
	}
	else if ( browserName.equalsIgnoreCase("FireFox")) {
		driver = new FirefoxDriver();
	} 
	else if (browserName.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	else {
		throw new Exception( "invalid name exception");
	
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	return driver; 
}
	@BeforeMethod
	@Parameters({"browser"})
	public void intialization(String browserName) throws Exception {
		System.out.println("beforeMethod");
		driver = browserintialization(browserName);
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\ApplicationData.properties");
		prop=new Properties();
		prop.load(fis);
		
		loginPage=new QaLegendLoginPage(driver);
		dashboard=new QALegendHomePage(driver);
		clientPage=new QALegendClientPage(driver);
		invoicePage=new QALegendInvoicePage(driver);
		itemsPage=new QALegendItemsPage(driver);
		allProjectsPage=new QALegendAllProjectsPage(driver);
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();  
		
	}
	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {
		if(itResult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility ss=new ScreenshotUtility();
			ss.captureFailureScreenShot(driver, itResult.getName());
			}
		if(driver!=null) {
			//driver.quit();
		}
	}

}
