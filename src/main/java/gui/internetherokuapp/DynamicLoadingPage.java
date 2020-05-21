package gui.internetherokuapp;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By DynamicLoadingExample2 = By.cssSelector("a[href='/dynamic_loading/2']");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample2Page clickExample2() {
        ElementActions.click(driver, DynamicLoadingExample2);
        return new DynamicLoadingExample2Page(driver);
    }
}
