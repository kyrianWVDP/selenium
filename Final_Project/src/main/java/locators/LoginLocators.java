package locators;

import org.openqa.selenium.By;

public class LoginLocators {
    public static final By USERNAME_FIELD = By.name("username");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.cssSelector("input.button[value='Log In']");
    public static final By ERROR_MESSAGE = By.cssSelector(".error");
}
