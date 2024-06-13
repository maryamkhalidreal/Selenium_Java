package POMS.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingPageFactory {
	
	WebDriver driver;

	@FindBy(how=How.ID, using= "user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	

	@FindBy(id="login-button")
	WebElement loginBtn;

	
	public LoginPageUsingPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	public void enterUserName(String name) {
		username.sendKeys(name);
		
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
		
	}
	public void clickLoginButton() {
		
		loginBtn.click();	
	}

}
