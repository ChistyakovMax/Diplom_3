package site.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    WebDriver driver;

    protected static final String pageUrl = "https://stellarburgers.nomoreparties.site";

    protected String currentUrl;

    public static final String LOGIN = "/login";
    public static final String FORGOT_PASSWORD = "/forgot-password";
    public static final String PROFILE = "/account/profile";
    public static final String REGISTER = "/register";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl(){
        return currentUrl;
    }

    //ссылка Войти (Вспомнили пароль? / Уже зарегестрированы?)
    @FindBy(xpath = ".//a[text() = 'Войти']")
    private WebElement signInLink;


    //шаги
    @Step("Нажать на ссылку Войти (Вспомнили пароль? / Уже зарегестрированы?)")
    public void clickSignInLink(){
        signInLink.click();
    }

}
