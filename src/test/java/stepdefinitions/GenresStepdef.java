package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenresStepdef {

    MoviesStepDef movies = new MoviesStepDef();



    @Given("the user sends post request {string} with end point")

    public void the_user_sends_request_with_end_point(String endPoint) {

        Map<String,String> genresData = new HashMap<>();
        genresData.put("name","Science Fiction1");

         movies.response = RestAssured.given().contentType(ContentType.JSON).when().
                body(genresData).post(endPoint);

        JsonPath jsp =movies.response.jsonPath();

        movies.response.prettyPrint();

        System.out.println(jsp.getString("name"));
        System.out.println(jsp.getString("id"));

    }

    @Given("the user sends get request with {string} endpoint")
    public void the_user_sends_get_request_with_endpoint(String endPoint) {
      movies.response = RestAssured.given().accept(ContentType.JSON).get(endPoint);

      movies.response.prettyPrint();
    }

    @And("the user sends get request with {string} endpoint and {int} qyery")
    public void theUserSendsGetRequestWithEndpointAndQyery(String endPoint, int idNum) {

        movies.response = RestAssured.given().accept(ContentType.JSON).pathParam("id",idNum).when().
                          get(endPoint+"/{id}");

        movies.response.prettyPrint();
    }

    @When("the user sends put request with {string} endpoint")
    public void the_user_sends_put_request_with_endpoint(String endPoint) {

        Map<String,String> genresData = new HashMap<>();
        genresData.put("name","Science Fiction10");

        movies.response = RestAssured.given().accept(ContentType.JSON).when().
                          body(genresData).put(endPoint+"/737");

        movies.response.prettyPrint();



    }

    @When("the user sends delete request with {string} endpoint {int} pathParam")
    public void theUserSendsDeleteRequestWithEndpointPathParam(String endPoint, int idNum) {

        movies.response = RestAssured.given().pathParam("id",idNum).
                         delete(endPoint+"/{id}");

    }
}
