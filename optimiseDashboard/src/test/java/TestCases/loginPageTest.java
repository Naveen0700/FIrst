package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.loginPageObjects;

@Listeners(Listener.TestListener.class)
public class loginPageTest extends BaseTest{

	@Test(priority = 1, groups = "Login Page", description = "Checking the whether the page is loaded or not")
	public void logoTest() {

		loginPageObjects login = new loginPageObjects(driver);
		boolean logo1 = login.logo();
		Assert.assertTrue(logo1);
	}

	@Test(priority = 2, groups = "Login Page",dataProvider = "loginData", dataProviderClass = Utilities.LoginExcelUtils.class, description = "Login test")
	public void loginTest(String agentName, String agentpassWord) throws IOException, InterruptedException{

		loginPageObjects credential = new loginPageObjects(driver);

		// Entering User name and Password
		credential.userName(agentName);
		credential.passWord(agentpassWord);	
		credential.buttonClick();
		Thread.sleep(3000);
		boolean logincheck = driver.findElement(By.xpath("//label[@id='lblUNPWDWarningInfo']")).isDisplayed();
		Assert.assertTrue(logincheck);
	}

}
