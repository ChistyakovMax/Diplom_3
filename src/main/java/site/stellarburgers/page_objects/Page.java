package site.stellarburgers.page_objects;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    WebDriver driver;

    public static String pageUrl = "https://stellarburgers.nomoreparties.site/";

    public static String LOGIN = "/login";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

}
