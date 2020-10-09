package stepdefinitions;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.EmployeesPage;

public class EmployeesStepDef {

    EmployeesPage employeesPage = new EmployeesPage();

    @Given("Navigate to Employees page")
    public void navigate_to_employees_page() throws InterruptedException {

        Thread.sleep(2000);

        employeesPage.employees.click();

    }

    @Given("Click the list button")
    public void click_the_list_button() {

        employeesPage.listButton.click();

    }

    @Then("Print the email of David Samson")
    public void print_the_email_of_david_samson() {
        System.out.println(employeesPage.emailOfDavid.getText());
    }




}
