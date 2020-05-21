package gui.internetherokuapp;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    // declaring webdriver, webdriverwait objects and web elements that will be used in this class
    private WebDriver driver;
    private WebDriverWait wait;
    private By startButton = By.xpath("//*[@id='start']//following::button");
    private By displayedText = By.id("finish");

    // Initializing the constructor for this class
    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }

    /*
      A method to click on start button
      Using Explicit wait to wait until specified element is exist
     */
    public void clickStart() {
        ElementActions.click(driver, startButton);

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(displayedText));
    }

    // A method to verify if element is displayed or not
    public boolean isStartButtonDisplayed(){
        return ElementActions.isElementDisplayed(driver, startButton);
    }

    // A method to get displayed text for specified web element
    public String getDisplayedText(){
        return ElementActions.getText(driver, displayedText);
    }

    // Assert the displayed text for web element is correct
    public void assertDisplayedTextIsCorrect() {
        Assertions.assertEquals("Hello World!", getDisplayedText(), Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }
}