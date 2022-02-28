package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {

		String workingDir = System.getProperty("user.dir");
		ExtentSparkReporter spark = new ExtentSparkReporter(workingDir+"/reports/report.html");

		extent = new ExtentReports();

		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);

		return extent;
	}
	public static ExtentReports getInstance() {
		if(extent == null) {
			createInstance();
		}
		return extent;
	}
}
