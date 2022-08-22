package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends MainPage {
    private WebDriver driver;

    // Поле имя
    public static By inputFirstName = By.xpath("//input[@placeholder='* Имя']");
    // Поле Фамилия
    public static By inputLastName = By.xpath("//input[@placeholder='* Фамилия']");
    // Поле Адрес
    public static By inputAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция метро
    public static By inputSubwayStation = By.xpath("//input[@placeholder='* Станция метро']");
    // Элемент списка Станция метро Чертановская
    public static By changeSubwayStation = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[4]/div/div[2]");
    // Поле Телефон
    public static By inputPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    public static By buttonNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Поле Дата
    public static By inputDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Загаловок Про аренду
    public static By title = By.xpath("//div[@class='Order_Header__BZXOb']");
    // Поле Срок
    public static By inputPeriodRent = By.className("Dropdown-control");
    // Поле Срок - 1 сутки
    public static By dropDown1 = By.cssSelector("div[class='Dropdown-menu'] div:nth-child(1)");
    // Поле Цвет Черный
    public static By labelBlack = By.xpath("//label[@for='black']");
    // Кнопка Заказать
    public static By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка подтверждения заказа
    public static By buttonConfirm = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Контейнер с модалки Успех
    public static By modalSuccess = By.className("Order_ModalHeader__3FDaJ");
}
