package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablesPage extends ElementPages {

    private By registrationAgeField = By.id("age");
    private By submitButton = By.cssSelector("#submit");

    public void clickEdit(String email) {
        By edit = By.xpath("//div[text()='" + email + "']//following::span[@title='Edit'][1]");
        click(edit);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }


    public void clickSubmitButton() {
        try {
            WebElement element = driver.findElement(submitButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Exception encountered: " + e.getMessage());
        }
    }

    public String getTableAge(String email){
        By tableAge=By.xpath("//div[text()='"+ email +"']//preceding::div[1]");
        return find(tableAge).getText();
    }
}
