package com.demoqa.pages;

import com.demoqa.elements.ElementPages;
import com.demoqa.forms.FormsPage;
import com.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavascriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private final By elemenetsCard=By.xpath("//div[@id='app']//h5[text()='Elements']");


    public FormsPage goToForms(){
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementPages goToElement(){
        scrollToElementJS(elemenetsCard);
        return new ElementPages();
    }
}
