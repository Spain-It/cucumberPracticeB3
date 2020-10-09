package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStefDef {

    @Given("the user goes to link")
    public void the_user_goes_to_link() {
        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
    }

    @Given("the user logs in {string} {string}")
    public void the_user_logs_in(String email, String password) throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.getLogin(email,password);

    }


}
