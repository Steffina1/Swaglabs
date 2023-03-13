package pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;
import utilities.Configreader;
import utilities.Excelreader;

public class Aboutpageclass extends Baseclass{	
	WebDriver driver;
	
	
	By about = By.id("about_sidebar_link");
	By hamburger = By.id("react-burger-menu-btn");
	By cookieok = By.id("onetrust-accept-btn-handler");
	public Aboutpageclass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickabout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(hamburger));
		driver.findElement(hamburger).click();
		driver.findElement(about).click();
		driver.findElement(cookieok).click();
		System.out.println("clcikabout success");
		
	}
	
	public String gettitleofaboutpage() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		System.out.println("Exception");
		e.printStackTrace();
	}
		String titleofabout = driver.getTitle();
		return titleofabout;
		
	}

   
}
