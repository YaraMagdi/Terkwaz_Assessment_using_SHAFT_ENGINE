package tests.apitests;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CatFact {

    /**
     * Preform GET action to specified REST request URL
     * Validate the returned response body form specified URL is not empty
     */
    @Test(description = "TC004 - Validate returned response body is not empty")
    public void validateResponseIsNotEmpty() {
	RestActions apiObject = new RestActions("https://alexwohlbruck.github.io/cat-facts");
	Response catFact = apiObject.performRequest(RequestType.GET, 200, "/");
	Assertions.assertNull(RestActions.getResponseBody(catFact), AssertionType.NEGATIVE, "Will pass only if Response body is not empty!");
    }
}