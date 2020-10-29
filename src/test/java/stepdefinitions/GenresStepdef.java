package stepdefinitions;

import io.cucumber.java.en.Given;
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



    @Given("the user sends request {string} with end point")

    public void the_user_sends_request_with_end_point(String endPoint) {

        Map<String,String> genresData = new HashMap<>();
        genresData.put("name","Science Fiction3");

         movies.response = RestAssured.given().contentType(ContentType.JSON).when().
                body(genresData).post(endPoint);

        JsonPath jsp =movies.response.jsonPath();

        movies.response.prettyPrint();

        System.out.println(jsp.getString("name"));

    }

}
