package test_cases;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import pageclasses.Aboutpageclass;
import pageclasses.Registerpage;

public class RegisterFunctionality extends Baseclass {
	Logger logger = LogManager.getLogger(RegisterFunctionality.class);
	Registerpage rp;
	Aboutpageclass ab;
	@Test(description = "Validlogin", groups= {"ValidLogin"}, priority = 1)
	public void login() throws IOException {
		logger.info("Testing login feature with valid credentials");
//		logger.trace("Trace msg");
//		logger.error("Error msg");
//		logger.debug("debugging");
		rp = new Registerpage(driver);
		rp.validlogin();
		logger.info("Checking if the user is directed to the home page");
		rp.checkvalidlogin();
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
		
	@Test(description = "Validlogin", groups= {"ValidLogin"}, priority = 2) 
	public void clickabout() {

		ab= new Aboutpageclass(driver);
		ab.clickabout();
	}
	
	@Test(description = "Validlogin", groups= {"ValidLogin"}, priority = 3) 
	public void checaboutpage() {
		ab= new Aboutpageclass(driver);
		String title = ab.gettitleofaboutpage();
		Assert.assertEquals(title, "SauceLabs");

}
}
