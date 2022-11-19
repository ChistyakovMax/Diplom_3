package site.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import site.stellarburgers.page_objects.LoginPage;
import site.stellarburgers.page_objects.RegistrationPage;

@DisplayName("Регистрация нового пользователя")
public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage;

    private final String name = "Max";
    private String email, password;

    @Before
    public void start() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getCurrentUrl());
        registrationPage.waitForSignUpButton();

        email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
    }

    @Test
    @DisplayName("Создание валидного пользователя")
    public void createValidUserSuccessfullyCreated() {
        password = RandomStringUtils.randomAlphanumeric(10);

        registrationPage.fillAllTheFields(name, email, password);
        registrationPage.clickSignUpButton();

        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();

        Assert.assertEquals(loginPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка ошибки поля Пароль при создании пользователя")
    public void createUserWithIncorrectPasswordGetError() {
        //Минимальный пароль — шесть символов
        password = "1234";

        registrationPage.fillAllTheFields(name, email, password);
        registrationPage.clickSignUpButton();

        registrationPage.waitForIncorrectPasswordError();
        Assert.assertEquals("Некорректный пароль", registrationPage.getIncorrectPasswordErrorText());
    }

}
