package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicedriversetup {

	static WebDriver driver;
	public static void startdriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amitf\\eclipse-workspace\\Jobinterview\\Walmart\\web driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
	}
	public static void main(String[] args) {
	
		startdriver();
	}

}
