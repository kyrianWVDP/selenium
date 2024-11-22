package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        return getCurrentUrl().contains("overview.htm");
    }
}
