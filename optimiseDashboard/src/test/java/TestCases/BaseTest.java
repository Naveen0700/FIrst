package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static WebDriver driver;
	public static String projectPath;

	static ExtentSparkReporter reports;
	static ExtentReports extent;
	static ExtentTest test;

	@BeforeClass
	public void setUp() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://optimise-uatcloud.marstongroup.co.uk/UAT/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}

}
