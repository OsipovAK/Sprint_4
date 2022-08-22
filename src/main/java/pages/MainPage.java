package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;
    // Кнопка Заказать в хэдере
    public static By buttonToOrderHeader = By.className("Button_Button__ra12g");
    // Кнопка Заказать внизу страницы
    public static By buttonToOrderContent = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    // Кнопка аккордиона #1
    public static By accordionButton1 = By.id("accordion__heading-0");
    // Текст аккордиона #1
    public static By accordionText1 = By.xpath("//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или')]");
    // Кнопка аккордиона #2
    public static By accordionButton2 = By.id("accordion__heading-1");
    // Текст аккордиона #2
    public static By accordionText2 = By.xpath("//p[contains(text(),'Пока что у нас так: один заказ — один самокат. Есл')]");
    // Кнопка аккордиона #3
    public static By accordionButton3 = By.id("accordion__heading-2");
    // Текст аккордиона #3
    public static By accordionText3 = By.xpath("//p[contains(text(),'Допустим, вы оформляете')]");
    // Кнопка аккордиона #4
    public static By accordionButton4 = By.id("accordion__heading-3");
    // Текст аккордиона #4
    public static By accordionText4 = By.xpath("//p[contains(text(),'Только начиная с завтрашнего')]");
    // Кнопка аккордиона #5
    public static By accordionButton5 = By.id("accordion__heading-4");
    // Текст аккордиона #5
    public static By accordionText5 = By.xpath("//p[contains(text(),'Пока что нет!')]");
    // Кнопка аккордиона #6
    public static By accordionButton6 = By.id("accordion__heading-5");
    // Текст аккордиона #6
    public static By accordionText6 = By.xpath("//p[contains(text(),'Самокат приезжает к вам')]");
    // Кнопка аккордиона #7
    public static By accordionButton7 = By.id("accordion__heading-6");
    // Текст аккордиона #7
    public static By accordionText7 = By.xpath("//p[contains(text(),'Да, пока самокат не')]");
    // Кнопка аккордиона #8
    public static By accordionButton8 = By.id("accordion__heading-7");
    // Текст аккордиона #8
    public static By accordionText8 = By.xpath("//p[contains(text(),'Да, обязательно. Всем самокатов!')]");
}

