package tests;

import com.beust.jcommander.Parameter;
import config.BaseTest;
import helpers.TopMenuItem;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainPage;

public class PhoneBookTest extends BaseTest {
@Test(description = "The test checks the empty field warning declaration.")

@Parameters("browser")
    public void phoneBookTest_001(String browser) throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        Login loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        loginPage.fillEmailField("myemail2@mail.com").clickRegistrationButton();
        Thread.sleep(5000);

    }
}
