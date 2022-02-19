package Steps;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class putFeatureSteps {
	@Given("I have valid access token and valid URL for Put")
	public void i_have_valid_access_token_and_valid_URL_for_Put1() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("I should receive status code as {int} for Put")
	public void i_should_receive_status_code_as_for_Put1(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		try {
			Response resp = given().when().put("https://reqres.in/api/users/2");
			int statusCode = resp.getStatusCode();
			assertEquals(statusCode, 200);
			System.out.println(resp.getStatusCode());
			System.out.println(resp.asString());
			// int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Then("update {string} for the value of {string}")
	public void update_for_the_value_of1(String string, String string2) throws FileNotFoundException {
		// Write code here that turns the phrase above into concrete actions
		File f = new File("..//CapstoneProjectApi/Existing3.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);

		Response resp =

				given().contentType(ContentType.JSON).body(jo.toString()).when()
						.put("https://reqres.in/api/users?id=10");
		System.out.println("putResponse body is:" + resp.asString());
		System.out.println("the status response code is :" + resp.getStatusCode());
	}
}