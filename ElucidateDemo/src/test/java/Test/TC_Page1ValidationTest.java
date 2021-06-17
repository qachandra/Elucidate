package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;
import pages.CoursePage1;
import pages.CoursePage2;

/*
 * test validate Start page 
 * content and
 * operations
 * @author :Chan Liyanage
 * Date :17/06/2021
 */
public class TC_Page1ValidationTest {

	private static Logger logger = LogManager.getLogger(TC_Page1ValidationTest.class);
	private static WebDriver driver = null;
	public static String browserName = null;
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static PropertiesFile prop = new PropertiesFile();
		
	@BeforeSuite
	public void setup() {
		
		// Initialise and attach the HtmlReporter
		htmlReporter = new ExtentHtmlReporter("ExtentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}

	@BeforeTest
	public void setUpTest() {
		String projpath = System.getProperty("user.dir");
		prop.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projpath + "/src/main/resources/Drivers/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					projpath + "/src/main/resources/Drivers/Firefoxdriver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver",
					projpath + "/src/main/resources/Drivers/IEdriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		logger.info("infor");
	}

	@Test
	public static void CasePage1() throws IOException, InterruptedException {
		ExtentTest test = extent.createTest("TC_Page1Validation Test ", " Validate Start Page Content and its operation");
		System.out.println("Page 1 Test begin.....");
					
		CoursePage1 cpage1= new CoursePage1(driver);
		driver.get("https://learning.elucidat.com/course/5c9126fd760e5-60ba4c3fe8135");
		test.pass(" Start page started Succesfully..");
		
		// Test Page Title present
		cpage1.getPageTitleText();
		assertEquals("FINDING THE TRUTH", cpage1.getPageTitleText());
		test.pass("Page Title present in Page 1");
		
		//test Search Button present
		assertEquals("START",cpage1.getStartBtntext());
		test.pass("START Button present");

		//click next button
		cpage1.clickStartBtn();
		test.pass("Click START Button ");		
		
		// log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        logger.info("TC_Page1Validation Test");
	}
	
	@AfterTest
	public void tearDowntest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
	@AfterSuite
	public void tearDown() {
		
		extent.flush();		
	}

}
