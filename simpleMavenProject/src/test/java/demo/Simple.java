package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Simple {
	@Test
	public void test() {
		Reporter.log("Simple class executed...",true);
	}
}
