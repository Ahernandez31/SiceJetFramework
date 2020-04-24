package com.regression;



import org.testng.annotations.Test;
import com.util.BaseTest;
import com.vo.FlightDescription;

public class Flight_Test_Singleton extends BaseTest{
  @Test
  public void f() {
	  
	  
	  
	  FlightDescription data = testData.get(this.getClass().getSimpleName());
	  
	  System.out.println(data.toString());
	  
	  
  }
}
