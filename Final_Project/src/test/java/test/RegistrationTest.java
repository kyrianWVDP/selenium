package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends tests.BaseTest {

    @Test
    public void testSuccessfulRegistration() {
        driver.get(Config.get("base_url") + "register.htm");
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Test data
        String firstName = "Emily";
        String lastName = "Doe";
        String address = "123 Main St";
        String city = "Springfield";
        String state = "CA";
        String zipCode = "90210";
        String phone = "555-123-4567";
        String ssn = "123-45-6789";
        String username = "user" + System.currentTimeMillis();
        String password = "password123";

        // Perform registration
        registrationPage.register(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password);

        // Validate successful registration
        assertTrue(registrationPage.isRegistrationSuccessful(), "Registration was not successful.");
    }
}
