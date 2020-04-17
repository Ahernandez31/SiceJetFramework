package com.dummy;

import com.data.Constants;
import com.data.PropertyLoader;

public class MainTest {
	public static void main(String[] array) {
		System.out.println(PropertyLoader.getProperty(Constants.BROWSER));
		System.out.println(PropertyLoader.getProperty(Constants.ENVIRONMENT));
		
		
	}
}
