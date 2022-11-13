package site.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoveryPage extends Page{

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl + FORGOT_PASSWORD;
    }

    //кнопка Восстановить
    @FindBy(xpath = ".//button[text()='Восстановить']")
    private WebElement restorePasswordButton;

    //ссылка Войти (Вспомнили пароль?)
    @FindBy(xpath = ".//a[text() = 'Войти']")
    private WebElement signInLink;



    //шаги
    @Step("Нажать на ссылку Войти (Вспомнили пароль?)")
    public void clickSignInLink(){
        signInLink.click();
    }

}
