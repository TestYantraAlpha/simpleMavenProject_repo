package extentreports;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToAddScreenShotInExtentReport {
	@Test
	public void screenshot() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		String screen = ts.getScreenshotAs(OutputType.BASE64);
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		// step 1: create an instance for ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReports_"+time+".html");
		
		// step 2: create an instance for ExtentReports
		ExtentReports reports=new ExtentReports();
		
		// step 3: attach spark reporter to ExtentReports
		reports.attachReporter(spark);
		
		// step 4: create instance of ExtentTest
		ExtentTest test = reports.createTest("screenshot");
		
		// step 5: call log methods
		test.log(Status.INFO, "adding screenshot");
		test.addScreenCaptureFromBase64String(screen,"error image");
		
		// step 6: call flush()
		reports.flush();
		
	}
}
