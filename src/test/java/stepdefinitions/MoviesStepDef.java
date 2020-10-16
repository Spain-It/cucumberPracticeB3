package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class MoviesStepDef {

    Response response;

    @Given("the user set uri")
    public void the_user_set_uri() {
        baseURI = ConfigReader.getProperty("rakuten_uri");
    }


    @Given("the user sends post request with {string} end point")
    public void the_user_sends_post_request_with_end_point(String endPoint, Map<String,Object> data2) {

        Map<String,Object> data = new HashMap<>();
         data.put("title","Stranger");
         data.put("year",1998);
         data.put("plot","MrtFth");
         data.put("duration",123);
         data.put("audio_qualities","");
         data.put("video_qualities","");
         data.put("genres","");

         response = given().contentType(ContentType.JSON).when().body(data2).post(endPoint);

    }


    @When("Verify the status code is {int}")
    public void verify_the_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }



    @When("Verify the content type is {string}")
    public void verify_the_content_type_is(String contentType) {

        Assert.assertEquals(contentType,response.contentType());

    }


    @Then("print the response body")
    public void print_the_response_body() {
       response.prettyPrint();
    }


}
