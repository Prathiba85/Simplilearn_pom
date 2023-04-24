package testcases;

import java.lang.reflect.Method;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	public Fillo fillo;
	
	Connection connection;

	@BeforeSuite
	public void ReportSetup() throws FilloException
	{
		report = new ExtentReports("ExtentReport.html");
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
	}
	
	
	@BeforeMethod
	public void SetUp(Method method) {	
		
		WebDriverManager.chromedriver().setup();
		
		//this is added to get name of the test case in xml.
		
		test=report.startTest(method.getName());
		test.log(LogStatus.INFO,"Test should be started ","test case started successfully");
		this.driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void TearDown() {
		report.endTest(test);
		driver.quit();
		
	}
	
	@AfterSuite
	public void ReportClean()
	{
		report.flush();
		report.close();
	}

}
