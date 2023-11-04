package com.sdet.labs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Soap_Web_Services_Test {
	
	@Test
	  public void GetRequestTest() {
		  Assert.assertEquals(Soap_Web_Services.GetRequestStatusCode(),200);
	  }

	  @Test
	  public void PostRequestTest() {
		  Assert.assertEquals(Soap_Web_Services.PostRequestStatusCode(),500);
	  }

}
