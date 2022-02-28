package optimiseDashboardTest;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class agentLogin {

	WebDriver driver;


	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://optimise-uatcloud.marstongroup.co.uk/UAT/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@Test(priority = 1, groups = "Login Page", description = "Checking the whether the page is loaded or not.")
	public void loginPage() {
		boolean logo = driver.findElement(By.className("img-responsive")).isDisplayed();
		Assert.assertTrue(logo);

	}



	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
