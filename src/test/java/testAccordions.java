import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class testAccordions {
    private WebDriver driver;
    public String url = "https://qa-scooter.praktikum-services.ru/";
    private static String expect1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static String expect2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static String expect3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static String expect4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static String expect5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static String expect6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static String expect7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static String expect8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    private By button;
    private By accordionText;
    private String expected;
    public testAccordions(By button, By accordionText, String expected) {
        super();
        this.button = button;
        this.accordionText = accordionText;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] startTest() {
        return new Object[][] {
                { MainPage.accordionButton1, MainPage.accordionText1, expect1},
                { MainPage.accordionButton2, MainPage.accordionText2, expect2},
                { MainPage.accordionButton3, MainPage.accordionText3, expect3},
                { MainPage.accordionButton4, MainPage.accordionText4, expect4},
                { MainPage.accordionButton5, MainPage.accordionText5, expect5},
                { MainPage.accordionButton6, MainPage.accordionText6, expect6},
                { MainPage.accordionButton7, MainPage.accordionText7, expect7},
                { MainPage.accordionButton8, MainPage.accordionText8, expect8},
        };
    }
    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    public void test() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(button));
        driver.findElement(button).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionText));
        Assert.assertEquals(expected, driver.findElement(accordionText).getText());
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}