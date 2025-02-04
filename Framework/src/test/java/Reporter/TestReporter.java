package Reporter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utils.BasePage;

public class TestReporter extends BasePage implements ISuiteListener, ITestListener{

	@Override
	public void onStart(ISuite suite) {
		//Create an html report for the suite that is executed
		reportConfig= new ExtentSparkReporter("Reports/"+suite.getName().toString()+".html"); 
		reporter = new ExtentReports();
		reporter.attachReporter(reportConfig);
		
		reportConfig.config().setTimelineEnabled(false);
		reportConfig.config().setTheme(Theme.DARK);
		reportConfig.config().setDocumentTitle("Test Report");
		reportConfig.config().setReportName("Automation Report");
		reportConfig.config().setTimeStampFormat("dd-MM-YY ss:mm:hh");
		
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("Host Name", "Local");
		reporter.setSystemInfo("Environment", "QA");
		reporter.setSystemInfo("User Name", System.getProperty("user.name"));
}

	@Override
	public void onFinish(ISuite suite) {
		reporter.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger = reporter.createTest(result.getMethod().getMethodName());
		logger.log(Status.INFO, "Executing test: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.INFO, "Finished executing test");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		WebDriver driver = (WebDriver)result.getTestContext().getAttribute("WebDriver"); //use string from setAttribute from BasePage
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/" + fileName);
		try {
			
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot taken, saved in screenshots folder");
		} catch(IOException e) {
			System.out.println("Failed to take screenshot");
		}
		logger.log(Status.FAIL, "Test failed, attaching screenshot in screenshots folder");
		logger.addScreenCaptureFromPath(destFile.getAbsolutePath());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "Test skipped");
	}


}
