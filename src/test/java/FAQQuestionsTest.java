import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQQuestionsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String question;
    private final String expectedAnswer;


    @Parameterized.Parameters
    public static Object[] getParameters() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    public FAQQuestionsTest(String question, String expectedAnswer) {
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Сергей\\Sprint4\\WebDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage mainPage = new MainPage();
        mainPage.acceptCookies(driver); // Принять куки
    }

    @Test
    public void dropDownTest() {

        WebElement questionElement = driver.findElement(By.xpath("//*[@id='accordion__heading-0']"));
        questionElement.click();
        WebElement questionElementOne = driver.findElement(By.xpath("//*[@id='accordion__heading-1']"));

        WebElement questionElementTwo = driver.findElement(By.xpath("//*[@id='accordion__heading-2']"));
        questionElement.click();
        WebElement questionElementThree = driver.findElement(By.xpath("//*[@id='accordion__heading-3']"));
        questionElement.click();

        WebElement questionElementFour = driver.findElement(By.xpath("//*[@id='accordion__heading-4']"));
        questionElement.click();
        WebElement questionElementFive = driver.findElement(By.xpath("//*[@id='accordion__heading-5']"));
        questionElement.click();
        WebElement questionElementSix = driver.findElement(By.xpath("//*[@id='accordion__heading-6']"));
        questionElement.click();WebElement questionElementSeven = driver.findElement(By.xpath("//*[@id='accordion__heading-7']"));
        questionElement.click();


        WebElement answerElement = driver.findElement(By.xpath("//*[@id='accordion__panel-0']/p"));
        String actualAnswer = answerElement.getText();
        WebElement answerElementOne = driver.findElement(By.xpath("//*[@id='accordion__panel-1']/p"));
        String actualAnswerOne = answerElement.getText();
        WebElement answerElementTwo = driver.findElement(By.xpath("//*[@id='accordion__panel-3']/p"));
        String actualAnswerTwo = answerElement.getText();
        WebElement answerElementThree = driver.findElement(By.xpath("//*[@id='accordion__panel-4']/p"));
        String actualAnswerThree = answerElement.getText();
        WebElement answerElementFour = driver.findElement(By.xpath("//*[@id='accordion__panel-5']/p"));
        String actualAnswerFive = answerElement.getText();
        WebElement answerElementFive = driver.findElement(By.xpath("//*[@id='accordion__panel-6']/p"));
        String actualAnswerSix = answerElement.getText();
        WebElement answerElementSix = driver.findElement(By.xpath("//*[@id='accordion__panel-7']/p"));
        String actualAnswerSeven = answerElement.getText();
        assertEquals(expectedAnswer, actualAnswer);
    }

    @After
    public void tearDown () {
        driver.quit();
    }
}
