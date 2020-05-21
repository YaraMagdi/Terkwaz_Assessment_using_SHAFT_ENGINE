package gui.internetherokuapp;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternetHerokuappHomePage {

    // declaring webdriver object and web elements that will be used in this class
    private WebDriver driver;
    private String urlForNavigation = "https://the-internet.herokuapp.com/";

    // Initializing the constructor for this class
    public InternetHerokuappHomePage(WebDriver driver){
        this.driver = driver;
    }

    // A method to open Internet.Herokuapp URL
    public void navigateToInternetHerokuapp() {
        BrowserActions.navigateToURL(driver, urlForNavigation);
    }

    /**
     * A helper method to be used to click any link by its text
     * @param linkText text for link refer to specified web element
     */
    private void clickLink(String linkText){
        ElementActions.click(driver, By.linkText(linkText));
    }

    /**
     * A method to open File Upload page by clicking on it
     * @return FileUploadPage will be opened
     */
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    /**
     * A method to open File Upload page by clicking on it
     * @return DynamicLoadingPage will be opened
     */
    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
}