package com.util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.data.Constants;
import com.data.FlightDescriptionSingleton;
import com.data.PropertyLoader;
import com.vo.FlightDescription;

public class BaseTest {
	
	public WebDriver driver;
	public HashMap<String, FlightDescription> testData= FlightDescriptionSingleton.getFlightDescriptionSingleton();
	
	public BaseTest() {
		
		//Siempre debe de llevar ese nombre para que TestNG lo identifique

		switch (getDefaultBrowser()) {
		case "Chrome":
			System.setProperty("webDriver.chrome.driver", PropertyLoader.getProperty(Constants.CHROME_V81));
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", PropertyLoader.getProperty(Constants.FIREFOX));
			driver= new FirefoxDriver();
			break;
		default:
			break;
		}
		 
	}
	
	
	private String getDefaultBrowser() {
		return PropertyLoader.getProperty(Constants.DEFAULT_BROWSER);
	}
	
	//Before annotations
	@BeforeClass
	public void beforeClass() {
		System.out.println("This method is running before class");
	}

	@BeforeGroups
	public void beforeGroups() {
		System.out.println("This method is running before groups");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This method is running before suite");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This method is running before method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("This method is running before Test");
	}
	//AfterAnnotations
	@AfterClass
	public void afterClass() {
		System.out.println("This method is running after class");
	}

	@AfterGroups
	public void afterGroups() {
		System.out.println("This method is running after groups");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This method is running after suite");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This method is running after method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This method is running after Test");
	}
}
