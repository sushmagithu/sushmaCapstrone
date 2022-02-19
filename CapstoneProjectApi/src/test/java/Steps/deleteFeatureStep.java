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


public class deleteFeatureStep {
@Given("I have valid access token and valid URL for Delete")
public void i_have_valid_access_token_and_valid_URL_for_Delete() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}
@Then("I should receive status code as {int} for Delete")
public void i_should_receive_status_code_as_for_Delete(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    try{
			Response resp=given().
					when()
					.delete("https://reqres.in/api/users/2");
			 int statusCode=resp.getStatusCode();
			assertEquals(statusCode,204);
			System.out.println(resp.getStatusCode());
			System.out.println(resp.asString());
			//int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode /*actual value*/, 204 /*expected value*/);
			
		}
		catch(Exception e){
			e.printStackTrace();
}
}
@Then("Delete {string} for the value of {string}")
public void delete_for_the_value_of(String string, String string2) throws FileNotFoundException {
    // Write code here that turns the phrase above into concrete actions
  File f=new File("../CapstoneProjectApi/Existing1.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new  JSONTokener(fr);
		JSONObject jo=new JSONObject(jt);
		
		Response resp=
				
				given()
				.contentType(ContentType.JSON)
				.when().delete("https://reqres.in/api/users/2");
		System.out.println("delete Response body is:Successfull");
		System.out.println("the status response code is :"+resp.getStatusCode());

}

}

