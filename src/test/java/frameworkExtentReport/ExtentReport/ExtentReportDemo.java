package frameworkExtentReport.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		//ExtentReports, ExtentSparkReporter
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pranav");
	}
	
	
	@Test
public void initialDemo()
{
		extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pranavsitoke\\Downloads\\Pranav_PersonalDocs\\Selenium_Automation\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();

	driver.get("https://rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	extent.flush();
	
}

}
