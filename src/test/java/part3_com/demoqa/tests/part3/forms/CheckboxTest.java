package part3_com.demoqa.tests.part3.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckbox() {
       var formsPage=homePage.goToForms().clickPracticeForm();
       formsPage.clickReadingCheckbox();
       formsPage.clickMusicCheckbox();
       formsPage.clickSportsCheckbox();
       formsPage.unclickReadingCheckbox();


       boolean isReadingCheckboxSelected= formsPage.isReadingSelected();

       Assert.assertFalse(isReadingCheckboxSelected, "\n Reading checkbox already selected \n");
    }
}
