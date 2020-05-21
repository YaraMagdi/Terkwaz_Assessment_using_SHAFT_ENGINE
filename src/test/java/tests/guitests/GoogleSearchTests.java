package tests.guitests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.browser.BrowserFactory.BrowserType;
import com.shaft.tools.io.ExcelFileManager;

import io.qameta.allure.Description;
import gui.google.GoogleHomePage;
import gui.google.GoogleSearchResultsPage;

public class GoogleSearchTests {

    // Declaring WebDriver and ExcelFileManager instances
    private WebDriver driver;
    private ExcelFileManager googleSearch;

    // Declaring The Page Objects that will be used throughout the test class
    private GoogleHomePage googleHomePage;
    private GoogleSearchResultsPage googleSearchResultsPage;

    /**
     * This is a Set-up method @BeforeClass, to be always run once before the first test in the current class
     */
    @BeforeClass(alwaysRun = true)
    public void initializeGlobalObjectsAndNavigateToGoogleHomePage() {
        // initializing the AI support for element identification
        System.setProperty("aiSupportedElementIdentification", "true");

        // initializing the googleSearch object by pointing it to the directory of the target test data file in Properties
        googleSearch = new ExcelFileManager(System.getProperty("testDataFolderPath") + "Google/GoogleSearch.xlsx");

        // initializing the driver by selecting one of the supported browsers
        driver = BrowserFactory.getBrowser(BrowserType.GOOGLE_CHROME);

        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.navigateToGoogle();
    }

    @Test(description = "TC001 - Search for Query and Assert that the link of the first result matches the expected text")
    @Description("Given I am on the home page, When I search for the second query, Then the link of the first result will match the expected text.")
    public void searchForDataAndAssertTextOfTheThirdResult() {
	googleHomePage.searchFor(googleSearch.getCellData("Search Data", "Data"));

        googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        googleSearchResultsPage.assertResultLinkForSpecificResultIndex(4,
            googleSearch.getCellData("Expected Third Search Result contain"));
    }

}