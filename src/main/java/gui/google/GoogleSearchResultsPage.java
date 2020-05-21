package gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class GoogleSearchResultsPage {

    // declaring webdriver object and web elements that will be used in this class
    private WebDriver driver;
    private By LinksFromSearchResults;

    // Initializing the constructor for this class
    public GoogleSearchResultsPage(WebDriver driver) {
	this.driver = driver;
    }

    /**
     * Note: the second result Link start from index [3]
     * @param resultIndex the index for the result links
     * @param expectedResultText the expected result text which contained within the link
     */
    public void assertResultLinkForSpecificResultIndex(int resultIndex, String expectedResultText) {
	LinksFromSearchResults = By.xpath("//*[@id=\"rso\"]/div[" + resultIndex + "]//a/h3");
	Assertions.assertElementAttribute(driver, LinksFromSearchResults, "Text",
		expectedResultText, AssertionComparisonType.CONTAINS, AssertionType.POSITIVE);
    }
}