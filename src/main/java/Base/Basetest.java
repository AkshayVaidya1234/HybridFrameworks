package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utlis.Emailutlis;
import Utlis.ExtentReportManager;
import Utlis.Log;

public class Basetest {
	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setreporter() {
		extent=ExtentReportManager.getReportInstance();
	}
	
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();
		Log.info("Start chrome driver");
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		Log.info("Navigate url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
	   @AfterMethod
	   public void teardown(ITestResult result) {
		    if(result.getStatus()==ITestResult.FAILURE) {
		 String screenshotpath=ExtentReportManager.capturescreenshot(driver, "Login fail");
			   test.fail("Test Failed..check Screenshot",MediaEntityBuilder.
					   createScreenCaptureFromPath(screenshotpath).build());  
			   }
		    if(driver!=null) {
			   driver.close();
			   Log.info("close browser"); 
			   }
		    }
	   @AfterSuite
	   public void teardownreport() {
		   extent.flush();
		   String report=ExtentReportManager.reportPath;
		   Emailutlis.sendtestreport(report);
	   }

}
