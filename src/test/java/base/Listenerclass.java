package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import io.qameta.allure.Attachment;
//we can use testlisteneradapter class too and extend it
public class Listenerclass extends Baseclass implements ITestListener{
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	ExtentTest test;
	
//	  @Attachment(value="page Screenshot", type = "image/png")
//		public byte[] savescreenshot(WebDriver driver) {
//			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			
//		}
//	    @Attachment(value="Testing", type = "text/plain")
//		public String savelogs(String message) {
//			return message;
//		}

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}
    public void onTestFailure(ITestResult result) {
    	test = extent.createTest("Screenshot");
    	if (driver instanceof TakesScreenshot) {
    		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		File destpath= new File("C:\\Users\\amitf\\eclipse-workspace\\Jobinterview\\Walmart\\screenshots\\"+"failed"+"_"+".jpg");
    		try {
    			FileUtils.copyFile(src, destpath);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		String absolutepathloc = destpath.getAbsolutePath();
 		test.addScreenCaptureFromPath(absolutepathloc);
    	}
    }

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
	
	}

	

}
