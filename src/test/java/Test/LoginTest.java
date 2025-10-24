package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Basetest;
import Pages.LoginPage;
import Utlis.ExcelUtlis;
import Utlis.ExtentReportManager;
import Utlis.Log;

public class LoginTest extends Basetest {
	
	@Test(dataProvider = "Login Test")
	public void login(String username,String password) {
		Log.info("Start test");
		test=ExtentReportManager.createTest("Login Test"+username);
		
		
		LoginPage lp= new LoginPage(driver);
		test.info("lauch url");
		Log.info("enter credantials");
		test.info("enter valid credentails");
//		lp.enterusername("akshayvaidya733@gmail.com");
//		lp.enterpassword("Bhmpyaa@77");
		lp.enterusername(username);
		lp.enterpassword(password);
		lp.clickonbtn();
		
		test.info("click on sighup btn");
	//	System.out.println("Title is:"+driver.getTitle());
		
		String actualtitle="My account - My Shop";
		String exceptedtitle=driver.getTitle();
		
		Assert.assertEquals(actualtitle,exceptedtitle);
			Log.info("validate title");	}
//	@Test
//	public void title() {
//		Log.info("Start test");
//		test=ExtentReportManager.createTest("Login Test");
//		
//		
//		LoginPage lp= new LoginPage(driver);
//		test.info("lauch url");
//		Log.info("enter credantials");
//		test.info("enter valid credentails");
//		lp.enterusername("akshayvaidya733@gmail.com");
//		lp.enterpassword("Bhmpyaa@7");
//		lp.clickonbtn();
//		
//		test.info("click on sighup btn");
//	//	System.out.println("Title is:"+driver.getTitle());
//		
//		String actualtitle="My account - My Shop";
//		String exceptedtitle=driver.getTitle();
//		
//		Assert.assertEquals(actualtitle,exceptedtitle);
//		
//		
//		Log.info("validate title");
//		
//	}

	
	@DataProvider(name="Login Test")
	public Object[][]getlogindata() throws IOException{
		String filepath=System.getProperty("user.dir")+"/TestData/Data.xlsx";
		ExcelUtlis.loadExcel(filepath, "Sheet1");
		int rowcount= ExcelUtlis.getrowcount();
		Object[][] data= new Object[rowcount-1][2];
		
		for(int i=1;i<rowcount;i++) {
			data[i-1][0]=ExcelUtlis.getcelldata(i, 0);
			data[i-1][1]=ExcelUtlis.getcelldata(i, 1);
		}
		ExcelUtlis.closeexcel();
		return data;
	}
	
	
}
