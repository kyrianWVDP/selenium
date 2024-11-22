package test;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.HomePage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends tests.BaseTest {

    @Test
    public void testSuccessfulLogin() {
        driver.get(Config.get("base_url"));
        LoginPage loginPage = new LoginPage(driver);

        String username = "validUser";
        String password = "validPassword";

        loginPage.login_user(username, password);

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLoggedIn(), "Login was not successful.");
    }

    @Test
    public void testInvalidLogin() {
        driver.get(Config.get("base_url"));
        LoginPage loginPage = new LoginPage(driver);

        String username = "invalidUser";
        String password = "invalidPassword";

        loginPage.login_user(username, password);

        assertTrue(loginPage.isErrorDisplayed(), "Error message was not displayed for invalid login.");
    }
}
