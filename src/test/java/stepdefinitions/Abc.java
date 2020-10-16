package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Abc {

    @Given("user logs")
    public void user_logs() {
        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
    }


    @Then("do it")
    public void doIt() {

        for (int i=0; i<3;i++){
            System.out.println(i);
        }

    }

    @When("the gets list")
    public void the_gets_list(List<String> dataTable) {

        for (String city : dataTable) {
            System.out.println(city);
        }

    }

}
