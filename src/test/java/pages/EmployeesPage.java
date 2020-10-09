package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.Watchable;

public class EmployeesPage {

    public EmployeesPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Employees")
    public WebElement employees;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement listButton;

    @FindBy(xpath = "//tbody//tr[3]/td[4]")
    public WebElement emailOfDavid;



}
