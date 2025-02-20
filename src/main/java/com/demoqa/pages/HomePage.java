package com.demoqa.pages;

import com.demoqa.elements.ElementPages;
import com.demoqa.forms.FormsPage;
import com.base.BasePage;
import com.demoqa.widgets.WidgetsPage;
import org.openqa.selenium.By;

import static utilities.JavascriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private final By elementsCard =By.xpath("//div[@id='app']//h5[text()='Elements']");

    private By widgetsCard=By.xpath("//div[@id='app']//h5[text()='Widgets']");


    public FormsPage goToForms(){
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementPages goToElement(){
        scrollToElementJS(elementsCard);
        click(elementsCard);
        return new ElementPages();
    }

    public WidgetsPage goToWidgets() {
        scrollToElementJS(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage();
    }
}
