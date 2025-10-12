package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By username=By.id("email");
	private By pwd=By.id("passwd");
	private By btn=By.id("SubmitLogin");
	
	
	public void enterusername(String name) {
		driver.findElement(username).sendKeys(name);
	}
     
	public void enterpassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void clickonbtn() {
		driver.findElement(btn).click();
	}
	
	
	
}
