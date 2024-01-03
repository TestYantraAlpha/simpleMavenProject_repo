package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SimpleTest {
	@Test
	public void test() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.aceturtle.com/");
		Reporter.log("SimpleTest class executed...",true);
	}
}
