package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.Driver;

public class Abc {

    @Given("user logs")
    public void user_logs() {
        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
    }
}
