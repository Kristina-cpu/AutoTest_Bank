package page.objekt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Page Objekt KLasse
public class OpenPage {
    private WebDriver driver;

    //OpenPage Konstructor
    public OpenPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Annotation für die Webelements
    @FindBy(xpath = "//*[@aria-label='Zustimmung der Nutzung von Cookies auf der Webseite der Thüringer Aufbaubank']")
    private WebElement cookie;

    //Methode für den Webelement Cookie
    //Cookie anklicken
    public void clickCookie() {

        cookie.click();
    }

    //Suche öffnen
    @FindBy(xpath = "//button[@class='icon-search mobi-search-toggle']")

    private WebElement toggle;
    //Suchbegriff eingeben
    @FindBy(xpath = "//*[@placeholder='Suchbegriff eingeben']")
    private WebElement suchbegriff;
    //
    @FindBy(xpath = "//*[@title='Suche starten']")
    private WebElement startdersuche;

    public void clickResearch(String eingabe) {
        toggle.click();
        suchbegriff.sendKeys(eingabe);
        startdersuche.click();
    }

    //Kleinkläranlagen auswählen
    @FindBy(xpath = "//*[@title='Kleinkläranlagen']")
    WebElement kleinkläranlagen;

    public void startResearch() {

        kleinkläranlagen.click();
    }

    @FindBy(xpath = "//*[@class='opener icon-mail']")
    WebElement iconmail;

    public void clickKontakt() {

        iconmail.click();
    }

    //Ausfüllen der Kontaktdaten
    @FindBy(xpath = "//*[@class='msg info']")
    WebElement msginfo;
    @FindBy(xpath = "//*[@title='Wählen Sie Ihre Kundenbetreuung']")
    WebElement kundenbetreuung;
    @FindBy(xpath = "//*[text()='Kundenbetreuung Nordthüringen']")
    WebElement nordthueringen;
    @FindBy(xpath = "//*[@id='overlay_surname']")
    WebElement oversurname;

    public void fillOutTheContactWindow(String surname) {
        msginfo.getText();
        kundenbetreuung.click();
        nordthueringen.click();
        oversurname.sendKeys(surname);

    }

    @FindBy(xpath = "//*[@id='overlay_name']")
    WebElement overlayname;

    public void fillKontaktDaten(String lastname) {
        overlayname.sendKeys(lastname);
    }

    @FindBy(xpath = "//*[@id='overlay_email']")
    WebElement overemail;

    public void fillEmail(String email) {
        overemail.sendKeys(email);
    }

    @FindBy(xpath = "//*[@id='overlay_text']")
    WebElement overtext;

    public void fillFormular(String text) {
        overtext.sendKeys(text);
    }

    @FindBy(xpath = "//*[@for='form-datenverarbeitung']")
    WebElement datenverarbeitung;
    @FindBy(xpath = "//*[@for='form-datenschutz']")
    WebElement datenschutz;

    public void activateCheckBox() {
        datenverarbeitung.click();
        datenschutz.click();
    }
}