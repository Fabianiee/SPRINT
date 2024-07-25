import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterOrderForm {
    private final WebDriverWait wait;
    private WebDriver driver;

    public ScooterOrderForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Локаторы формы заказа
    private By nameField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private By surnameField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private By addressField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private By metroStationInput = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    private By phoneField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    private By nextButton = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button");

    // Локаторы про аренду
    private By deliveryDateField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private By rentalPeriodField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    private By scooterColourField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[3]/label[1]"); //
    private By commentField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    private By orderButton = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button[2]");
    private By submitButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]"); // без этой кнопки тест работает. в хроме баг

    // Методы для заполнения формы заказа
    public void fillOrderForm(String name, String surname, String address, String metroStation, String phone,
                              String deliveryDate, String rentalPeriod, String scooterColour, String comment) {
//заполнение формы заказа

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);

        driver.findElement(metroStationInput).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();

        // Заполнение формы про аренду
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(rentalPeriodField).sendKeys(rentalPeriod);
        driver.findElement(scooterColourField).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(submitButton).click();
    }

}


