package Listener;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentManager;
import ExtentReport.ExtentTestManager;
import TestCases.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
	
private static ExtentReports extent = ExtentManager.getInstance();
	
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed.");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		
		try{
			projectPath = System.getProperty("user.dir");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(projectPath + "/screenshots/" + result.getMethod().getMethodName() + ".png"));
			System.out.println("Screenshot taken successfully");
		}
		catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
		ExtentTestManager.getTest().addScreenCaptureFromPath(projectPath + "/screenshots/" + result.getMethod().getMethodName() + ".png");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed : " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped : " + result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
