package com.tyss.genericutility;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static ExtentReports reports;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void reportConfig() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		// step 1: create an instance for ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReports_"+time+".html");	
		//step 2: create an instance for ExtentReports
		reports=new ExtentReports();	
		// step 3: attach ExtentSparkReporter to ExtentReports
		reports.attachReporter(spark);
	}
	@BeforeClass 
	public void browserSetup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
	}
	@BeforeMethod
	public void login(Method method) {
		test=reports.createTest(method.getName());
		
		driver.findElement(By.linkText("Log in")).click();	
		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		reports.flush();
	}
}
