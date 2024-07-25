import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    // кнопка "Заказать" в правом верхнем углу экрана
    public static final By ORDER_BUTTON_ON_THE_TOP = By.xpath(".//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    // кнопка "Заказать" внизу страницы
    public static final By ORDER_BUTTON_ON_THE_BOTTOM = By.xpath("//*[//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");

    // Раздел "Вопросы о важном" - выпадающий список
    public static final By FAQ_QUESTIONS_DROPDOWN = By.xpath(".//*[@id='root']/div/div/div[5]/div[1]");
    // Вопрос
    public static final By QUESTION = By.xpath(".//*[@id='accordion__heading-0']");
    // Текст, раскрывающийся при нажатии на указатель с вопросом
    public static final By FAQ_QUESTIONS_TEXT = By.xpath(".//*[@id='accordion__panel-0']/p");

    public MainPage() {
    }

    // метод нажатия кнопки для заказа
    public static void clickOrderButton(WebDriver driver, boolean isTop) {
        if (isTop) {
            driver.findElement(ORDER_BUTTON_ON_THE_TOP).click();
        } else {
            driver.findElement(ORDER_BUTTON_ON_THE_BOTTOM).click();
        }
    }



    // метод для скролла страницы до раздела "Вопросы о важном"
    public void scrollHomePage(WebDriver driver) {
        driver.findElement(FAQ_QUESTIONS_DROPDOWN).click();
    }

    //метод для выбора вопроса из выпадающего списка
    public void selectFAQQuestion(WebDriver driver, String вопрос){

    }

    // метод для просмотра текста из выпадающего списка
    public String getFAQText(WebDriver driver) {
        return driver.findElement(FAQ_QUESTIONS_TEXT).getText();
    }
    // метод для одобрения куки
    public void acceptCookies(WebDriver driver) {driver.findElement(By.id("rcc-confirm-button")).click();
    }
}



