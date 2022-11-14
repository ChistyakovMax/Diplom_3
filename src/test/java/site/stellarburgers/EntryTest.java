package site.stellarburgers;


import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import site.stellarburgers.page_objects.LoginPage;
import site.stellarburgers.page_objects.MainPage;
import site.stellarburgers.page_objects.PasswordRecoveryPage;
import site.stellarburgers.page_objects.RegistrationPage;

public class EntryTest extends BaseTest{

    MainPage mainPage;
    RegistrationPage registrationPage;
    PasswordRecoveryPage passwordRecoveryPage;
    LoginPage loginPage;


    @After
    public void end() {
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();
        loginPage.fillEmailAndPassword(super.emailCred, super.passwordCred);
        loginPage.clickSignInButton();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForOrderButton();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }

    @Test
    @Description("Вход в приложение по кнопке «Войти в аккаунт» на главной странице")
    public void clickLogInOnMainPageUserLoggedIn() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.waitForSignInButton();

        mainPage.clickSignInButton();
    }

    @Test
    @Description("Вход в приложение через кнопку «Личный кабинет»  на главной странице")
    public void clickPersonalAccountButtonOnMainPageUserLoggedIn() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.waitForSignInButton();

        mainPage.clickPersonalAccount();
    }

    @Test
    @Description("Вход в приложение через кнопку Войти (Уже зарегестрированы?) на форме регистрации")
    public void clickSignInLinkOnRegistrationPageUserLoggedIn() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getCurrentUrl());
        registrationPage.waitForSignUpButton();
        registrationPage.clickSignInLink();
    }

    @Test
    @Description("Вход в приложение через кнопку Войти (Вспомнили пароль?) на странице восстановления пароля")
    public void clickSignInLinkOnPasswordRecoveryPageUserLoggedIn() {
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        PageFactory.initElements(driver, passwordRecoveryPage);
        driver.get(passwordRecoveryPage.getCurrentUrl());
        passwordRecoveryPage.waitForRestorePasswordButton();
        passwordRecoveryPage.clickSignInLink();
    }
}
