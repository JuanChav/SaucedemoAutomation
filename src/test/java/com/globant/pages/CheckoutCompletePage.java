package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{
    @FindBy(className = "complete-header")
    private WebElement headerCompleteTxt;

    public String getHeaderComplete(){
        return this.headerCompleteTxt.getText();
    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
}
