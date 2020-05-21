package gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class GoogleHomePage {

    // declaring webdriver object and web elements that will be used in this class
    private WebDriver driver;
    private String urlForNavigation = "https://www.google.com/ncr";
    private String urlAfterRedirection = "https://www.google.com";
    private By searchBox = By.name("q");

    // Initializing the constructor for this class
    public GoogleHomePage(WebDriver driver) {
	this.driver = driver;
    }

    // A method to open google URL
    public void navigateToGoogle() {
	BrowserActions.navigateToURL(driver, urlForNavigation, urlAfterRedirection);
    }

    /**
     * A method to search for data in google
     * @param searchData , a string parameter that refer to data we need to search for
     * @return after submitting GoogleSearchResultsPage should be returned
     */
    public GoogleSearchResultsPage searchFor(String searchData) {
	ElementActions.type(driver, searchBox, searchData);
	ElementActions.keyPress(driver, searchBox, Keys.ENTER);
    return new GoogleSearchResultsPage(driver);
    }
}