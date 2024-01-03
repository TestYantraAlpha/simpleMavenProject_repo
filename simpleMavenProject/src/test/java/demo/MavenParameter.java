package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameter {
	@Test
	public void recieveData() {
		Reporter.log("MavenParameter class executed...",true);
		String URL = System.getProperty("url");
		Reporter.log(URL,true);
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		String EMAIL = System.getProperty("email");
		String PASSWORD = System.getProperty("password");
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);		
	}
}
