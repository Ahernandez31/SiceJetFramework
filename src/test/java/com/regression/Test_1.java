package com.regression;


import org.testng.annotations.Test;
import com.util.BaseTest;

public class Test_1 extends BaseTest {



	@Test
	public void f() {
		System.out.println("This is the test case");
		driver.get("https://www.google.com");
	}



}
