import bank.tests.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objekt.OpenPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


//Die Klasse mit den parametrisierten Tests
public class ParametrizedTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({" Förderung, Schiller, Viktor, krist@outlook.de, Sehr geehrte Damen und Herren..",
            "Förderung, Schröder, Maximilian, max@outlook.de, Guten Tag ich interessiere mich für.."})
    public void openWebsite(String eingabe, String lastname, String surname, String email, String text) throws InterruptedException {

        OpenPage openWebsite = new OpenPage(driver);
        openWebsite.clickCookie();
        openWebsite.clickResearch(eingabe);
        openWebsite.startResearch();
        openWebsite.clickKontakt();
        openWebsite.fillKontaktDaten(lastname);
        openWebsite.fillOutTheContactWindow(surname);
        openWebsite.fillEmail(email);
        openWebsite.fillFormular(text);
        openWebsite.activateCheckBox();


        // Hinzufügung der Wartezeit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Warten 10 Sekunden
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[span='Bitte senden Sie mir eine Kopie der Nachricht an die oben angegebene Mail-Adresse.']")));
        String actualText = element.getText();

        // Erwartetes Ergebnis
        String expectedText = "Bitte senden Sie mir eine Kopie der Nachricht an die oben angegebene Mail-Adresse.";

        // Prüfen,ob der aktuelle Text mit dem erwarteten Text übereinstimmt
        assertTrue(actualText.contains(expectedText), "Der aktuelle Text stimmt nicht mit dem erwartbaren Text überein.");
    }
}








