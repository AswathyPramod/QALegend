package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static final ExtentReports extent=new ExtentReports();
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\test-output\\reports.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aswathy");
		return extent;
		
		
	}

}
