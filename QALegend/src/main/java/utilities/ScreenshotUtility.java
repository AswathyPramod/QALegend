package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void captureFailureScreenShot(WebDriver driver,String testcaseName) throws IOException {
		TakesScreenshot scrshot=(TakesScreenshot) driver;
		File screenshot =scrshot.getScreenshotAs(OutputType.FILE);
		File f1=new File(System.getProperty("user.dir")+"\\OutputScreenshots");
		if(!f1.exists()) {
			f1.mkdirs();
		}
		String timeStamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0));
		File finalDestination=new File(System.getProperty("user.dir")+"\\outputScreenshots\\"+testcaseName+"_"+timeStamp+".png");
		FileHandler.copy(screenshot, finalDestination);
	}

}
