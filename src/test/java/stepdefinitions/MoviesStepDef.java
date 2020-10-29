package stepdefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class MoviesStepDef {

    static Response response;

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


    @Given("the user sends get request with {string} end point {int}")
    public void the_user_sends_get_request_with_end_point(String endPoint, int id) {
      response = given().accept(ContentType.JSON).pathParam("id",id).when().
                  get(endPoint+"/{id}");
    }

    @Then("Verify the response body is equal which is you posted")
    public void verify_the_response_body_is_equal_which_is_you_posted() {

        Map<String,Object> data = new HashMap<>();
        data.put("id", 1459);
        data.put("title","Salamanca");
        data.put("year",1997);
        data.put("plot","MrtFth");
        data.put("duration",123);
        data.put("audio_qualities","");
        data.put("video_qualities","");
        data.put("genres","");

//        JsonPath json= response.jsonPath();
//
//        Assert.assertEquals(data.get("id"),json.getInt("id"));
//        Assert.assertEquals(data.get("plot"),json.getString("plot"));

        System.out.println(response.path("id").toString());
        System.out.println(response.path("title").toString());

        Assert.assertEquals(data.get("year"),response.path("year"));

    }

    @Given("the user sends put request with {string} end point")
    public void the_user_sends_put_request_with_end_point(String endPoint, Map<String,Object> data) {

        response = given().accept(ContentType.JSON).when().body(data).put(endPoint+"/1459");

        response = given().get("/movies/1459");
        response.prettyPrint();

    }



    @Then("Verify the response body is updated")
    public void verify_the_response_body_is_updated() {

        Map<String,Object> data = new HashMap<>();
        data.put("id", 1459);
        data.put("title","Dallas");
        data.put("year",2012);
        data.put("plot","Vlkn");
        data.put("duration",1111);
        data.put("audio_qualities","");
        data.put("video_qualities","");
        data.put("genres","");

        response=given().get("/movies/1459");

        Assert.assertEquals(data.get("title"),response.path("title"));

    }

}
