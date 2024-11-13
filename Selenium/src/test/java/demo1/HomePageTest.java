package demo1;


import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    public void testTransactionListLoadedCorrectly() {
        // Iniciar sesión
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("myName", "123");

        // Validar lista de transacciones en la página principal
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isTransactionListVisible(), "La lista de transacciones no está visible.");

        // Validar la cantidad de transacciones (ajustar este valor según el número esperado de transacciones)
        int expectedTransactionCount = 6; // Número esperado
        assertEquals(expectedTransactionCount, homePage.getTransactionCount(), "La cantidad de transacciones no coincide.");

        // Validar descripciones de transacciones (ejemplo, puedes personalizarlo)
        List<String> expectedDescriptions = List.of("Starbucks coffee", "Stripe Payment Processing", "MailChimp Services", "Shopify product", "Ebay Marketplace", "Templates Inc");
        assertEquals(expectedDescriptions, homePage.getTransactionDescriptions(), "Las descripciones de transacciones no coinciden.");
    }
}
