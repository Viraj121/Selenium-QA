package part3_com.demoqa.elements;

import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() {
//        String email = "kierra@example.com";
//        String expectedAge = "34";

        var webTablePage = homePage.goToElement().clickWebTables();
        webTablePage.clickEdit("kierra@example.com");
        webTablePage.setAge("34");
        webTablePage.clickSubmitButton();

    }

}
