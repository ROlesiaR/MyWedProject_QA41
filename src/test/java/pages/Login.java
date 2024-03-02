package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login extends BasePage {
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;
    @FindBy(xpath = "//button[@name = 'registration']")
    WebElement registrationButton;
    public Login (WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);

    }
    public Login fillEmailField (String email) {
        emailField.sendKeys(email);
        return this;
    }
public Login clickRegistrationButton (){
        registrationButton.click();
        return this;

}
    }

