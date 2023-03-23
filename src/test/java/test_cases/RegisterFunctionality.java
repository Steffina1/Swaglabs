package test_cases;




import java.io.IOException;

//import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Baseclass;
//import base.Listenerclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageclasses.Saucelabpage;
import pageclasses.Registerpage;
//@Listeners(Listenerclass.class)
public class RegisterFunctionality extends Baseclass {
	Logger logger = LogManager.getLogger(RegisterFunctionality.class);
	Registerpage rp;
	Saucelabpage ab;

	@Test(description = "Validlogin", groups= {"ValidLogin", "TestAboutpage"}, priority = 1)
	public void login() throws IOException {
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
	
	
	@Test(description = "Invalidlogin", groups= {"InvalidLogin"}, priority = 1)
	public void invalidusernamepassword() {
		logger.info("Testing login feature with invalid credentials");
		rp = new Registerpage(driver);
		rp.invalidusernamepassword();
		rp.checkinvalidlogin();
		
	}
	
	@Test(description = "Invalidlogin", groups= {"InvalidLogin"}, priority = 2)
	public void validusernameinvalidpassword() {
		rp = new Registerpage(driver);
		rp.validusernameinvalidpassword();
		rp.checkinvalidlogin();
	}
	
	@Test(description = "Invalidlogin", groups= {"InvalidLogin"}, priority = 3)
	public void invalidusernamevalidpassword() {
		rp = new Registerpage(driver);
		rp.invalidusernamevalidpassword();
		rp.checkinvalidlogin();
	}
		
	@Test(description = "Validlogin", groups= {"ValidLogin", "TestAboutpage"}, priority = 2) 
	public void clickabout() throws InterruptedException {
		ab= new Saucelabpage(driver);
		ab.clickabout();
		System.out.println("The user clicks on about");
	}
	
	@Test(description = "Validlogin", groups= {"ValidLogin"}, priority = 3) 
	public void checaboutpage() {
		ab= new Saucelabpage(driver);
		String title = ab.gettitleofaboutpage();
		System.out.println(title);
		//Assert.assertEquals(title, "SauceLabs");

}
	@Test(groups= {"TestAboutpage"}, priority =3)
	public void hoveroverproducts() {
		ab = new Saucelabpage(driver);
		System.out.println("The user is in clcikproduct");
		ab.clickproducts();
		System.out.println("The user clciks on products");
	}
}
