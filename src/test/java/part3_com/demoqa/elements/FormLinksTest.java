package part3_com.demoqa.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

public class FormLinksTest extends BaseTest {
    @Test
    public void testLinks() {
        var linksPage = homePage.goToElement().clickLinks();
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();
        System.out.println(actualResponse);
        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }
}
