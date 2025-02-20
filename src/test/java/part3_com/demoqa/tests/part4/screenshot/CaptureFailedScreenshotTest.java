package part3_com.demoqa.tests.part4.screenshot;

import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

public class CaptureFailedScreenshotTest extends BaseTest {

    //make the testcase failed intentionally to take a screenshot on failed test.
    @Test
    public void testClick(){
        var practice=homePage.goToForms().clickPracticeForm();
        practice.clickSubmitButton();
    }
}
