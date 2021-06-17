package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
 * test case not complete and working yet
 */

public class TC_Page2ValidationTest {

	private static Logger logger = LogManager.getLogger(TC_Page2ValidationTest.class);
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
		ExtentTest test = extent.createTest(":", "To Validate Page 2 Requirement");

		/*System.out.println("Page 2 Test begin.....");
		CoursePage1 cpage1 = new CoursePage1(driver);
		CoursePage2 cpage2 = new CoursePage2(driver);

		driver.get("https://learning.elucidat.com/course/5c9126fd760e5-60ba4c3fe8135");
		test.pass("Open course page 1");

		// click next button
		cpage1.clickStartBtn();
		test.pass("Click START Button ");

		// Test Page Title present in Page 2
		assertEquals("FINDING THE TRUTH", cpage2.getp2HeaderText());
		test.pass("Page Title present in Page 2");
		/*
		//Page 2 Image 1 present
		assertEquals("image-1",cpage2.p2Image1Txt());
		test.pass("Page 2 Image 1 present");

		// log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
      logger.info("TC_Page2Validation Test");*/
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
