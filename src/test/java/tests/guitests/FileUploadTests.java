package tests.guitests;

import com.shaft.gui.browser.BrowserFactory;
import gui.internetherokuapp.FileUploadPage;
import gui.internetherokuapp.InternetHerokuappHomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTests {
    // Declaring WebDriver instances
    private WebDriver driver;

    // Declaring The Page Objects that will be used throughout the test class
    private InternetHerokuappHomePage internetHerokuappHomePage;
    private FileUploadPage fileUploadPage;

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

    @Test(description = "TC003 - Upload Image successfully")
    @Description("Given I am on File Upload page, When I click upload and select an image, Then the image will be uploaded successfully")
    public void testFileUpload() {
        fileUploadPage = internetHerokuappHomePage.clickFileUpload();
        fileUploadPage.uploadImage("D:\\My_Workspaces\\My_TestAutomation_Workspace\\Terkwaz_Assessment\\Terkwaz_Assessment_using_SHAFT_ENGINE\\src\\test\\resources\\unnamed.jpg");
        fileUploadPage.assertUploadedImageIsCorrect();
    }
}
