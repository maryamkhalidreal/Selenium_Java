package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {	
	private WebDriver driver;
	public WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Edge")){
			driver = new EdgeDriver();
			}
			else{
				System.out.println("Invalid browser");
				System.out.println("Launching default FireFox browser.");
				driver = new FirefoxDriver();
			}
		return driver;
	}
	
}
