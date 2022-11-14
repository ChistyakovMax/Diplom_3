package site.stellarburgers;

import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import site.stellarburgers.page_objects.LoginPage;
import site.stellarburgers.page_objects.RegistrationPage;

import java.time.Duration;

@Description("Регистрация нового пользователя")
public class RegistrationTest extends BaseTest{

    RegistrationPage registrationPage;

    private final String name = "Max";
    private String email, password;

    @Before
    public void start() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registrationPage = new RegistrationPage(driver);

        PageFactory.initElements(driver, registrationPage);

        driver.get(registrationPage.getCurrentUrl());
        registrationPage.waitForSignUpButton();

        email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
    }

    @Test
    @Description("Создание валидного пользователя")
    public void createValidUserSuccessfullyCreated() throws InterruptedException {
        password = RandomStringUtils.randomAlphanumeric(10);

        registrationPage.fillNameInput(name);
        registrationPage.fillEmailInput(email);
        registrationPage.fillPasswordInput(password);
        registrationPage.clickSignUpButton();

        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();

        Assert.assertEquals(loginPage.getCurrentUrl(), driver.getCurrentUrl());
    }




}
