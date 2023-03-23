package pageclasses;

import java.time.Duration;
//import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import base.Baseclass;

import utilities.Configreader;
import utilities.Excelreader;

public class Saucelabpage extends Baseclass{	
	WebDriver driver;
	Excelreader excel;
	  Configreader reader;
	By about = By.id("about_sidebar_link");
	By hamburger = By.id("react-burger-menu-btn");
	By cookieok = By.id("onetrust-accept-btn-handler");
	@FindBy (xpath="//div[@class='MuiContainer-root MuiContainer-maxWidthXl MuiContainer-disableGutters css-1orecca']/div/div/div/div/div/div/div/span")
	WebElement product;
	@FindBy (xpath="//*[text()='The Sauce DevOps Test Toolchain']")
	WebElement firstproduct;
	@FindBy (xpath="//*[text()='Sauce Cross-Browser']")
	WebElement secproduct;
	@FindBy (xpath="//*[text()='Sauce Mobile']")
	WebElement thirdproduct;
	@FindBy (xpath="//*[text()='Sauce Low-Code']")
	WebElement fourthproduct;
	@FindBy (xpath="//*[text()='Sauce Error Reporting']")
	WebElement fifthproduct;
	@FindBy (xpath="//*[text()='Sauce API Quality']")
	WebElement sixthproduct;
	@FindBy (xpath="//*[text()='Sauce Visual']")
	WebElement seventhproduct;
	@FindBy (xpath="//*[text()='Sauce Performance']")
	WebElement eightproduct;
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addtocartitem1;
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement addtocartitem2;
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement addtocartitem3;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement checkcartno;
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement clickcart;
	@FindBy(id="checkout")
	WebElement checkout;
	@FindBy(id="first-name")
	WebElement firstname;
	@FindBy(id="last-name")
	WebElement lastname;
	@FindBy(id="postal-code")
	WebElement postalcode;
	@FindBy(id="continue")
	WebElement continuew;
	@FindBy(id="remove-sauce-labs-bike-light")
	WebElement remove;
	@FindBy(id="finish")
	WebElement finish;
	@FindBy(xpath="//span[@class='title']")
	WebElement checkouttitle;
	public Saucelabpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickabout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(hamburger));
		driver.findElement(hamburger).click();
		driver.findElement(about).click();
		Thread.sleep(2000);
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
	
	
	public void clickproducts() {

		System.out.println("start moving to product");
		product.click();
		List<WebElement> lst = new ArrayList<WebElement>();
		lst.add(firstproduct);
		lst.add(secproduct);
		lst.add(thirdproduct);
		lst.add(fourthproduct);
		lst.add(fifthproduct);
		lst.add(sixthproduct);
		lst.add(seventhproduct);
		lst.add(eightproduct);
		for(WebElement e:lst) {
			e.click();
//			WebDriverWait waitee = new WebDriverWait(driver, Duration.ofSeconds(30));
//			waitee.until(ExpectedConditions.visibilityOf(e));
			boolean checkname = e.isDisplayed();
			System.out.println("Element is displayed" + checkname);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			wait.until(ExpectedConditions.elementToBeClickable(product));
			product.click();			
	}
	

   
}
	
	public void clickaddtocart() {
		List<WebElement> lsadt = new ArrayList<WebElement>();
		lsadt.add(addtocartitem1);
		lsadt.add(addtocartitem2);
		lsadt.add(addtocartitem3);
		for(WebElement l : lsadt) {
			l.click();
			System.out.println("clicked");
		}
		
		
		
	}
	
	public int checknoitems() {
		List<WebElement> lsad = new ArrayList<WebElement>();
		lsad.add(addtocartitem1);
		lsad.add(addtocartitem2);
		lsad.add(addtocartitem3);
		int n=lsad.size();
		System.out.println("cart size is" +n);
		return n;
		
		
	}
	
	public String clickcartandcheckout() {
		clickcart.click();
		remove.click();
		String cartno=checkcartno.getText();
		checkout.click();
		System.out.println("clicked check out");
		return cartno;
	}
	
	public void enterinfor() {	
		System.out.println("Inside enterinfo");
		excel= new Excelreader("swag");
		  reader= new Configreader();
			Map<String, String> c = excel.username();
			firstname.sendKeys(c.get(fname));
			lastname.sendKeys(c.get(lname));
			postalcode.sendKeys(c.get(zcode));
			continuew.click();
			finish.click();
	}
	
	public String checkcheckout() {
		String chkouttitle=checkouttitle.getText();
		return chkouttitle;
	}
}
