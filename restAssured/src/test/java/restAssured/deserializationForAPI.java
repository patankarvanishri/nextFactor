package restAssured;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.deserailization;


public class deserializationForAPI {

private Response response;
private String restApi = "https://jsonplaceholder.typicode.com/"; // base URL
private RequestSpecification httprequest = null;
deserailization respBdyCmmts= new deserailization();

@Before
public void setup() {
RestAssured.baseURI = this.restApi;
this.httprequest = RestAssured.given();
}

@Test
public void getApiResponse() {
	
this.response=this.httprequest.header("Content-type", "application/json").and().when()

.get("/comments/1").then().extract().response();

	//this.response = this.httprequest.request(Method.GET, "/comments/1");

System.out.println(this.response.getBody().prettyPrint());


this.respBdyCmmts = this.response.getBody().as(deserailization.class);
assertEquals(1, respBdyCmmts.getId());
assertEquals("Eliseo@gardner.biz",respBdyCmmts.getEmailID());
	
}

}

