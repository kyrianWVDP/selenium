package pages;

import locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import static utils.utils.wait_for_element;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login_user(String username, String password) {
        wait_for_element(driver, LoginLocators.USERNAME_FIELD).sendKeys(username);
        driver.findElement(LoginLocators.PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LoginLocators.LOGIN_BUTTON).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(LoginLocators.ERROR_MESSAGE).isDisplayed();
    }
}
