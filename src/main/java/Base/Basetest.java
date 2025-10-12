package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basetest {
	
	
	protected WebDriver driver;
	
	
	@BeforeMethod
	
	public void setup() {
		driver= new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		}
	
	   @AfterMethod
	   public void teardown() {
		   if(driver!=null) {
			   driver.close();
		   }
	   }

}
