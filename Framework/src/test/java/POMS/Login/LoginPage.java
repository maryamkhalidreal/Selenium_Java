package POMS.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

	By username=By.id("user-name");
	By password=By.id("password");
	By loginBtn=By.id("login-button");
	
	public LoginPage(WebDriver driver) {	
		this.driver=driver;
	}
	
	public void enterUserName(String name) {
		driver.findElement(username).sendKeys(name);
		
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		
	}
	public void clickLoginButton() {
		driver.findElement(loginBtn).click();	
	}

}
