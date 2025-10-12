package Test;

import org.testng.annotations.Test;

import Base.Basetest;
import Pages.LoginPage;

public class LoginTest extends Basetest {
	
	@Test
	public void login() {
		LoginPage lp= new LoginPage(driver);
		lp.enterusername("akshayvaidya733@gmail.com");
		lp.enterpassword("Bhmpyaa@77");
		lp.clickonbtn();
		
		System.out.println("Title is:"+driver.getTitle());
		
		
		
	}

}
