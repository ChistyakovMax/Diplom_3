package site.stellarburgers.page_objects;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    WebDriver driver;

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    public String currentUrl;

    public static final String LOGIN = "/login";

    public static final String FORGOT_PASSWORD = "/forgot-password";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl(){
        return currentUrl;
    }

}
