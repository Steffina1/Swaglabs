package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Configreader {
	
	 Properties	prop =new Properties();
	 String exclpath = "C:\\Users\\amitf\\eclipse-workspace\\Jobinterview\\Walmart\\src\\test\\resources\\Configs\\configpropert.prop";
	 
	 public Configreader() {

			FileInputStream readfile;
			try {
				readfile = new FileInputStream(exclpath);
				try {
					prop.load(readfile);
				} catch (IOException e) {
					System.out.println("Error in loading file");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				System.out.println("File could not be read from path");
				e1.printStackTrace();
			}
		
				
		}
		
	 
	 public String baseurl() {
		 String url=prop.getProperty("baseurl");
		 return url;
	 }

	 public String validusername() {
		String validusername= prop.getProperty("vusername");
		return validusername;
	 }

	 public String validpassword() {
		String validpassword= prop.getProperty("vpassword");
		return validpassword;
	 }
	 public String invalidusername() {
			String invalidusername= prop.getProperty("inusername");
			return invalidusername;
		 }
	 public String invalidpassword1() {
			String invalidpassword1= prop.getProperty("inpassworda");
			return invalidpassword1;
		 }
	 public String invalidpassword2() {
			String invalidpassword2= prop.getProperty("inpasswordb");
			return invalidpassword2;
		 }
	 public String invalidpassword3() {
			String invalidpassword3= prop.getProperty("inpasswordc");
			return invalidpassword3;
		 }
}
