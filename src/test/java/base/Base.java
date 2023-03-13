//package base;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import utilities.Configreader;
//
//public class Base {
//	public	WebDriver driver;
//	Configreader reader;
//	//@Parameters("browser")
//	
//	public void openurl() {
//		reader = new Configreader();
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://www.walmart.com/");
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			if(driver.findElement(By.id("ld_modalTitle_0")).isDisplayed()) {
//			driver.findElement(By.xpath("//button[text()='Try a different method']")).click();
//			System.out.println("clicked");
//			driver.close();
//			}
//			else {
//				System.out.println("Pop up absent");
//			}
//}
//	
//	public void teardown() {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src= ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File( "C:\\Users\\amitf\\eclipse-workspace\\Jobinterview\\Walmart\\target");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//}
