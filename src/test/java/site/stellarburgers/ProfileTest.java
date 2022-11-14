package site.stellarburgers;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import site.stellarburgers.page_objects.LoginPage;
import site.stellarburgers.page_objects.MainPage;
import site.stellarburgers.page_objects.ProfilePage;

public class ProfileTest extends BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    ProfilePage profilePage;

    //creds
    private final String email = "biberbest66@mail.ru";
    private final String password = "Password1234!";

    @Before
    public void start() {
        //до начала всех тестов нужно залогиниться в приложении
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        driver.get(loginPage.getCurrentUrl());
        loginPage.waitForSignInButton();

        //ввести креды
        loginPage.fillEmailAndPassword(email, password);
        loginPage.clickSignInButton();

        //потом перейти на главную страницу
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForOrderButton();

        //а с главной страницы перейти в Профиль
        mainPage.clickPersonalAccount();
        profilePage = new ProfilePage(driver);
        PageFactory.initElements(driver, profilePage);
        profilePage.waitForProfileLink();
    }

    @Test
    @Description("Переход в ЛК по клику на кнопку Личный кабинет на Главной странице")
    public void clickPersonalAccountButtonRedirectedToProfilePage() {
        Assert.assertEquals(profilePage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @Description("Переход из личного кабинета в конструктор на главной странице")
    public void clickConstructorRedirectedToMainPage() {
        profilePage.clickConstructor();
        mainPage.waitForOrderButton();
        Assert.assertEquals(mainPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @Description("Переход из личного кабинета на главную страницу по клику на профиль")
    public void clickLogoRedirectedToMainPage() {
        profilePage.clickStellarburgersLogo();
        mainPage.waitForOrderButton();
        Assert.assertEquals(mainPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @Description("Выход из профиля по кнопке «Выйти» в личном кабинете")
    public void clickLogOutButtonLogOut() {
        profilePage.clickLogOutButton();
        loginPage.waitForSignInButton();
        Assert.assertEquals(loginPage.getCurrentUrl(), driver.getCurrentUrl());
    }

}