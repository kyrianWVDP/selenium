package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Selectores
    private By transactionsTableRows = By.cssSelector(".table.table-padded tbody tr");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Método para verificar que la tabla de transacciones esté visible
    public boolean isTransactionListVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(transactionsTableRows)) != null;
    }

    // Método para obtener la cantidad de transacciones
    public int getTransactionCount() {
        List<WebElement> rows = driver.findElements(transactionsTableRows);
        return rows.size();
    }

    // Método para obtener la descripción de cada transacción
    public List<String> getTransactionDescriptions() {
        List<WebElement> rows = driver.findElements(transactionsTableRows);
        return rows.stream()
                .map(row -> row.findElement(By.cssSelector("td.cell-with-media span")).getText())
                .toList();
    }
}
