package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutomationExample {
    public static void main(String[] args) {
        // Set up WebDriver (make sure the path to your chromedriver is correct)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kyrian\\Desktop\\chrome-win32\\chromedriver-win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the demo site
            driver.get("https://demo.applitools.com/");

            // Login (any username/password works)
            driver.findElement(By.id("username")).sendKeys("myName");
            driver.findElement(By.id("password")).sendKeys("123");
            driver.findElement(By.id("log-in")).click();

            // Wait for the balance elements to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Extract and print Total Balance
            WebElement totalBalanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".balance-value")));
            String totalBalance = totalBalanceElement.getText().replaceAll("[^0-9$]", ""); // Extract only numeric and $ characters
            System.out.println("Total Balance: " + totalBalance);

            // Extract and print Credit Available
            WebElement creditAvailableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='balance-value'])[2]")));
            String creditAvailable = creditAvailableElement.getText().replaceAll("[^0-9$]", ""); // Extract only numeric and $ characters
            System.out.println("Credit Available: " + creditAvailable);

            // Wait for the transactions table to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table.table-padded tbody")));

            // Find recent transactions
            List<WebElement> transactions = driver.findElements(By.cssSelector(".table.table-padded tbody tr"));
            System.out.println("Recent Transactions:");
            for (WebElement transaction : transactions) {
                // Extract Status
                String status = transaction.findElement(By.cssSelector("td:nth-child(1) > span:last-child")).getText();

                // Extract Description
                String description = transaction.findElement(By.cssSelector("td.cell-with-media span")).getText();

                // Extract Amount
                String amount = transaction.findElement(By.cssSelector("td.text-right.bolder.nowrap span")).getText();

                // Print the transaction details
                System.out.println("Description: " + description);
                System.out.println("Status: " + status);
                System.out.println("Amount: " + amount);
                System.out.println("-----");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
