package pages;

import locators.RegistrationLocators;
import org.openqa.selenium.WebDriver;
import static utils.utils.wait_for_element;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String firstName, String lastName, String address, String city, String state,
                         String zipCode, String phone, String ssn, String username, String password) {
        wait_for_element(driver, RegistrationLocators.FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(RegistrationLocators.LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(RegistrationLocators.ADDRESS_FIELD).sendKeys(address);
        driver.findElement(RegistrationLocators.CITY_FIELD).sendKeys(city);
        driver.findElement(RegistrationLocators.STATE_FIELD).sendKeys(state);
        driver.findElement(RegistrationLocators.ZIP_CODE_FIELD).sendKeys(zipCode);
        driver.findElement(RegistrationLocators.PHONE_FIELD).sendKeys(phone);
        driver.findElement(RegistrationLocators.SSN_FIELD).sendKeys(ssn);
        driver.findElement(RegistrationLocators.USERNAME_FIELD).sendKeys(username);
        driver.findElement(RegistrationLocators.PASSWORD_FIELD).sendKeys(password);
        driver.findElement(RegistrationLocators.CONFIRM_PASSWORD_FIELD).sendKeys(password);
        driver.findElement(RegistrationLocators.REGISTER_BUTTON).click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.findElement(RegistrationLocators.SUCCESS_MESSAGE).isDisplayed();
    }
}
