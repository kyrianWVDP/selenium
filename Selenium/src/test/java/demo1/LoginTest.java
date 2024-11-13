package demo1;


import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("myName", "123");

        // Verificar que estamos en la página principal
        assertTrue(driver.getCurrentUrl().contains("app"));
    }
}
