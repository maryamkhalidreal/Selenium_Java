package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasePage {
	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentSparkReporter reportConfig;
	public static ExtentReports reporter; // extent = new ExtentReports();
	public static String url;

	@BeforeTest (alwaysRun = true)
	public void setup(ITestContext context) {
		ConfigReader config= new ConfigReader();
		DriverSetup DriverSetup = new DriverSetup();
		driver = DriverSetup.getDriver(config.getPropertyByName("browser"));
		driver.manage().window().maximize();		
		driver.get(config.getPropertyByName("url"));
		context.setAttribute("WebDriver", driver);
		

	}
	
	

	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	
	/*
	 * @BeforeClass(alwaysRun=true) public void setup(ITestContext context) {
	 * ConfigReader config= new ConfigReader(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.get(config.getPropertyByName("url"));
	 * context.setAttribute("WebDriver", driver); }
	 */

	/*
	 * @AfterClass(alwaysRun=true) public void tearDown() { driver.quit(); }
	 */
 
}
