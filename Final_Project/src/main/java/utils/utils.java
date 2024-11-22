package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils {

    public static void wait_for_page_load(WebDriver driver, int timeout) {
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
    }

    public static WebElement wait_for_element(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
