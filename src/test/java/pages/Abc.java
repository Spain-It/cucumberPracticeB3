package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Abc {

    public Abc(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//span[@class='oe_topbar_name']")
    public WebElement userName;




}
