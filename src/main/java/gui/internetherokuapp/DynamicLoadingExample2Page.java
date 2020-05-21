package gui.internetherokuapp;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private WebDriverWait wait;
    private By startButton = By.xpath("//*[@id='start']//following::button");
    private By displayedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStart() {
        ElementActions.click(driver, startButton);

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(displayedText));
    }

    public boolean isStartButtonDisplayed(){
        return ElementActions.isElementDisplayed(driver, startButton);
    }

    public String getDisplayedText(){
        return ElementActions.getText(driver, displayedText);
    }

    public void assertDisplayedTextIsCorrect() {
        Assertions.assertEquals("Hello World!", getDisplayedText(), Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

}
