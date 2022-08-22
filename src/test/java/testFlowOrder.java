import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import pages.OrderPage;

public class testFlowOrder {
    WebDriver driver = new Browsers().firefox(); // Настройка браузеров.
//    WebDriver driver = new Browsers().chrome();
    public String url = "https://qa-scooter.praktikum-services.ru/";
    private String firstName = "Андрей";
    private String lastName = "Осипов";
    private String address = "Москва";
    private String subwayStation = "Чер";
    private String phone = "+78005555550";
    private String date = "30.08.2022";
    private String expect = "Заказ оформлен";
    public void order(String firstName, String lastName, String address, String subwayStation, String phone, String date) {
        driver.findElement(OrderPage.inputFirstName).sendKeys(firstName);
        driver.findElement(OrderPage.inputLastName).sendKeys(lastName);
        driver.findElement(OrderPage.inputAddress).sendKeys(address);
        driver.findElement(OrderPage.inputSubwayStation).sendKeys(subwayStation);
        driver.findElement(OrderPage.changeSubwayStation).click();
        driver.findElement(OrderPage.inputPhone).sendKeys(phone);
        driver.findElement(OrderPage.buttonNext).click();
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.inputDate));
        driver.findElement(OrderPage.inputDate).sendKeys(date);
        driver.findElement(OrderPage.title).click();
        driver.findElement(OrderPage.inputPeriodRent).click();
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.dropDown1));
        driver.findElement(OrderPage.dropDown1).click();
        driver.findElement(OrderPage.labelBlack).click();
        driver.findElement(OrderPage.buttonOrder).click();
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.buttonConfirm));
        driver.findElement(OrderPage.buttonConfirm).click();
    }
    @Before
    public void start() {
        driver.get(url);
    }
    @Test
    public void testOrderThroughHeader() {
        driver.findElement(MainPage.buttonToOrderHeader).click();
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.inputFirstName));
        order(firstName, lastName, address, subwayStation, phone, date);
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.modalSuccess));
        Assert.assertTrue(driver.findElement(OrderPage.modalSuccess).getText().contains(expect));
    }
    @Test
    public void testOrderThroughContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(MainPage.buttonToOrderContent));
        driver.findElement(MainPage.buttonToOrderContent).click();
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.inputFirstName));
        order(firstName, lastName, address, subwayStation, phone, date);
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.modalSuccess));
        Assert.assertTrue(driver.findElement(OrderPage.modalSuccess).getText().contains(expect));
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}