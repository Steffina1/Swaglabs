package test_cases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Baseclass;
import base.Listenerclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageclasses.Saucelabpage;
import pageclasses.Registerpage;
@Listeners(Listenerclass.class)
public class Saucelab extends Baseclass{
	RegisterFunctionality rf;
	Saucelabpage sc;
	Registerpage rp;
	Logger logger = LogManager.getLogger(Saucelab.class);
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	ExtentTest test; //what details shd be populated in the report
	
	@BeforeTest
	public void setup() {	
		extent.setSystemInfo("Host name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User name", "Steffi");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
	    extent.attachReporter(spark);
	}
	

	
	@Test(groups="AddtoCart", priority=1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify sigin in login page")
	@Feature("Login")
	public void signin() throws IOException {
		System.out.println("opened signin test");
		logger.info("Testing login feature with valid credentials");
//		logger.trace("Trace msg");
//		logger.error("Error msg");
//		logger.debug("debugging");
		rp = new Registerpage(driver);
		rp.validlogin();
		logger.info("Checking if the user is directed to the home page");
		rp.checkvalidlogin();
	System.out.println("The user is logged in");
		
	}
	
	@Test(groups="AddtoCart", priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify add to cart")
	@Feature("Add to cart")
public void addtocart() {
		test = extent.createTest("Check add to cart");
		test.info("Adding to cart");
		sc=new Saucelabpage(driver);
		sc.clickaddtocart();
		
		}
	@Test(groups="AddtoCart", priority = 3)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify check to cart")
	@Feature("Add to cart")
	public void checkcart() {
		 test = extent.createTest("Check for items");
		 test.info("Checking cart");
		sc=new Saucelabpage(driver);
		int n =sc.checknoitems();
		Assert.assertEquals(n, 3);
	}
	
	@Test(groups="AddtoCart", priority = 4)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify click to cart")
	@Feature("Add to cart")
	public void cliccart() {
		 test = extent.createTest("Check for checkout");
		 test.info("Clicking cart");
		 test.log(Status.PASS, "passed");
		sc=new Saucelabpage(driver);
		String getcartcount = sc.clickcartandcheckout();
		Assert.assertEquals(getcartcount, "2");
	}
	
	
	@Test(groups="AddtoCart", priority = 5)
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify adding information")
	@Feature("Add to cart")
	public void enterinfo() {
		 test = extent.createTest("Check for info");
		 test.info("Entering information");
		sc=new Saucelabpage(driver);
		sc.enterinfor();
	}
	@AfterTest
	public void reportflush() {
		extent.flush();
	}
	

}
