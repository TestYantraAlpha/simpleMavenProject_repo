package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
	@Test
	public void report() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		// step 1: create an instance for ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReports_"+time+".html");
		
		//step 2: create an instance for ExtentReports
		ExtentReports reports=new ExtentReports();
		
		// step 3: attach ExtentSparkReporter to ExtentReports
		reports.attachReporter(spark);
		
		// step 4: create an instance for ExtentTest
		ExtentTest test = reports.createTest("report");
		
		// step 5: call log methods to write messages in Extent report
		test.log(Status.INFO, "added log message in report");
		test.log(Status.INFO, "open browser");
		test.log(Status.PASS, "Navigated to url");
		test.log(Status.PASS, "User logged in successfully");
		
		// step 6: write all log messages into destination(call flush method)
		reports.flush();		
	}
}
