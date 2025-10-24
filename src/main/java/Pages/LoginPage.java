package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlis.Log;

public class LoginPage {
	 
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="passwd")
	WebElement pwd;
	@FindBy(id="SubmitLogin")
	WebElement btn;
	
	public void enterusername(String name) {
		username.sendKeys(name);
	}
     
	public void enterpassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickonbtn() {
		btn.click();
	}
	
	
	
}
