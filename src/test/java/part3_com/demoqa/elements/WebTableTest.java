package part3_com.demoqa.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() throws InterruptedException {
        var webTablePage = homePage.goToElement().clickWebTables();
        webTablePage.clickEdit("alden@example.com");
        webTablePage.setAge("21");
        webTablePage.clickSubmitButton();
        String actualAge= webTablePage.getTableAge("alden@example.com");

        System.out.println("Age retrieved: " + actualAge);
        String expectedAge="21";
        Assert.assertEquals(actualAge,expectedAge,"\n Actual & Expected age match \n");
    }
}
