package Tests.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.BasePage;

public class LoginTests2 extends BasePage {
	
	@Test
	public void Test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void Test2() {
		System.out.println("Test 2");
		Assert.assertTrue(false);
	}

	@Test
	public void Test3() {
		System.out.println("Test 3");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Test4() {
		System.out.println("Test 4");
		Assert.assertTrue(true);
	}
}
