package tests;

import com.beust.jcommander.Parameter;
import config.BaseTest;
import helpers.TopMenuItem;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class PhoneBookTest extends BaseTest {
@Test(description = "The test checks the empty field warning declaration.")

@Parameters("browser")
    public void phoneBookTest_001(String browser) throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        loginPage.fillEmailField("myemail3@mail.com").fillPasswordField("12345Test#").clickRegistrationButton();
        Thread.sleep(5000);
    }
}
