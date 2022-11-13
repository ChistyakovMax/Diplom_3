package site.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{

    String pageUrl = "https://stellarburgers.nomoreparties.site/";

    public String getPageUrl() {
        return pageUrl;
    }

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(pageUrl);
    }

    //кнопка Оформить заказ
    @FindBy(xpath = ".//button[text() = 'Оформить заказ']")
    private WebElement getOrderButton;

    // Личный кабинет
    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private WebElement personalAccount;

    //текущий раздел
    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private WebElement currentTab;

    //раздел Булки
    @FindBy(xpath = ".//div/span[text()='Булки']")
    private WebElement bunsTab;

    //раздел Соусы
    @FindBy(xpath = ".//div/span[text()='Соусы']")
    private WebElement saucesTab;

    //раздел Начинки
    @FindBy(xpath = ".//div/span[text()='Начинки']")
    private WebElement toppingTab;

    //конструктор
    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private WebElement constructor;

    //лого stellarburgers
    @FindBy(xpath = ".//div[@class = 'AppHeader_header__logo__2D0X2']")
    private WebElement stellarburgersLogo;












    @Step("Создать заказ")
    public void clickConstructor(){
        constructor.click();
    }

    @Step("Клик на лого stellarburgers")
    public void clickStellarburgersLogo(){
        stellarburgersLogo.click();
    }

    @Step("Клик по кнопке Оформить заказ")
    public void clickGetOrderButton(){
        getOrderButton.click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccount(){
        personalAccount.click();
    }

    @Step("Получить название активного раздела ингредиентов")
    public void getCurrentTabText(){
        currentTab.getText();
    }

    @Step("Клик на раздел Булки")
    public void clickBunsTab(){
        bunsTab.click();
    }

    @Step("Клик на раздел Соусы")
    public void clickSaucesTab(){
        saucesTab.click();
    }

    @Step("Клик на раздел Начинки")
    public void clickToppingTab(){
        toppingTab.click();
    }

}
