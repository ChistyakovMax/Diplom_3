package site.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//общий класс для тестов
public abstract class BaseTest {

    WebDriver driver;
    //creds
    protected final String emailCred = "biberbest66@mail.ru";
    protected final String passwordCred = "Password1234!";

    @Before
    public void setup() {

        //тест на Google Chrome
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/

        //тест на ЯБраузере (пытался сделать с драйвером, но пока не получилось)
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary("C:\\Users\\chist\\AppData\\Local" +
                "\\Yandex\\YandexBrowser\\Application\\browser.exe"));

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
