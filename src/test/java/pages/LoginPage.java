package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
   /*
    1.Go to https://twiliaerp.com/
    2. Write a useful method which is named login and create a class
    under the pages
    3. username=eventscrmmanager22@info.com
    4. password=eventscrmmanager
   */
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Login")
    public WebElement login;

    @FindBy(id = "login")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


   public void getLogin(String email, String password) throws InterruptedException {

       login.click();
       Thread.sleep(2000);
       emailBox.sendKeys(email);
       passwordBox.sendKeys(password);
       loginButton.click();

   }


}
