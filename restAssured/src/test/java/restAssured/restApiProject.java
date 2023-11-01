package restAssured;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class restApiProject {

	private static Response response;
	private static String URL = "https://www.bing.com/";

	private static String apiToTest;
	private static String pathParam = "search";
	private static String querySeperator = "?";
	private static String queryParam = "q=sandhan+valley+trek";

	@BeforeClass

	public static void launch_Url() {

		apiToTest = URL + pathParam + querySeperator + queryParam;
		response = get(apiToTest);

	}

	
	@Test

	public void testAResponseStatusCode() {
		System.out.println(this.apiToTest);
		//response = get(this.apiToTest);
		assertEquals(200, response.getStatusCode());

	}

	@Test
	public void getResponse() {
		//response = get(this.apiToTest);
		String response1 = response.getBody().asString();
		System.out.println(response1);
	}

	@Test
	public void getHeaders() {
		
		Headers headers = response.getHeaders();
		for (Header header : headers) {
			System.out.println(header);
		}
		
		assertEquals("text/html; charset=utf-8", response.getHeader("Content-Type"));

	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Thank You");
	}
}