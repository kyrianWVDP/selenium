package locators;

import org.openqa.selenium.By;

public class UserProfileLocators {
    public static final By FIRST_NAME_FIELD = By.id("customer.firstName");
    public static final By LAST_NAME_FIELD = By.id("customer.lastName");
    public static final By ADDRESS_FIELD = By.id("customer.address.street");
    public static final By CITY_FIELD = By.id("customer.address.city");
    public static final By STATE_FIELD = By.id("customer.address.state");
    public static final By ZIP_CODE_FIELD = By.id("customer.address.zipCode");
    public static final By PHONE_FIELD = By.id("customer.phoneNumber");
    public static final By UPDATE_BUTTON = By.cssSelector("input.button[value='Update Profile']");
    public static final By SUCCESS_MESSAGE = By.xpath("//p[contains(text(),'Profile updated successfully')]");
    public static final By ERROR_MESSAGE = By.cssSelector(".error");
}
