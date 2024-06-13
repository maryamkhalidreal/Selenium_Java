package Appium.winappdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class TestingWithWinApp {

	@Test
	public void Test1() throws MalformedURLException {
		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("app", "C:\\Windows\\System32\\calc.exe");
		caps.setCapability("platformName","Windows");
        caps.setCapability("deviceName","WindowsPC");
		
		@SuppressWarnings("deprecation")
		WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"),caps);
		
		driver.findElement(By.id("num1Button")).click();
		
		
	}
}
