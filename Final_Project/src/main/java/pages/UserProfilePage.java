package pages;

import locators.UserProfileLocators;
import org.openqa.selenium.WebDriver;
import static utils.utils.wait_for_element;

public class UserProfilePage {
    private WebDriver driver;

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void updatePersonalInformation(String firstName, String lastName, String address, String city,
                                          String state, String zipCode, String phone) {
        wait_for_element(driver, UserProfileLocators.FIRST_NAME_FIELD).clear();
        driver.findElement(UserProfileLocators.FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(UserProfileLocators.LAST_NAME_FIELD).clear();
        driver.findElement(UserProfileLocators.LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(UserProfileLocators.ADDRESS_FIELD).clear();
        driver.findElement(UserProfileLocators.ADDRESS_FIELD).sendKeys(address);
        driver.findElement(UserProfileLocators.CITY_FIELD).clear();
        driver.findElement(UserProfileLocators.CITY_FIELD).sendKeys(city);
        driver.findElement(UserProfileLocators.STATE_FIELD).clear();
        driver.findElement(UserProfileLocators.STATE_FIELD).sendKeys(state);
        driver.findElement(UserProfileLocators.ZIP_CODE_FIELD).clear();
        driver.findElement(UserProfileLocators.ZIP_CODE_FIELD).sendKeys(zipCode);
        driver.findElement(UserProfileLocators.PHONE_FIELD).clear();
        driver.findElement(UserProfileLocators.PHONE_FIELD).sendKeys(phone);
        driver.findElement(UserProfileLocators.UPDATE_BUTTON).click();
    }

    public boolean isUpdateSuccessful() {
        return driver.findElement(UserProfileLocators.SUCCESS_MESSAGE).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(UserProfileLocators.ERROR_MESSAGE).isDisplayed();
    }
}
