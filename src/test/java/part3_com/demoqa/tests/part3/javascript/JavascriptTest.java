package part3_com.demoqa.tests.part3.javascript;

import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

public class JavascriptTest  extends BaseTest {

    @Test
    public void testScrollingToElement(){
        homePage.goToForms();
    }

}