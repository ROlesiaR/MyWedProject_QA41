package tests;

import com.beust.jcommander.Parameter;
import config.BaseTest;
import helpers.*;
import io.qameta.allure.Allure;
import model.Contact;
import org.openqa.selenium.Alert;
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
            public void AddContact(@Optional("chrome")String browser) throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        loginPage.fillEmailField("myemail6@mail.com").fillPasswordField("1234Test#").clickLoginButton();
        AddPage addPage = mainPage.openTopMenu(TopMenuItem.ADD.toString());
        Contact contact1 = new Contact();
        contact1.setName(NameAndLastNameGenerator.genetareName());
        contact1.setLastName(NameAndLastNameGenerator.genetareLastName());
        contact1.setPhone(PhoneNumberGeberator.generatePhoneNumber());
        contact1.setEmail(EmailGenerator.generateEmail(8,5,3));
        contact1.setAddress(AddressGenerator.generateAddress());
        contact1.setDescription("");

        addPage.fillFormAndSave(contact1);
       // System.out.println(contact1);
        Assert.assertTrue(ContactsPage.getDataFromContactList(contact1));
    }



}
