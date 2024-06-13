package Tests.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import POMS.Login.LoginPage;
import Utils.BasePage;

public class SauceDemoTests extends BasePage{
	@Test
	public void loginTest() {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
		Assert.assertEquals(driver.getTitle().toString(), "Swag Labs","Test Failed123");

	}
	

}
