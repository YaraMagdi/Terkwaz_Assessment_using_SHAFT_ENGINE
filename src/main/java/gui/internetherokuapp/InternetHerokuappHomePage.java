package gui.internetherokuapp;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternetHerokuappHomePage {
    private WebDriver driver;
    private String urlForNavigation = "https://the-internet.herokuapp.com/";

    public InternetHerokuappHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToInternetHerokuapp() {
        BrowserActions.navigateToURL(driver, urlForNavigation);
    }

    private void clickLink(String linkText){
        ElementActions.click(driver, By.linkText(linkText));
    }

    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
}
