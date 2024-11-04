package com.demoqa.elements;

import org.openqa.selenium.By;

public class WebTablesPage extends ElementPages{

    private By registrationAgeField=By.id("age");
    private By submitButton=By.id("submit");

    public void clickEdit(String email) {
        By edit = By.xpath("//div[text()='"+email+"']//following::span[@title='Edit']");
        click(edit);
    }

    public void setAge(String age){
        set(registrationAgeField,age);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }

}
