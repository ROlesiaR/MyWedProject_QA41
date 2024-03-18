package tests;

import com.beust.jcommander.Parameter;
import config.BaseTest;
import helpers.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import model.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactsPage;
import pages.LoginPage;
import pages.MainPage;

public class PhoneBookTest extends BaseTest {
@Test(description = "The test checks the empty field warning declaration.")

@Parameters("browser")
    public void registrationWithoutPassword(@Optional("chrome") String browser) throws InterruptedException {
    Allure.description("User always exist. Login and add contact");
        MainPage mainPage = new MainPage(getDriver());
        Allure.step("Click by LoginButton");
        LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        Allure.step("Click by RegButton ");
        String expectedString = "Wrong";

        Alert alert =   loginPage.fillEmailField("myemail4@mail.com").clickRegistrationButton();
    boolean isAlertHandled = AlertHandler.handleAlert(alert,expectedString);
    Assert.assertTrue(isAlertHandled);
    }
    @Test
    @Description("Succesful Registration")
    public void succesfulRegistration(){
    Allure.description("Succesful registration test.");
    MainPage mainPage = new MainPage(getDriver());
    Allure.step("Step 1: Open Login page");
    LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
    loginPage.fillEmailField(EmailGenerator.generateEmail(5,5,3))
            .fillPasswordField(PasswordStringGenerator.generateString());
    Alert alert = loginPage.clickRegistrationButton();
    if (alert==null){
        ContactsPage contactsPage = new ContactsPage(getDriver());
        Assert.assertTrue(contactsPage.isElementPersist(getDriver()
                .findElement(By.xpath("//button[normalize-space()='Sign Out']"))));
    }else {
        TakeScreen.takeScreenshot("Succesful Registartion");
    }
    }
@Test
@Description("User already exist. Login and add contact.")
public void loginOfAnExistingUserAddContact() throws InterruptedException {
    Allure.description("User already exist. Login and add contact.!");
    MainPage mainPage = new MainPage(getDriver());
    Allure.step("Step 1");
    LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
    Allure.step("Step 2");
  loginPage.fillEmailField(PropertiesReader.getProperty("existingUserEmail"))
            .fillPasswordField(PropertiesReader.getProperty("existingUserPassword"))
            .clickLoginButton();
    Allure.step("Step 3");
//    MainPage.openTopMenu(TopMenuItem.ADD.toString());
//    AddPage addPage = new AddPage(getDriver());
    AddPage addPage = mainPage.openTopMenu(TopMenuItem.ADD.toString());
    Contact newContact = new Contact(NameAndLastNameGenerator.generaterName(),
            NameAndLastNameGenerator.generateLastName(),
            PhoneNumberGenerator.generatePhoneNumber(),
            EmailGenerator.generateEmail(10,5,3),
            AddressGenerator.generateAddress(),
            "new description");
    newContact.toString();
    addPage.fillFormAndSave(newContact);
    ContactsPage contactsPage = new ContactsPage(getDriver());
    Assert.assertTrue(contactsPage.getDataFromContactList(newContact));
    TakeScreen.takeScreenshot("screen");
    Thread.sleep(3000);
}


}
