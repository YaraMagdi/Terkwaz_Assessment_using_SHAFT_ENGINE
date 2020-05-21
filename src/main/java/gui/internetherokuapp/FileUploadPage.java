package gui.internetherokuapp;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    // declaring webdriver object and web elements that will be used in this class
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    // Initializing the constructor for this class
    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    // A method to perform click action on specified web element
    public void clickUploadButton(){
        ElementActions.click(driver, uploadButton);
    }

    /**
     * Provides path of image to the form then clicks Upload button
     * @param absolutePathOfImage The complete path of the image to upload
     */
    public void uploadImage(String absolutePathOfImage){
        ElementActions.type(driver, inputField, absolutePathOfImage);
        clickUploadButton();
    }

    /**
     * A method to get uploaded files
     * @return Uploaded Files text will be returned as string
     */
    public String getUploadedFiles(){
        return ElementActions.getText(driver, uploadedFiles);
    }

    // Assert the uploaded Image is correct
    public void assertUploadedImageIsCorrect() {
        Assertions.assertEquals("unnamed.jpg", getUploadedFiles(), Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }
}
