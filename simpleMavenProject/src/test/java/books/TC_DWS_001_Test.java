package books;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tyss.genericutility.BaseClass;

public class TC_DWS_001_Test extends BaseClass{
	@Test
	public void booksTest() {
		driver.findElement(By.partialLinkText("BOOKS")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books","Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");
	}
}
