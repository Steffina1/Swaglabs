package pageclasses;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Baseclass;
import utilities.Configreader;
import utilities.Excelreader;

public class Registerpage extends Baseclass {
	
	Excelreader excel;
	WebDriver driver;
    Configreader reader;
	@FindBy(id = "user-name")
	WebElement usernme;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement login;
	
	
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validlogin() throws IOException {
		excel= new Excelreader("swag");
	  reader= new Configreader();
		Map<String, String> vc = excel.username();
			usernme.sendKeys(vc.get(validusername));
			password.sendKeys(vc.get(validpassword));
				login.click();
		}
		
	
	
	public boolean checkvalidlogin() {
		String title = driver.findElement(By.xpath("//span[text()='Products']")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "Products");
		return true;
		
	}
	
	public void invalidusernamepassword() {
		excel= new Excelreader("swag");
		Map<String, String> vb = excel.username();
		usernme.sendKeys(vb.get(invalidusername));
		password.sendKeys(vb.get(invalidpassword1));
		login.click();
		
	}
	public void validusernameinvalidpassword() {
		excel= new Excelreader("swag");
		Map<String, String> vb = excel.username();
		usernme.sendKeys(vb.get(validusername));
		password.sendKeys(vb.get(invalidpassword2));
		login.click();
		
	}
	public void invalidusernamevalidpassword() {
		excel= new Excelreader("swag");
		Map<String, String> vb = excel.username();
		usernme.sendKeys(vb.get(invalidusername));
		password.sendKeys(vb.get(validpassword));
		login.click();
	}
	public boolean checkinvalidlogin() {
		String error = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(error);
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		return true;
		
	}
	
	
}
