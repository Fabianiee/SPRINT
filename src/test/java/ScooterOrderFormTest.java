import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ScooterOrderFormTest {

    private WebDriver driver;
    private MainPage mainPage;
    private ScooterOrderForm scooterOrderForm;
    private String nameField;
    private String surnameField;
    private String addressField;
    private String metroStation;
    private String phoneField = "79999999999";
    private String deliveryDateField;
    private String rentalPeriodField;
    private String scooterColourField;
    private String commentField;
    private String expectedHeader = "Заказ оформлен";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Сергей\\Sprint4\\WebDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        mainPage = new MainPage();
        mainPage.acceptCookies(driver);

        // Инициализация полей
        nameField = "Мария";
        surnameField = "Синогейкина";
        addressField = "Луначарского 41";
        metroStation = "Черкизовская";
        deliveryDateField = "01.01.2024";
        rentalPeriodField = "Сутки";
        scooterColourField = "Черный";
        commentField = "Без комментариев";


        scooterOrderForm = new ScooterOrderForm(driver);
    }

    @Test
    public void testOrderFlow() {
        mainPage.clickOrderButton(driver, true);

        if (scooterOrderForm == null) {
            throw new IllegalStateException("scooterOrderForm is not initialized");
        }

        scooterOrderForm.fillOrderForm(
                nameField,
                surnameField,
                addressField,
                metroStation,
                phoneField,
                deliveryDateField,
                rentalPeriodField,
                scooterColourField,
                commentField
        );


    }

    @After
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }
}


