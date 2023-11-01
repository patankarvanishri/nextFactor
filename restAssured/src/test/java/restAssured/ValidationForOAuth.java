package restAssured;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidationForOAuth {

	
		// TODO Auto-generated method stub
		private Response response;
		private String restApi = "https://bookcart.azurewebsites.net/api/Book"; // base URL
		private RequestSpecification httprequest = null;
		
		@Before
		public void setup() {
		RestAssured.baseURI = this.restApi;
		this.httprequest = RestAssured.given();
		}

		@Test
		public void getApiResponse() {
			
		this.response= this.httprequest.accept(ContentType.JSON).auth().oauth2("test123")
				.when().get("/41").then().extract().response();
		assertEquals(200, this.response.statusCode());
		

	}

	}
