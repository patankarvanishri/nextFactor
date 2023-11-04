package stepDefinitions;

import org.testng.Assert;

import com.sdet.labs.Restful_Web_Services;
import com.sdet.labs.Soap_Web_Services;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
	
	static Integer StatusCode;

	@Given("Json Place Holder site")
	public void json_place_holder_site() {
		Restful_Web_Services.setup();
	}

	@When("Rest Assured Request is {string}")
	public void rest_assured_request_is(String RequestType) {

		if (RequestType.equals("Get"))
			StatusCode = Restful_Web_Services.GetRequestStatusCode();
		else if (RequestType.equals("Put"))
			StatusCode = Restful_Web_Services.PutRequestStatusCode();
		else if (RequestType.equals("Post"))
			StatusCode = Restful_Web_Services.PostRequestStatusCode();
		else if (RequestType.equals("Patch"))
			StatusCode = Restful_Web_Services.PatchRequestStatusCode();
		else if (RequestType.equals("Delete"))
			StatusCode = Restful_Web_Services.DeleteRequestStatusCode();
	}

	@Given("Calculator site")
	public void calculator_site() {
	}

	@When("Soap Request is {string}")
	public void soap_request_is(String RequestType) {
		if (RequestType.equals("Get"))
			StatusCode = Soap_Web_Services.GetRequestStatusCode();
		else if (RequestType.equals("Post"))
			StatusCode = Soap_Web_Services.PostRequestStatusCode();
	}

	@Then("the status code should be {int}")
	public void the_status_code_should_be(Integer code) {
		Assert.assertEquals(StatusCode, code);
	}

}
