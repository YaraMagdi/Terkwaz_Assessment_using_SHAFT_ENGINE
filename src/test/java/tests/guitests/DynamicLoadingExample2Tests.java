package tests.guitests;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import gui.google.GoogleHomePage;
import gui.internetherokuapp.DynamicLoadingExample2Page;
import gui.internetherokuapp.DynamicLoadingPage;
import gui.internetherokuapp.InternetHerokuappHomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingExample2Tests {
    // Declaring WebDriver instances
    private WebDriver driver;

    // Declaring The Page Objects that will be used throughout the test class
    private InternetHerokuappHomePage internetHerokuappHomePage;
    private DynamicLoadingPage dynamicLoadingPage;
    private DynamicLoadingExample2Page dynamicLoadingExample2Page;

    /**
     * This is a Set-up method @BeforeClass, to be always run once before the first test in the current class
     */
    @BeforeClass(alwaysRun = true)
    public void initializeGlobalObjectsAndNavigateToGoogleHomePage() {
        // initializing the AI support for element identification
        System.setProperty("aiSupportedElementIdentification", "true");

        // initializing the driver by selecting one of the supported browsers
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);

        internetHerokuappHomePage = new InternetHerokuappHomePage(driver);
        internetHerokuappHomePage.navigateToInternetHerokuapp();
    }

    @Test(description = "TC002 - Wait for Dynamic loading example 2 result to be displayed")
    @Description("Given I am on Dynamic loading Example2 page, When I click on start, Then Text will be displayed after loading finished.")
    public void WaitUntilDisplayed(){
        dynamicLoadingPage = internetHerokuappHomePage.clickDynamicLoading();
        dynamicLoadingExample2Page = dynamicLoadingPage.clickExample2();
        dynamicLoadingExample2Page.clickStart();
        dynamicLoadingExample2Page.assertDisplayedTextIsCorrect();
    }
}