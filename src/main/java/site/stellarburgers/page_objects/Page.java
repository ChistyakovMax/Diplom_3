package site.stellarburgers.page_objects;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

}
