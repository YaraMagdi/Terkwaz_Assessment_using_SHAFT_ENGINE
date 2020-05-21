package gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class GoogleHomePage {

    private WebDriver driver;
    private String urlForNavigation = "https://www.google.com/ncr";
    private String urlAfterRedirection = "https://www.google.com";
    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
	this.driver = driver;
    }

    public void navigateToGoogle() {
	BrowserActions.navigateToURL(driver, urlForNavigation, urlAfterRedirection);
    }

    public GoogleSearchResultsPage searchFor(String searchData) {
	ElementActions.type(driver, searchBox, searchData);
	ElementActions.keyPress(driver, searchBox, Keys.ENTER);
    return new GoogleSearchResultsPage(driver);
    }
}
