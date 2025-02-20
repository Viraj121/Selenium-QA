package com.demoqa.widgets;

import org.openqa.selenium.By;

import java.util.List;

import static utilities.JavascriptUtility.*;
import static utilities.DropDownUtility.*;


public class SelectMenuPage extends WidgetsPage{
    private By standardMultiSelect = By.id("cars");

    public void selectStandardMulti(String text) {
        scrollToElementJS(standardMultiSelect);
        selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMulti(int index) {
        scrollToElementJS(standardMultiSelect);
        selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value) {
        scrollToElementJS(standardMultiSelect);
        deselectValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedStandardMultiOptions(){
        return getAllSelectedOptions(standardMultiSelect);
    }
}
