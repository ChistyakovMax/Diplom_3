package site.stellarburgers.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryPage extends BasePage {

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl + FORGOT_PASSWORD;
    }

    //кнопка Восстановить
    @FindBy(xpath = ".//button[text()='Восстановить']")
    private WebElement restorePasswordButton;

    //вспомогательные методы
    public void waitRestorePasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(restorePasswordButton));
    }

}
