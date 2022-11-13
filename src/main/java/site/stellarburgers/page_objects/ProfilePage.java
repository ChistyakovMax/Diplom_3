package site.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends Page{

    public ProfilePage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl + PROFILE;
    }

    //ссылка Профиль
    @FindBy(xpath = ".//a[text() = 'Профиль']")
    private WebElement profileLink;

    //кнопка Выход
    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement logOutButton;



    //шаги
    @Step("Клик на кнопку Выход")
    public void clickLogOutButton(){
        logOutButton.click();
    }

    //вспомогательные методы
    public void waitProfileLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(profileLink));
    }
}
