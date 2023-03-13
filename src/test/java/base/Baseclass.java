package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageclasses.Registerpage;
import test_cases.RegisterFunctionality;
import utilities.Configreader;




public class Baseclass {
public	WebDriver driver;
   Logger logger = LogManager.getLogger(Baseclass.class);
	Configreader reader = new Configreader();
	public String validusername = reader.validusername();
	public String validpassword = reader.validpassword();
	public String invalidusername = reader.invalidusername();
	public String invalidpassword1 = reader.invalidpassword1();
	public String invalidpassword2 = reader.invalidpassword2();
	public String invalidpassword3 = reader.invalidpassword3();
	//@Parameters("browser")
	@BeforeGroups("ValidLogin")
	public void openurl() throws IOException {
	
		logger.info("Opening url to check login valid credentials");
		//if(browsername.equalsIgnoreCase("chrome")) {
//		ChromeOptions co = new ChromeOptions();
//		co.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(reader.baseurl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
					
	}
//	@BeforeMethod(onlyForGroups= {"InvalidLogin"})
//	public void openurl1() throws IOException {
//		logger.info("Opening url to check login with invalid credentials");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get(reader.baseurl());
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			
//					
//	}
//		
//@AfterMethod(onlyForGroups= {"ValidLogin"}) 
//public void driverclose() {
//	driver.close();
//}
	
@AfterMethod(onlyForGroups= {"InvalidLogin"}) 
public void driverclosed() {
	driver.close();
}	
	

}




//////////window handles///////////
//String parenthandle = driver.getWindowHandle();
//Set<String> handles = driver.getWindowHandles();
// System.out.println("The total no of handles are" +handles.size());
// for(String handle : handles) {
//	 if(!handle.equals(parenthandle)) {
//		 driver.switchTo().window(handle);
//		 System.out.println("Second window" +handle);
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='w_jaHf']")));
//		driver.findElement(By.xpath("//button[@class='w_jaHf']")).click();
//	 }}
// driver.switchTo().window(parenthandle);