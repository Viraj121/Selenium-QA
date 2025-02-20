package part3_com.demoqa.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_com.demoqa.base.BaseTest;

import java.util.List;

public class SelectDropDownTest extends BaseTest {

    @Test
    public void testMultiSelectDropDown(){
        var selectMenuPage=homePage.goToWidgets().clickSelectMenu();
        selectMenuPage.selectStandardMulti("Volvo");
        selectMenuPage.selectStandardMulti(1);
        selectMenuPage.selectStandardMulti("Audi");
        selectMenuPage.selectStandardMulti(2);

        selectMenuPage.deselectStandardMulti("saab");

        List<String> actualSelectedOpions = selectMenuPage.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(actualSelectedOpions.contains("Volvo"));
        Assert.assertTrue(actualSelectedOpions.contains("Opel"));
        Assert.assertFalse(actualSelectedOpions.contains("Saab"),
                "\n Saab is selected as an option \n ");
        Assert.assertTrue(actualSelectedOpions.contains("Audi"));

    }
}
