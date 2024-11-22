package test;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.UserProfilePage;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserProfileUpdateTest extends tests.BaseTest {

    @Test
    public void testFieldEditability() {
        String username = "user" + System.currentTimeMillis();
        new RegistrationPage(driver).register(
                "John", "Doe", "123 Main St", "Citytown", "Stateland",
                "12345", "5551234567", "123-45-6789", username, "password123"
        );
        new LoginPage(driver).login_user(username);

        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.updatePersonalInformation(
                "Jane", "Smith", "456 Elm St", "Metropolis", "NewState", "54321", "9998887777"
        );

        assertTrue(userProfilePage.isUpdateSuccessful(), "Profile update failed.");
    }
}
