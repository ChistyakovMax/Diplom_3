package site.stellarburgers;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import site.stellarburgers.page_objects.MainPage;

public class ConstructorTabsTest extends BaseTest {

    MainPage mainPage;

    @Before
    public void start() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.waitForSignInButton();
    }

    @Test
    @Description("Проверка перехода к разделу Булки")
    public void switchToBunsTabTabSwitched() {
        //сначала выберем другой раздел, чтобы удостовериться, что переключение было
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        Assert.assertEquals("Булки", mainPage.getCurrentTabText());
    }

    @Test
    @Description("Проверка перехода к разделу Соусы")
    public void switchToSaucesTabTabSwitched() {
        mainPage.clickSaucesTab();

        Assert.assertEquals("Соусы", mainPage.getCurrentTabText());
    }

    @Test
    @Description("Проверка перехода к разделу Начинки")
    public void switchToToppingsTabTabSwitched() {
        mainPage.clickToppingsTab();
        Assert.assertEquals("Начинки", mainPage.getCurrentTabText());
    }

}
