package StepDefinition;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import Resources.ApiResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	JsonPath js;
	static String place_id;
	
	@Given("add place payload")
	public void add_place_payload() throws IOException {

		res = given().spec(requestSpecification())
				.body(data.addPlacePayload1());
	}
	
	@Given("add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification())
				.body(data.addPlacePayload2(name, language, address));
	}


	@When("user calls {string} with {string} Http request")
	public void user_calls_with_Http_request(String resource, String httpmethod) {
		ApiResources resourceAPI = ApiResources.valueOf(resource);
		resourceAPI.getResource();
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpmethod.equalsIgnoreCase("POST")) 
			response = res.when().post(resourceAPI.getResource());
		else if (httpmethod.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
	}

	@Then("the API call is success with status code {int}")
	public void the_API_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
		assertEquals(getJsonPath(response, keyValue), ExpectedValue);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_Http_request(resource,"GET");
		String actualName = getJsonPath(response,"name");
		assertEquals(actualName, expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}

}
